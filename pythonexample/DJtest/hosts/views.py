# Create your views here.
# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response, get_object_or_404
from hosts.models import Host,CCRole
from django.forms.models import modelformset_factory
from django.template import RequestContext
from hosts.forms import HostForm,ConfigForm
from django.db.models import Q
from django.utils import simplejson
from django.http import HttpRequest,HttpResponse
import logging,os,glob,sys,commands,time
from django.core import serializers
from hosts.tasks import add_one_host,puppet_clean,delete_host,add_host_from_file,add_puppet_node,deploytask
from configs import dhcp_config
from datetime import date,datetime

reload(sys)
sys.setdefaultencoding("utf-8")

logger = logging.getLogger(__name__)
DEPLOY_CONF_PATH = "/opt/openstack/config/os_deploy.conf"
HOST_LOG_DIR = "/var/log/OADT/nodes/"
HOST_CONFIG_DIR = "/etc/puppet/files/"
OS_TYPE_PATH = '/opt/openstack/config/os_type.conf'
ISO_DIR = '/opt/openstack/upload/iso/'
HOST_TEMPLATE_DIR1 = '/opt/openstack/upload/template/'
HOST_TEMPLATE_DIR = '/opt/openstack/upload/hosts/host.template'
CCROLE_CONF_PATH = '/opt/openstack/config/openstack_deploy.conf'
PUPPET_CONF_DIR = "/etc/puppet/files/ns6.0/"
DEPLOY_RESULT_PATH = "/opt/openstack/config/deploy_result.conf"

def index(request):
	return render_to_response('hosts/index.html',RequestContext(request))

def __default(obj):
	if isinstance(obj, datetime):
		return obj.strftime('%Y-%m-%dT%H:%M:%S')
	elif isinstance(obj, date):
		return obj.strftime('%Y-%m-%d')
	else:
		raise TypeError('%r is not JSON serializable' % obj) 	

def hosts(request):
	logger.info("get all hosts.")
	#if request.method == "GET" and request.is_ajax():
	if request.method == "GET":
		#json = serializers.serialize('json', Host.objects.all(), fields=('id',))
		queryset =  Host.objects.all()
		host_list = []
		for row in queryset:
			row_set = serializers.serialize('json',row.ccrole_set.all())
			host_list.append({'hostname':row.hostname,'static_ip':row.static_ip,'timestamp':row.timestamp,'status':row.status,'hwaddr':row.hwaddr,'ccrole_set':row_set})
		json = simplejson.dumps(host_list,default=__default)
		#json = serializers.serialize('json', Host.objects.all(),use_natural_keys=True)
		#host_list = Host.objects.all()
		#json = simplejson.dumps(host_list)
	else :
		json = None	
	return HttpResponse(json,mimetype="aplication/json")

def roles(request,hostname):
	logger.info("get host cc roles and all not allocated.")
	response = HttpResponse()
	json = ""
	if request.method == "GET":
		json = serializers.serialize('json', CCRole.objects.filter(Q(host=hostname)|Q(host=None)))
	elif  request.method == "POST":
		host = get_object_or_404(Host,pk=hostname)
		logger.info("To update the host  %s roles." % hostname)
		roles = request.POST.getlist('ccrole')
		host.ccrole_set.clear()
		for rolename in roles:
			role = CCRole.objects.get(pk=rolename)
			if role:
				host.ccrole_set.add(role)
			logger.info("Host roles has been update.")
		#update roles config
		r = ccroles_nohost()
		if r:
			logger.info("has ccrole no host")
		else:
			# write role conf to CCROLE_CONF_PATH
			ccroles = CCRole.objects.all()
			f = open(CCROLE_CONF_PATH,'w')
			for ccrole in ccroles:
				host = ccrole.host
				if(ccrole.name == 'Keystone'):
					f.write('keystone_cc_ip '+host.static_ip +"\n")
				elif(ccrole.name == 'Glance'):
					f.write('glance_cc_ip '+host.static_ip+"\n")
				elif(ccrole.name == 'Nova'):
					f.write('nova_cc_ip '+host.static_ip+"\n")			
	return HttpResponse(json,mimetype="aplication/json")
	
def add(request):
	if request.method == 'POST':
		post = request.POST
		form = HostForm(request.POST)
		logger.info("add the host ." )
		ret = False
		response = HttpResponse()	
		if form.is_valid():		
			try:		
				form.save()
				h = Host.objects.get(pk = form.cleaned_data['hostname'])
				ret = True
				logger.info("Host has been added.")	
			except  Exception,ex:
				print Exception,":",ex
				response.status_code = 500
				h.delete()
				logger.error("add host error!" + str(ex))
				ret = str(ex)
		else:		
			logger.info("host info not valided")
			response.status_code = 500	
			ret = str(form.errors)	
		response.write(ret)
		return response	
		
