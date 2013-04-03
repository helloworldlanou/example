package action.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.management.BoNavigation;
import model.system.BoNode;
import model.system.BoPerson;
import model.system.DtreeNode;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.management.BoNavigationService;
import service.news.BoNewsService;
import service.system.BoNodeService;
import service.system.BoPersonService;
import util.TokenProcessor;
import factory.ServiceFactory;

public class NavigationAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("action").equals("toManagePage")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("NavigationManage")){
			
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
			request.setAttribute("type", "dep");
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			
			request.getSession().setAttribute("nodeList",request.getParameter("deplist"));
			request.getSession().setAttribute("selectnid",request.getParameter("id"));
			if(!request.getParameter("id").equals("0")){
				BoNavigation n = boNavigationService.getBoNavigation((String)request.getSession().getAttribute("selectnid"));
				request.getSession().setAttribute("n",n);
				request.getSession().setAttribute("canUp",boNavigationService.canUp((String)request.getSession().getAttribute("selectnid")));
				request.getSession().setAttribute("canDown",boNavigationService.canDown((String)request.getSession().getAttribute("selectnid")));
				BoNavigation fn = boNavigationService.getNodeParent((String)request.getSession().getAttribute("selectnid"));
				request.getSession().setAttribute("fn",fn);
				}
				else{
					BoNode n = new BoNode();
					n.setId("0");
					n.setType("father");
					n.setName("系统模块树");
					n.setTitle("系统模块树");
					request.getSession().setAttribute("n",n);
				}

			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("moveUp")){
			TokenProcessor processor = TokenProcessor.getInstance();
			if(processor.isTokenValid(request)){
				processor.resetToken(request);
				BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
				boNavigationService.moveUp(request.getParameter("id"));
				//初始化右侧页面内容
				request.setAttribute("type", "dep");
				treeInit( mapping,form,request,response);
				tableInit( mapping,form,request,response);
				
				request.getSession().setAttribute("nodeList",request.getParameter("deplist"));
				request.getSession().setAttribute("selectnid",request.getParameter("id"));
			if(!request.getParameter("id").equals("0")){
				BoNavigation n = boNavigationService.getBoNavigation((String)request.getSession().getAttribute("selectnid"));
				request.getSession().setAttribute("n",n);
				request.getSession().setAttribute("canUp",boNavigationService.canUp((String)request.getSession().getAttribute("selectnid")));
			request.getSession().setAttribute("canDown",boNavigationService.canDown((String)request.getSession().getAttribute("selectnid")));
			BoNavigation fn = boNavigationService.getNodeParent((String)request.getSession().getAttribute("selectnid"));
			request.getSession().setAttribute("fn",fn);
			}
			else{
				BoNode n = new BoNode();
				n.setId("0");
				n.setType("father");
				request.getSession().setAttribute("n",n);
				n.setName("系统模块树");
				n.setTitle("系统模块树");
			}

			}
			else{
				processor.saveToken(request);
				//System.out.println("重复提交！");
			}
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("moveDown")){
			TokenProcessor processor = TokenProcessor.getInstance();
			if(processor.isTokenValid(request)){
				processor.resetToken(request);
				BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
				boNavigationService.moveDown(request.getParameter("id"));
				//初始化右侧页面内容
				request.setAttribute("type", "dep");
				treeInit( mapping,form,request,response);
				tableInit( mapping,form,request,response);
				
				request.getSession().setAttribute("nodeList",request.getParameter("deplist"));
				request.getSession().setAttribute("selectnid",request.getParameter("id"));
			if(!request.getParameter("id").equals("0")){
				BoNavigation n = boNavigationService.getBoNavigation((String)request.getSession().getAttribute("selectnid"));
				request.getSession().setAttribute("n",n);
				request.getSession().setAttribute("canUp",boNavigationService.canUp((String)request.getSession().getAttribute("selectnid")));
			request.getSession().setAttribute("canDown",boNavigationService.canDown((String)request.getSession().getAttribute("selectnid")));
			BoNavigation fn = boNavigationService.getNodeParent((String)request.getSession().getAttribute("selectnid"));
			request.getSession().setAttribute("fn",fn);
			}
			else{
				BoNode n = new BoNode();
				n.setId("0");
				n.setType("father");
				request.getSession().setAttribute("n",n);
				n.setName("系统模块树");
				n.setTitle("系统模块树");
			}

			}
			else{
				processor.saveToken(request);
				//System.out.println("重复提交！");
			}
			return mapping.findForward("toManagePage");			
		}
		
		else if(request.getParameter("action").equals("toAddNavigation")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toAddPage");		
		}
		
		else if(request.getParameter("action").equals("addNavigation")){
			if(request.getParameter("name").length()>0){
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
			
			String id = request.getParameter("id");
			if(!id.equals("0"))
			{
				BoNavigation fn = boNavigationService.getNodeParent(id);
				request.setAttribute("fn", fn);
			}
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			String type = request.getParameter("pointtype");
			String url = request.getParameter("url");
			String defaultchecked = request.getParameter("defaultchecked");
			String enname = request.getParameter("enname");
			String centershow = request.getParameter("centershow");
			List list1 = new ArrayList();
			if(defaultchecked!=null){
				if(defaultchecked.equals("checked"))
				{
					list1 = boNavigationService.getNodeManage();
					for(Object b:list1)
					{
						BoNavigation c = (BoNavigation)b;
						c.setDefaultchecked("unchecked");
						boNavigationService.updateBoNavigation(c);
					}
				}
			}
			else
			{
				
				defaultchecked = "unchecked";
			}
			
			String showup = request.getParameter("showup");
			
			BoNavigation d = new BoNavigation();
			d.setParentId(id);
			d.setDes(des);
			d.setName(name);
			d.setUrl(url);
			d.setEnname(enname);
			d.setDispIndex(boNavigationService.getMaxDispIndex()+1);
			d.setType(type);
			d.setDefaultchecked(defaultchecked);
			d.setCentershow(centershow);
			d.setShowup(showup);
			boNavigationService.addBoNavigation(d);

			BoNavigation fn = boNavigationService.getBoNavigation(d.getParentId());
			request.setAttribute("fn", fn);
			BoNavigation n =boNavigationService.getBoNavigation(id);	
			request.setAttribute("n", n);
			treeInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			request.setAttribute("right", "添加成功");
			
		}else{
			treeInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			request.setAttribute("remind", "名称不能为空");
		}
			return mapping.findForward("toAddPage");	
	}
		
		else if(request.getParameter("action").equals("toModifyPage")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toModifyPage");		
		}
		
		else if(request.getParameter("action").equals("modify")){
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");							
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			String type = request.getParameter("pointtype");
			String url = request.getParameter("url");
			String enname = request.getParameter("enname");
			String defaultchecked = request.getParameter("defaultchecked");
			String centershow = request.getParameter("centershow");
			String showup = request.getParameter("showup");

			List list1 = new ArrayList();
			if(defaultchecked!=null){
				if(defaultchecked.equals("checked"))
				{
					list1 = boNavigationService.getNodeManage();
					for(Object b:list1)
					{
						BoNavigation c = (BoNavigation)b;
						c.setDefaultchecked("unchecked");
						boNavigationService.updateBoNavigation(c);
					}
				}
			}
			else
			{
				
				defaultchecked = "unchecked";
			}
			
			BoNavigation d = boNavigationService.getBoNavigation(id);
			d.setCentershow(centershow);
			
			d.setDes(des);
			d.setName(name);
			d.setEnname(enname);
			d.setUrl(url);
			d.setDefaultchecked(defaultchecked);
			d.setShowup(showup);
			//System.out.println(type);
			//System.out.println("centershow========="+centershow);

			d.setType(type);
			boNavigationService.updateBoNavigation(d);
			BoNavigation fn = boNavigationService.getBoNavigation(d.getParentId());
			request.setAttribute("fn", fn);
			BoNavigation n =boNavigationService.getBoNavigation(id);	
			request.setAttribute("n", n);
			treeInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("toSelectIcon")){
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
			List fileList = boNavigationService.listFile(request.getRealPath("/")+"\\image\\icon\\dtree");
			request.getSession().setAttribute("fileList",fileList);

			BoNavigation bdid0 = boNavigationService.getBoNavigation("0");
			String bdIcon = bdid0.getIcon();
			request.setAttribute("icon", bdIcon);
			request.setAttribute("type", "dep");
			treeInit(mapping,form,request,response);
			return mapping.findForward("toIconPage");		
		}
		
		else if(request.getParameter("action").equals("selectIcon")){
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
			BoNavigation bdid0 = boNavigationService.getBoNavigation("0");
			bdid0.setIcon(request.getParameter("icon"));
			bdid0.setIconOpen(request.getParameter("icon"));
			boNavigationService.updateBoNavigation(bdid0);

			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("delete")){
			String id = request.getParameter("id");
			BoNewsService ns=(BoNewsService)ServiceFactory.instance().getService("boNewsService");
			if(ns.isBigTypenull(id)&&ns.isSmallTypenull(id)){
			BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");							
			boNavigationService.deleteBoNavigation(id);
			}else{
				request.setAttribute("remind", "此类下面有新闻，请先删除对应的新闻");
				}
			
			treeInit(mapping,form,request,response);
			
			return mapping.findForward("toManagePage");		
			
		}

		return mapping.findForward("toManagePage");
	}
	
	public void tableInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
		String id = request.getParameter("id");
		if(id==null){
			id = "0";
		}
		if(!id.equals("0"))
		{
			BoNavigation fn = boNavigationService.getNodeParent(id);
			request.setAttribute("fn", fn);
		}
		BoNavigation n =boNavigationService.getBoNavigation(id);	
		request.setAttribute("n", n);
		request.setAttribute("canDelete", boNavigationService.canDeleteBoNavigation(id));
		}
	
	public void treeInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoNavigationService boNavigationService = (BoNavigationService)ServiceFactory.instance().getService("boNavigationService");				
		BoPersonService boPersonService = (BoPersonService)ServiceFactory.instance().getService("boPersonService");				

		List list = boNavigationService.getNodeManage();
		BoNavigation bdid0 = boNavigationService.getBoNavigation("0");
		String bdIcon = bdid0.getIcon();
		String bdIconOpen = bdid0.getIconOpen();
		
		BoPerson bpid0 = boPersonService.getBoPerson("0");
		String bpIcon = bpid0.getIcon();
		String bpIconOpen = bpid0.getIconOpen();
		
		List depList = new ArrayList();
		for(Iterator it = list.iterator();it.hasNext();)
		{
			BoNavigation bd = (BoNavigation)it.next();
			DtreeNode dn = new DtreeNode();
			dn.setDispindex(bd.getDispIndex());
			dn.setIcon(bdIcon);
			dn.setIconOpen(bdIconOpen);
			dn.setId(bd.getId());
			dn.setName(bd.getName());
			dn.setOpen("true");
			dn.setParentId(bd.getParentId());
			dn.setTarget("");
			dn.setTitle("");
			dn.setUrl("navigationAction.do?action=NavigationManage&id="+bd.getId());
			depList.add(dn);
			List l = boPersonService.getBoPersonByParentId(dn.getId());
			for(Iterator it1 = l.iterator();it1.hasNext();)
			{
				DtreeNode dn1 = new DtreeNode();
				BoPerson bp = (BoPerson)it1.next();
				dn1.setDispindex(bp.getDispIndex());
				dn1.setIcon(bpIcon);
				dn1.setIconOpen(bpIconOpen);
				dn1.setId(bp.getId());
				dn1.setName(bp.getName());
				dn1.setOpen("true");
				dn1.setParentId(bp.getParentId());
				dn1.setTarget("");
				dn1.setTitle("");
				dn1.setUrl("personAction.do?action=personManage&id="+bp.getId());
				depList.add(dn1);
			}
		}
		java.util.Collections.sort(depList);
		request.setAttribute("depList", depList);
			}
}
