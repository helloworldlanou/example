package action.news;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.management.BoNavigation;
import model.management.BoParameter;
import model.management.BoSpecial;
import model.news.BoNews;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.management.BoNavigationService;
import service.management.BoParameterService;
import service.management.BoSpecialService;
import service.news.BoNewsService;
import factory.ServiceFactory;

public class NewsAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("action").equals("AddNews")) {

			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			BoSpecialService boSpecialService = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			int mark1 = 0; //��־�Ƿ��ж����˵�
			int mark2 = 0; //��־�Ƿ���ͷ������
			String top = "0"; //���ó�ʼͷ������״̬
			String picture = "0"; //���ó�ʼͼƬ��������״̬
			String en = "0";
			String enclosure = "";
			int mark3 = 0; //����ר�ⱨ��״̬,Ϊ1ʱ��ʾ������Ϊר��
			int mark4 = 0; //��־�Ƿ���ͼƬ����
			int mark5 = 0; //��־�Ƿ���Ӣ������
			String small = "";//С���ID
			Map<String, String> para = new HashMap<String, String>();
			request.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						// //System.out.println(item.getString("UTF-8")+"#############");

						para.put(item.getFieldName(), item.getString("UTF-8"));
						////System.out.println("��ȡ�ı����֣�"+item.getFieldName()+"------------"+"��ȡ�ı�ֵ��"+item.getString("UTF-8"));
						if (item.getString("UTF-8").equals("-2")) //��ʾ��ר�ⱨ��
						{
							mark3 = 1;
						}
						if (item.getFieldName().equals("top")) //��ͷ������ʱ�������ǰ��ͷ������״̬�ı䣬��Ϊֻ��һ��ͷ������
						{

							top = "1";

						}
						if (item.getFieldName().equals("picture")) //ͼƬ���ţ��ǰ���ȡ�ı������жϸ��ֶ���������
						{
							picture = "1";
						}
						if (item.getFieldName().equals("en")) //Ӣ�����ţ��ǰ���ȡ�ı������жϸ��ֶ���������
						{
							//mark5=1;
							en = "1";
						}
						if (item.getFieldName().equals("NclassId")) //�ж����˵�
						{
							if (para.get("NclassId") != null
									&& !para.get("NclassId").equals("")) {
								mark1 = 1;
								//System.out.println("�����˵��µ�ֵ�ǣ�"+para.get("NclassId"));
							}
						}
						if (item.getFieldName().equals("small") && mark3 == 1) //��ר�������С��Ļ�
						{
							System.out.println("small");
							System.out
									.println("��С��˵��µ�ֵ�ǣ�" + para.get("small"));
							small = para.get("small");
						}

					}

					else {
						if (item.getName() != null
								&& !item.getName().equals("")) {
							//System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
							//System.out.println("�ϴ��ļ�������:" + item.getContentType());
							// item.getName()�����ϴ��ļ��ڿͻ��˵�����·������
							//System.out.println("�ϴ��ļ�������:" + item.getName());

							int last = item.getName().lastIndexOf("\\");
							String temString = item.getName().substring(
									last + 1)
									+ "/";

							//������������ĺ�׺��
							String read = item.getName().substring(last + 1);
							String suffix = read.substring(read
									.lastIndexOf("."));
							//System.out.println("������׺����"+suffix);

							String uuid = java.util.UUID.randomUUID()
									.toString();

							temString = uuid + suffix + "*" + temString; //��������Ϊ��uuid*��ʵ����
							enclosure = enclosure + temString; //���ϴ�����ʱ��¼����������
							//System.out.println("�ϴ�ʱ��ʾһ�Σ�"+enclosure);
							File tempFile = new File(item.getName());
							File file = new File(servlet.getServletContext()
									.getRealPath("/")
									+ "\\upload\\", uuid + suffix);
							item.write(file);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (para.get("MyTextarea").length() > 0) { //�ж����������Ƿ�Ϊ��

				BoNews b = new BoNews();

				//System.out.println("mark3==="+mark3);
				if (mark3 == 1) //�Ƿ����ר��
				{

					BoSpecial b1 = new BoSpecial();
					b1.setId(para.get("NclassId"));
					//System.out.println("ר����ӡ�����������������������"+para.get("NclassId"));
					b.setBoSpecial(b1); //���ר������
					BoSpecial b2 = new BoSpecial();
					b2.setId(small);
					b.setSpecialSmall(b2);

				} else {
					//System.out.println("mark1==="+mark1);
					if (mark1 == 1) //�ж��Ƿ��ж����˵�
					{
						BoNavigation b2 = new BoNavigation();
						b2.setId(para.get("special"));
						BoNavigation b3 = new BoNavigation();
						b3.setId(para.get("NclassId"));
						b.setBoNavigationByNewsBig(b2);
						b.setBoNavigationByNewsSmall(b3);

						//BoSpecial b4= new BoSpecial();
						//b4.setId(null);
						//b.setBoSpecial(b4);

					} else {
						BoNavigation b2 = new BoNavigation();
						b2.setId(para.get("special"));
						b.setBoNavigationByNewsBig(b2);

						// //System.out.println("+++++++++++++++++++++++"+b.getBoNavigationByNewsSmall().getId());
					}
				}

				b.setNewsName(para.get("title"));
				b.setNewsAuthor(para.get("author"));
				b.setNewsSource(para.get("source"));
				b.setNewsContent(para.get("MyTextarea"));
				
				b.setNewsName2(para.get("title2"));
				b.setNewsNameSet(para.get("nameset"));
				//System.out.println("+++++++++++++++"+para.get("nameset"));
				//b.setNewsNameSet(para.get("nameset"));

				String time = para.get("time");
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss"); //����ʱ��洢��ʽ

				if (time.length() <= 10) {
					time += new util.time.CalendarUtil().getOnlyTimeForDB();
				}
				date = sdf.parse(time);
				b.setNewsTime(date);
				b.setNewsEnclo(enclosure);
				b.setEn(en);

				BoParameterService boParameter = (BoParameterService) ServiceFactory
						.instance().getService("boParameterService");
				BoParameter boP = boParameter.getBoParameter("0"); //��ȡ�����Ϣ

				String check = boP.getNewscheck();

				b.setNewsCheck(check);
				b.setNewsPicture(picture);
				b.setNewsViewtimes(0);

				if (top.equals("1")) //�����ͷ�����Ż����ж���Ӣ��ͷ����������ͷ��
				{
					if (en.equals("1")) //Ӣ��ͷ��д��
					{
						BoNews abo = boNewsService.getTopBoNewsEn();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					} else { //����ͷ��д��
						BoNews abo = boNewsService.getTopBoNews();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					}
				}
				b.setNewsTop(top);

				boNewsService.addBoNews(b);

				request.setAttribute("right", "��ϲ����ӳɹ���");

			} else {
				request.setAttribute("remind", "���ʧ�ܣ���������Ϊ�գ����������룡");
			}

			return mapping.findForward("toManagePage");
		} else if (request.getParameter("action").equals("toAddNewsPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			//��ȡר����Ϣ
			BoSpecialService bospecial = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			List special = bospecial.getAllBoSpecial();

			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			List news = boNewsService.getAllBoSmallNews();

			List Small = boNavigationService.getNodeManageSmall();
			//System.out.println("��ҳ��Ϣ�͵ĸ�����"+Small.size());

			//System.out.println("����С��ĸ�����"+news.size());

			String tem[] = new String[50];
			int num = 0;
			BoNews bo = new BoNews();
			BoNavigation bn = new BoNavigation();

			for (int i = 0; i < news.size(); i++) //���ҵ�Ŀǰ���ű����Ѿ����ڵ�����info�͵�Navigation��ID������¼��tem��
			{
				bo = (BoNews) news.get(i);
				for (int j = 0; j < Small.size(); j++) {
					bn = (BoNavigation) Small.get(j);
					if (bo.getBoNavigationByNewsSmall().getId().equals(
							bn.getId())) {
						tem[num] = bn.getId();
						//System.out.println("�Ѿ��е�info������id��"+tem[num]);
						num++;
						break;

					}

				}
			}

			for (int i = 0; i < rootList.size(); i++) //��rooslist��ɾȥ�Ѿ���ӵ�info�����ţ�ʹadd_news.jsp�в�ˢ���ò˵���
			{
				bn = (BoNavigation) rootList.get(i);
				for (int j = 0; j < num; j++) {
					if (bn.getId().equals(tem[j])) {
						//System.out.println("��Ҫɾ����"+bn.getName());
						rootList.remove(bn);
						i--;
					}
				}
			}

			for (int i = 0; i < mainList.size(); i++) {
				boolean del = true;
				bn = (BoNavigation) mainList.get(i);
				String id = bn.getId();
				int smallnum = boNavigationService.getBoNavigationSmallnum(id);
				if (smallnum == 0) {
					del = false;
					continue;
				}
				int notinfnum = boNavigationService
						.getBoNavigationnotinfnum(id);
				if (notinfnum > 0) {
					del = false;
					continue;
				}
				List info = boNavigationService.getinfoSmall(id);
				for (int tt = 0; tt < info.size(); tt++) {
					BoNavigation b = (BoNavigation) info.get(tt);
					if (boNewsService.getinfonewsnum(b.getId()) == 0) {
						del = false;
						break;
					}
				}
				if (del == true) {
					mainList.remove(i);
				}
			}
			//System.out.println("��ͬ�ĸ�����"+num);
			BoNavigation checked = boNavigationService.getCheckedBoNavigation();
			request.setAttribute("checked", checked);
			request.setAttribute("specialsize", special.size());

			request.setAttribute("special", special);
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);
			request.setAttribute("trLSize", rootList.size());

			List sl = bospecial.getSmallBoSpecial();
			request.setAttribute("sl", sl);
			return mapping.findForward("toAddPage");
		}

		else if (request.getParameter("action").equals("delete")) {
			BoNewsService s = (BoNewsService) ServiceFactory.instance()
					.getService("boNewsService");
			BoNews tem = s.getBoNews(request.getParameter("id"));
			//System.out.println(tem.getNewsEnclo()+"%%%%%%     %%%%%%%      %%%%%%     %%%%%%");
			String enclosure = tem.getNewsEnclo();

			//System.out.println(enclosure);
			if (enclosure.length() > 0) {
				String[] enclo = enclosure.split("/");

				for (int i = 0; i < enclo.length; i++) //ͨ��UUId��ɾ������
				{
					int n = enclo[i].indexOf("*");
					enclo[i] = enclo[i].substring(0, n);
					//System.out.println(enclo[i]+"Ҫɾ���ĸ���");
					File file = new File(servlet.getServletContext()
							.getRealPath("/")
							+ "\\upload\\", enclo[i]);
					file.delete();
				}
			}
			s.deleteBoNews(request.getParameter("id"));
			//return mapping.findForward("toManagePage");
			return new ActionForward("/newsManageAction.do?action=toManagePage");
		}

		else if (request.getParameter("action").equals("modifyNews")) {

			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			String newsid = request.getParameter("id");
			BoNews bo = boNewsService.getBoNews(newsid);

			String oldEnclosure = bo.getNewsEnclo(); //����ԭʼ�ĸ������ݣ����ֶ�������õ��¸������ݱȽ���ɾ������
			String[] old = oldEnclosure.split("/"); //�Ѹ����ֶβ�
			String[] original = new String[old.length];

			if (oldEnclosure.endsWith("/"))
				for (int i = 0; i < old.length; i++) {
					int n = old[i].indexOf("*");
					original[i] = old[i].substring(n + 1);
					old[i] = old[i].substring(0, n);
					//System.out.println(old[i]+"ԭʼ�ĸ�������");

				}

			request.setAttribute("mes", bo);
			int i = 0;
			int mark1 = 0; //��־�Ƿ��ж����˵�
			String top = "0"; //���ó�ʼͷ������״̬
			String picture = "0"; //���ó�ʼͼƬ��������״̬
			String en = "0";
			String enclosure = "";
			int mark3 = 0; //����ר�ⱨ��״̬,Ϊ1ʱ��ʾ������Ϊר��
			String[] aa = new String[10];
			Map<String, String> para = new HashMap<String, String>();
			request.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						//System.out.println(item.getString("UTF-8")+"#############"+i);

						para.put(item.getFieldName(), item.getString("UTF-8"));
						//System.out.println("��ȡ�ı����֣�"+item.getFieldName()+"------------"+"���޸ġ���ȡ�ı�ֵ��"+item.getString("UTF-8"));
						if (item.getString("UTF-8").equals("-2")) //��ʾ��ר�ⱨ��
						{
							mark3 = 1;
						}
						if (item.getFieldName().equals("top")) //��ͷ������ʱ�������ǰ��ͷ������״̬�ı䣬��Ϊֻ��һ��ͷ������
						{

							top = "1";

						}
						if (item.getFieldName().equals("picture")) //ͼƬ���ţ��ǰ���ȡ�ı������жϸ��ֶ���������
						{
							picture = "1";
						}
						if (item.getFieldName().equals("en")) //Ӣ�����ţ��ǰ���ȡ�ı������жϸ��ֶ���������
						{
							en = "1";
						}
						if (item.getFieldName().equals("NclassId")) //�ж����˵�
						{
							if (para.get("NclassId") != null
									&& !para.get("NclassId").equals("")) {
								mark1 = 1;
								//System.out.println("�����˵��µ�ֵ�ǣ�"+para.get("NclassId"));
							}
						}

						aa[i] = item.getString("UTF-8");

						if (item.getFieldName().equals("check")) //��ȡ�µĸ����ֶ�
						{
							//System.out.println("ʣ�µĸ�����"+item.getString("UTF-8"));

							for (int h = 0; h < old.length; h++) //�����������ĸ�������ԭʼ��UUID
							{
								if (item.getString("UTF-8").equals(original[h])) {
									String tem = old[h] + "*"
											+ item.getString("UTF-8") + "/";
									enclosure = enclosure + tem;
								}
							}
						}

						//System.out.println(item.getString("UTF-8")+"�޸ĺ��ֵ"+item.getFieldName()+"(()))");

					}

					else {
						if (item.getName() != null
								&& !item.getName().equals("")) {
							//System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
							//System.out.println("�ϴ��ļ�������:" + item.getContentType());
							// item.getName()�����ϴ��ļ��ڿͻ��˵�����·������
							//System.out.println("�ϴ��ļ�������:" + item.getName());
							int last = item.getName().lastIndexOf("\\");
							String temString = item.getName().substring(
									last + 1)
									+ "/";

							//������������ĺ�׺��
							String read = item.getName().substring(last + 1);
							String suffix = read.substring(read
									.lastIndexOf("."));
							//System.out.println("������׺����"+suffix);

							String uuid = java.util.UUID.randomUUID()
									.toString();

							temString = uuid + suffix + "*" + temString;
							//���ϴ�����ʱ��¼����������

							enclosure = enclosure + temString; //���¸���ʱ��ӵ��ֶ���
							//System.out.println("�ϴ�ʱ��ʾ���Σ�"+enclosure+"((((((((((((((((((((((");
							File tempFile = new File(item.getName());
							File file = new File(servlet.getServletContext()
									.getRealPath("/")
									+ "\\upload\\", uuid + suffix);
							item.write(file);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (para.get("MyTextarea").length() > 0) { //�ж����������Ƿ�Ϊ��

				if (mark3 == 1) //�Ƿ����ר��
				{

					BoSpecial b4 = new BoSpecial();
					b4.setId(para.get("NclassId"));
					bo.setBoSpecial(b4);

					BoSpecial b5 = new BoSpecial();
					b5.setId(para.get("small"));
					bo.setSpecialSmall(b5);
					
					bo.setBoNavigationByNewsBig(null);
					bo.setBoNavigationByNewsSmall(null);

				} else //�������ר�⣬�Ǿ���ӵ���С����
				{
					//System.out.println("mairk1="+mark1);
					if (mark1 == 1) //�ж��Ƿ��ж����˵�
					{
						BoNavigation b2 = new BoNavigation();
						b2.setId(para.get("special"));
						bo.setBoNavigationByNewsBig(b2);
						BoNavigation b3 = new BoNavigation();
						b3.setId(para.get("NclassId"));
						//System.out.println("sssssssss"+para.get("NclassId"));
						bo.setBoNavigationByNewsSmall(b3);
						bo.setBoSpecial(null);
						bo.setSpecialSmall(null);
						/*
						BoSpecial b4= new BoSpecial();
						b4.setId(null);
						bo.setBoSpecial(b4);	
						 */

					} else {

						BoNavigation b2 = new BoNavigation();
						b2.setId(para.get("special"));
						bo.setBoNavigationByNewsBig(b2);
						bo.setBoNavigationByNewsSmall(null);
						bo.setBoSpecial(null);
						bo.setSpecialSmall(null);

					}
				}

				bo.setNewsName(para.get("title"));
				bo.setNewsAuthor(para.get("author"));
				bo.setNewsSource(para.get("source"));
				bo.setNewsContent(para.get("MyTextarea"));
				bo.setNewsName2(para.get("title2"));
				bo.setNewsNameSet(para.get("nameset"));

				String time = para.get("time");
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss"); //����ʱ��洢��ʽ
				if (time.length() <= 10) {
					time += new util.time.CalendarUtil().getOnlyTimeForDB();
				}

				date = sdf.parse(time);

				bo.setNewsTime(date);
				bo.setNewsPicture(picture);

				bo.setEn(en);

				if (top.equals("1")) //�����ͷ�����Ż����ж���Ӣ��ͷ����������ͷ��
				{
					if (en.equals("1")) //Ӣ��ͷ��д��
					{
						//System.out.println("�޸�Ӣ��ͷ��");
						BoNews abo = boNewsService.getTopBoNewsEn();
						if (abo != null) {
							//System.out.println(abo.getEn()+"--"+abo.getNewsTop()+"--"+abo.getNewsName());
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					} else { //����ͷ��д��
						//System.out.println("�޸�����ͷ��");
						BoNews abo = boNewsService.getTopBoNews();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					}
				}
				bo.setNewsTop(top);

				bo.setNewsEnclo(enclosure);
				//System.out.println("�޸ĺ󸽼������ݱ�Ϊ��"+enclosure);
				String[] newEnclosure = enclosure.split("/");//�µĸ�������
				//System.out.println("���м�������"+newEnclosure.length);
				if (enclosure.endsWith("/")) //�жϸ����Ƿ��ԡ�/��������������ǣ���˵��û�и���
				{
					for (int g = 0; g < newEnclosure.length; g++) //��ȡ�����е�uuid��
					{
						int n = newEnclosure[g].indexOf("*");

						newEnclosure[g] = newEnclosure[g].substring(0, n);
						//System.out.println(newEnclosure[g]+"�µĸ�������");

					}
				}

				for (int ii = 0; ii < old.length; ii++) //����ԭʼ�����ֶκ��¸����ֶ�����Ƚ�ɾ����Ҫ�ĸ���
				{
					int j;
					for (j = 0; j < newEnclosure.length; j++) {
						if (old[ii].equals(newEnclosure[j])) {
							break;
						}

					}
					if (j == (newEnclosure.length)) {
						File file = new File(servlet.getServletContext()
								.getRealPath("/")
								+ "\\upload\\", old[ii]);
						file.delete();
					}

				}

				boNewsService.updateBoNews(bo);
				//request.setAttribute("right", "��ϲ���޸ĳɹ�");   //�޸ĳɹ�
				return new ActionForward(
						"/newsManageAction.do?action=toManagePage");
			}

			else {
				request.setAttribute("remind", "�����޸�ʧ�ܣ���������Ϊ�գ����������룡");
			}

			//���¼���ʱ��ʾ�����޸ĺ������

			String enclo = bo.getNewsEnclo();
			//System.out.println(enclo+"�޸ĺ󸽼�������");
			if (enclo != null) {
				String[] newEnclo = enclo.split("/");
				request.setAttribute("enclo", newEnclo);
			}

			//System.out.println("���������ǣ�"+"12345678");
			request.setAttribute("mes", bo);

			BoSpecialService specialservice = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");

			List specialList = specialservice.getAllBoSpecial();

			request.setAttribute("specialList", specialList);

			return mapping.findForward("toModifyPage");
		} else if (request.getParameter("action").equals("toModifyNewsPage")) {

			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();

			request.setAttribute("rootList", rootList); //��ȡ���д�С��
			request.setAttribute("mainList", mainList); //��ȡ�����ֶ�
			request.setAttribute("trLSize", rootList.size());
			BoNavigation checked = boNavigationService.getCheckedBoNavigation();
			request.setAttribute("checked", checked);
			BoNewsService s = (BoNewsService) ServiceFactory.instance()
					.getService("boNewsService");
			//System.out.println("id------------"+request.getParameter("id"));
			BoNews b = new BoNews();
			b = s.getBoNews(request.getParameter("id"));
			String enclo = null;
			enclo = b.getNewsEnclo();
			//System.out.println(enclo+"*****************");
			if (enclo != null) {
				String[] enclosure = enclo.split("/");
				for (int i = 0; i < enclosure.length; i++) {
					int n = enclosure[i].indexOf("*");
					enclosure[i] = enclosure[i].substring(n + 1);
					//System.out.println(enclosure[i]+"Ҫ�����޸�ҳ��ʱ�ĸ�������");

				}
				request.setAttribute("enclo", enclosure);
			}
			String name = "";
			String id = "";
			////System.out.println("С���ID�ǣ�"+b.getNewsSmall());

			//  String smallid=b.getNewsSmall();
			// BoNavigation boNav =boNavigationService.getBoNavigation(smallid);
			////System.out.println(b.getBoNavigationByNewsSmall().getId());
			if (b.getBoNavigationByNewsSmall() != null) //���С��ID��Ϊ�գ���Ҫ���С���ID��������Ϊ�����˵���ʾ
			{
				BoNavigation boNav = boNavigationService.getBoNavigation(b
						.getBoNavigationByNewsSmall().getId());

				//System.out.println("С��ID��Ϊ�գ���");
				name = boNav.getName();
				id = boNav.getId();
			}

			if (b.getBoSpecial() != null) //���ר��ID��Ϊ�գ���Ҫ���ר���ID��������Ϊ�����˵���ʾ
			{
				BoSpecialService bospecial = (BoSpecialService) ServiceFactory
						.instance().getService("boSpecialService");
				name = bospecial.getBoSpecial(b.getBoSpecial().getId())
						.getName();
				id = b.getBoSpecial().getId();
			}
			BoSpecialService bospecial = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			List special = bospecial.getAllBoSpecial();
			request.setAttribute("specialsize", special.size()); //��ȡר�������
			request.setAttribute("special", special);

			request.setAttribute("smallname", name); //���ڶ����˵�����ʾ����
			request.setAttribute("smallid", id); //���ڶ����˵���id��ʾ
			request.setAttribute("mes", b);
			request.setAttribute("secl", boNavigationService.getSecondNodeList());
			List sl = bospecial.getSmallBoSpecial();
			request.setAttribute("sl", sl);
			return mapping.findForward("toModifyPage");
		}

		return null;
	}

}