def hosttemplate1(request):
	if request.method == 'GET':
		os.chdir(HOST_TEMPLATE_DIR)
		template_list = glob.glob('*')
		json = simplejson.dumps(template_list)	
		return HttpResponse(json,mimetype="aplication/json")	
		
def hosttemplate(request):
	response = HttpResponse()
	if request.method == "GET":
		f = open(HOST_TEMPLATE_DIR)
		template = f.read()
		f.close()
		response.write(template)
	elif request.method == "POST":
		template = request.POST['template']
		f = open(HOST_TEMPLATE_DIR,'w')
		f.write(template)
		f.close()
	return response
						
def batch_add1(request):
	response = HttpResponse()
	if request.method == 'POST':
		batch_file_dir = request.POST['batch_file_dir']
		if batch_file_dir:
			add_host_from_file.delay(batch_file_dir)
			response.write('True')
		return response	
		
def batch_add(request):
	response = HttpResponse()
	if request.method == 'POST':
		#add_host_from_file.delay(HOST_TEMPLATE_DIR)
		#response.write('True')
		logger.info("sudo sh /opt/openstack/scripts/add_host_from_file.sh %s" % HOST_TEMPLATE_DIR)
		p = commands.getstatusoutput("sh /opt/openstack/scripts/add_host_from_file.sh %s" % HOST_TEMPLATE_DIR)
		logger.info("result: "+ str(p[0])+p[1])
		if p[0]!=0:
			response.status_code = 500
			ret = "执行 /opt/openstack/scripts/add_host_from_file.sh 失败，请查看日志!"
			response.write(ret)
	return response			
	
def delete(request,hostname):
	ret = False	
	if request.method == 'POST':
		post = request.POST
		logger.info("To delete the host %s." % hostname)
		#host = Host.objects.get(pk=hostname)
		host = get_object_or_404(Host,pk=hostname)
		delete_host.delay(host)
		logger.info("run delete_host  %s" % hostname)
		host.delete()		
		logger.info("Host has been deleted.")	
		ret = True
	response = HttpResponse()
	response.write(ret)
	return response	
	
def cleanall(request):
	if request.method == 'POST':
		logger.info("clean all data!!")
		for host in Host.objects.all():
			logger.info("sh /opt/openstack/scripts/delete_host.sh %s %s" % (host.hostname , host.hwaddr))
			p = commands.getstatusoutput("sh /opt/openstack/scripts/delete_host.sh %s %s" % (host.hostname , host.hwaddr))
			logger.info("delete script result:"+str(p[1]))
#			delete_host.delay(host)
			host.delete()
		f = open(DEPLOY_RESULT_PATH,'w')
		f.write('0')
		f.close()
		logger.info("All data has been cleaned.")
		return HttpResponse("True")	
		
def update(request,hostname):
	host = get_object_or_404(Host,pk=hostname)
	ret = False	
	if request.method == 'POST':
		logger.info("To update the host %s." % hostname)
		post = request.POST
		form = HostForm(request.POST,instance=host)
		if form.is_valid():
			form.save()
			ret = True
			logger.info("Host has been update.")	
		else:
			logger.info("host info not valided")
	response = HttpResponse()
	response.write(ret)
	return response	

	
def hostlog(request,hostname):
	log = ''
	host = hostname
	if request.method == "GET" and host:
		f = open(HOST_LOG_DIR + hostname + '.log')
		logs = f.read()
		f.close()
	else:
		logs = 'No GET data'
	return render_to_response("hosts/logger.html",locals(),RequestContext(request))

def config(request,hostname):
	configs = ''
	response = HttpResponse()
	if request.method == "GET" and hostname:
		f = open(HOST_CONFIG_DIR + "ns6.0/" + hostname + '/local.conf')
		configs = f.read()
		f.close()
		response.write(configs)
	elif request.method == "POST" and hostname:
		configs = request.POST['configs']
		f = open(HOST_CONFIG_DIR + "ns6.0/" + hostname + '/local.conf','w')
		f.write(configs)
		f.close()
	return response
			
def dhcp(request):
	if request.method == 'GET':
		#json = serializers.serialize('json', dhcp_config)
		f = open(DEPLOY_CONF_PATH)
		lines = f.readlines()
		for line in lines:
			temp = line.split()
			dhcp_config[temp[0]] = temp[1]
		json = simplejson.dumps(dhcp_config)
		return HttpResponse(json,mimetype="aplication/json")
	elif request.method == 'POST':
		logger.info("post deploy configs")
		ret = False
		form = ConfigForm(request.POST)
		response = HttpResponse()
		if form.is_valid():
			for k in dhcp_config:
				dhcp_config[k] = form.cleaned_data[k]
			f = open(DEPLOY_CONF_PATH,'w')
			for k in dhcp_config:
				f.write(k+ ' ' + dhcp_config[k])
				f.write("\n")
			f.close()
			ret = True
			logger.info("update deploy configs success.")
			iso_addr = request.POST['iso_addr']
			if iso_addr[-4:] == '.iso':
				iso_addr = ISO_DIR + iso_addr
			print iso_addr
			logger.info("sh /opt/openstack/scripts/deploy.sh %s" % iso_addr)
			#p = os.system("/opt/openstack/scripts/deploy.sh %s" % iso_addr)
			#if(p!=0):
			#	ret = "sh deploy.sh false,please check the log !"
			#p = commands.getstatusoutput("sh /opt/openstack/scripts/deploy.sh %s" % iso_addr)
			#logger.info(str(p[0])+p[1])
			#if p[0]!=0:
			#	response.status_code = 500
			#	time.sleep(10)
			#	ret = "sh /opt/openstack/scripts/deploy.sh false,please check the log !"
			#	f = open(DEPLOY_RESULT_PATH,'w')
			#	f.write('2')
			#	f.close()	
			deploytask.delay(iso_addr)				
		else:
			response.status_code = 500
			ret = str(form.errors)
		response.write(ret)
		return response		
def deployresult(request):
	""" if result==1 then the deploy.sh  is finished"""
	if request.method == 'GET':
		f = open(DEPLOY_RESULT_PATH)
		line = f.readline()
		print line 
		f.close()
		return HttpResponse(line)
def ostype(request):
	if request.method == 'GET':
		f = open(OS_TYPE_PATH)
		line = f.readline()
		os_type = line.split()
		json = simplejson.dumps(os_type)
		return HttpResponse(json,mimetype="aplication/json")
	elif request.method == 'POST':
		logger.info("post to set ostype .")
		os_type = request.POST['OS_TYPE']
		f = open(OS_TYPE_PATH,'w')
		f.write('OS_TYPE' + ' ' + os_type)
		f.close()
		logger.info("set ostype success.")
		return HttpResponse('True')
		
def iso(request):
	if request.method == 'GET':
		os.chdir(ISO_DIR)
		iso_list = glob.glob('*.iso')
		json = simplejson.dumps(iso_list)	
		return HttpResponse(json,mimetype="aplication/json")

			
def ccroles_nohost():
	r = CCRole.objects.filter(host=None)
	if(len(r)>0):
		return r.values_list('name',flat=True)
	else:
		return None
		
def deploy(request,hostname):
	logger.info("deploy the certain host in table.")
	response = HttpResponse()
	r = ccroles_nohost()
	if r:
		response.status_code = 500
		response.write("请先设置 " + " ".join(r) + " 之后再进行此操作 !")	
	else:
		# set ccrole conf	
		host = get_object_or_404(Host,pk=hostname)
		if len(host.ccrole_set.all())>0:
			f1 = open(PUPPET_CONF_DIR+host.hostname+"/local.conf",'r')
			lines = f1.readlines()
			for line in lines:
				if line.find("NODE_TYPE") != -1:
					lines.remove(line)
			lines.insert(0,"NODE_TYPE cc\n")	
			f1 = open(PUPPET_CONF_DIR+host.hostname+"/local.conf",'w')	
			f1.writelines(lines)
			f1.close()
		else:
			f2 = open(PUPPET_CONF_DIR+host.hostname+"/local.conf",'r')
			lines = f2.readlines()
			for line in lines:
				if line.find("NODE_TYPE")!=-1 :
					lines.remove(line)
			lines.insert(0,"NODE_TYPE nc\n")
			f2 = open(PUPPET_CONF_DIR+host.hostname+"/local.conf",'w')	
			f2.writelines(lines)	
			f2.close()
		add_puppet_node.delay(host)	
	return response	

def cdpoint1(request):	
	p = os.popen("df|awk '$1~/\/dev\/sr/{print $1,$6}'",'r')
	lines = p.readlines()
	json = simplejson.dumps(lines)	
	return HttpResponse(json,mimetype="aplication/json")
	
def cdpoint(request):	
	cdrom = None
	json = None
	p = os.popen("dd if=/dev/sr0 count=1 bs=1 &>/dev/null && echo True",'r') 
	res = p.readline()
	print res
	if res.find("True")!=1:
		p = os.popen("ls /media",'r')
		cdrom = p.readline()
	if cdrom:
		json = simplejson.dumps("/dev/sr0 "+ cdrom)	
		print json
	p.close()
	return HttpResponse(json,mimetype="aplication/json")	
