package action.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.system.BoDepartment;
import model.system.BoNode;
import model.system.BoRole;
import model.system.BoPerson;
import model.system.BoRoleNode;
import model.system.DtreeNode;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.system.BoDepartmentService;
import service.system.BoNodeService;
import service.system.BoRoleNodeService;
import service.system.BoRoleService;
import service.system.BoPersonService;
import util.TokenProcessor;
import factory.ServiceFactory;

public class RoleAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("action").equals("toManagePage")){
			tableInit(mapping,form,request,response);
			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("roleManage")){
			tableInit(mapping,form,request,response);
			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		else if(request.getParameter("action").equals("toSelectIcon")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
			List fileList = boDepartmentService.listFile(request.getRealPath("/")+"\\image\\icon\\dtree");
			request.getSession().setAttribute("fileList",fileList);
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			BoRole b = boRoleService.getBoRole("0");
			String icon  = b.getIcon();
			treeInit( mapping,  form,
					 request,  response); 
			request.setAttribute("icon", icon);
			return mapping.findForward("toIconPage");	
		}
		else if(request.getParameter("action").equals("selectIcon")){
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
	
			String icon = request.getParameter("icon");
			
			BoRole bdid0 = boRoleService.getBoRole("0");
			bdid0.setIcon(icon);
			bdid0.setIconOpen(icon);
			boRoleService.updateBoRole(bdid0);
			treeInit( mapping,  form,
					 request,  response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("toAddRole")){
			BoRoleService ds = (BoRoleService)ServiceFactory.instance().getService("boRoleService");		
			String id = request.getParameter("id");
			if(id==null){
				id = "0";
			}
			BoRole n = ds.getBoRole(id);
			request.setAttribute("n", n);
			 treeInit( mapping,  form,
						 request,  response);
			return mapping.findForward("toAddPage");		
		}
		
		else if(request.getParameter("action").equals("addRole")){
			BoRoleService ds = (BoRoleService)ServiceFactory.instance().getService("boRoleService");		

			BoRole p = new BoRole();
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String des = request.getParameter("des");
			p.setDes(des);
			p.setName(name);
			p.setParentId(id);
			p.setDispIndex(ds.getMaxDispIndex()+1);
			ds.addBoRole(p);
			//
			 treeInit( mapping,  form,
					 request,  response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("toModifyPage")){
			BoRoleService s = (BoRoleService)ServiceFactory.instance().getService("boRoleService");		
			String id = request.getParameter("id");
			BoRole n = s.getBoRole(id);
			request.setAttribute("n", n);
			treeInit( mapping,  form, request,  response);
			return mapping.findForward("toModifyPage");		
		}
		
		else if(request.getParameter("action").equals("modify")){
			BoRoleService ps = (BoRoleService)ServiceFactory.instance().getService("boRoleService");		
			String id = request.getParameter("id");
			BoRole p = ps.getBoRole(id);
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			p.setDes(des);
			p.setName(name);
			ps.updateBoRole(p);
			 treeInit( mapping,  form,
						 request,  response);
			 BoRole n = ps.getBoRole(id);
			 request.setAttribute("n", n);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("delete")){
			
			String id = request.getParameter("id");
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			boRoleService.deleteBoRole(id);
			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		else if(request.getParameter("action").equals("to_role_person")){
			
			String id = request.getParameter("id");
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			//boRoleService.deleteBoRole(id);
			treeInit(mapping,form,request,response);
			depTreeInit(mapping,form,request,response);
			defaultPersonChecked(mapping,form,request,response);
			request.setAttribute("roleId", id);
			return mapping.findForward("to_role_person");		
		}
		
		else if(request.getParameter("action").equals("role_person")){
			BoPersonService s = (BoPersonService)ServiceFactory.instance().getService("boPersonService");		
			String roleId = request.getParameter("roleId");
			//BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			//boRoleService.deleteBoRole(id);
			
			//depTreeInit(mapping,form,request,response);
			BoPersonService boPersonService = (BoPersonService)ServiceFactory.instance().getService("boPersonService");				
			List list = boPersonService.getBoPersonByRoleId(roleId);
			for(Iterator it = list.iterator();it.hasNext();)
			{
				BoPerson b = (BoPerson)it.next();
				b.setRoleId("");
				s.updateBoPerson(b);
			}
			
			String[] dtreeCheckBox = request.getParameterValues("dTreeChk");
			if(dtreeCheckBox!=null)
			{
				for(int i=0;i<dtreeCheckBox.length;i++)
				{
					
					if(s.hasBoPerson(dtreeCheckBox[i])&&!dtreeCheckBox[i].equals("0"))
					{
						
						BoPerson b = s.getBoPerson(dtreeCheckBox[i]);
						b.setRoleId(roleId);
						s.updateBoPerson(b);
						
					}
					
				}
			}
			
			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("to_role_right")){
			String id = request.getParameter("id");
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			BoRoleNodeService boRoleNodeService = (BoRoleNodeService)ServiceFactory.instance().getService("boRoleNodeService");				

			List list = boRoleNodeService.getListByRoleId(id);
			String defaultChecked ="";
			for(Iterator it = list.iterator();it.hasNext();)
			{
				BoRoleNode b = (BoRoleNode)it.next();
				defaultChecked+=b.getNodeId()+",";
			}
			request.setAttribute("defaultChecked", defaultChecked);
			
			//boRoleService.deleteBoRole(id);
			treeInit(mapping,form,request,response);
			BoNodeService boNodeService = (BoNodeService)ServiceFactory.instance().getService("boNodeService");				
			nodeInit(mapping,form,request,response);
			request.setAttribute("roleId", id);
			return mapping.findForward("to_role_right");		
		}
		
		else if(request.getParameter("action").equals("role_right")){
			String roleId = request.getParameter("roleId");
			BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
			//boRoleService.deleteBoRole(id);
			//treeInit(mapping,form,request,response);
			BoNodeService boNodeService = (BoNodeService)ServiceFactory.instance().getService("boNodeService");				
			BoRoleNodeService boRoleNodeService = (BoRoleNodeService)ServiceFactory.instance().getService("boRoleNodeService");				

			//nodeInit(mapping,form,request,response);
			String[] dtreeCheckBox = request.getParameterValues("dTreeChk");
			if(dtreeCheckBox!=null)
			{
			List list = boRoleNodeService.getListByRoleId(roleId);
			for(Iterator it = list.iterator();it.hasNext();)
			{
				BoRoleNode b = (BoRoleNode)it.next();
				boRoleNodeService.deleteBoRoleNode(b.getId());
			}
			for(int i=0;i<dtreeCheckBox.length;i++)
			{
				//System.out.println("++++++++++"+dtreeCheckBox[i]);
				if(!dtreeCheckBox[i].equals("0")){
				if(!boRoleNodeService.hasBoRoleNode(roleId,dtreeCheckBox[i]))
				{
					BoRoleNode n = new BoRoleNode();
					n.setNodeId(dtreeCheckBox[i]);
					n.setRoleId(roleId);
					boRoleNodeService.addBoRoleNode(n);
				}
				
				}
			}
			}
			else
			{
				List list = boRoleNodeService.getListByRoleId(roleId);
				for(Iterator it = list.iterator();it.hasNext();)
				{
					BoRoleNode b = (BoRoleNode)it.next();
					boRoleNodeService.deleteBoRoleNode(b.getId());
				}
			}
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		return mapping.findForward("toManagePage");
	}
	
	public void tableInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
		String id = request.getParameter("id");
		if(id==null){
			id = "0";
		}
		BoRole n =boRoleService.getBoRole(id);	
		request.setAttribute("n", n);
		request.setAttribute("canDelete", boRoleService.canDeleteBoRole(id));
		}
	
	public void treeInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoRoleService boRoleService = (BoRoleService)ServiceFactory.instance().getService("boRoleService");				
		BoPersonService boPersonService = (BoPersonService)ServiceFactory.instance().getService("boPersonService");				

		List list = boRoleService.getNodeManage();
		BoRole bdid0 = boRoleService.getBoRole("0");
		String bdIcon = bdid0.getIcon();
		String bdIconOpen = bdid0.getIconOpen();
		
		BoPerson bpid0 = boPersonService.getBoPerson("0");
		String bpIcon = bpid0.getIcon();
		String bpIconOpen = bpid0.getIconOpen();
		
		List depList = new ArrayList();
		for(Iterator it = list.iterator();it.hasNext();)
		{
			BoRole bd = (BoRole)it.next();
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
			dn.setUrl("roleAction.do?action=roleManage&id="+bd.getId());
			depList.add(dn);
			List l = boPersonService.getBoPersonByRoleId(dn.getId());
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
				dn1.setParentId(bp.getRoleId());
				dn1.setTarget("");
				dn1.setTitle("");
				dn1.setUrl("roleAction.do?action=roleManage");
				depList.add(dn1);
			}
		}
		java.util.Collections.sort(depList);
		request.setAttribute("depList", depList);
			}
	
	
	public void depTreeInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
		BoPersonService boPersonService = (BoPersonService)ServiceFactory.instance().getService("boPersonService");				

		List list = boDepartmentService.getNodeManage();
		BoDepartment bdid0 = boDepartmentService.getBoDepartment("0");
		String bdIcon = bdid0.getIcon();
		String bdIconOpen = bdid0.getIconOpen();
		
		BoPerson bpid0 = boPersonService.getBoPerson("0");
		String bpIcon = bpid0.getIcon();
		String bpIconOpen = bpid0.getIconOpen();
		
		List depList = new ArrayList();
		for(Iterator it = list.iterator();it.hasNext();)
		{
			BoDepartment bd = (BoDepartment)it.next();
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
			dn.setUrl("departmentAction.do?action=departmentManage&id="+bd.getId());
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
		request.setAttribute("checkList", depList);
			}
	
	public void defaultPersonChecked(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
			{
		BoPersonService boPersonService = (BoPersonService)ServiceFactory.instance().getService("boPersonService");				
		String roleId = request.getParameter("id");
		List list = boPersonService.getBoPersonByRoleId(roleId);
		String defaultChecked ="";
		for(Iterator it = list.iterator();it.hasNext();)
		{
			BoPerson b = (BoPerson)it.next();
			defaultChecked+=b.getId()+",";
		}
		request.setAttribute("defaultChecked", defaultChecked);
		}

	

	
	
	public void nodeInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoNodeService boNodeService = (BoNodeService)ServiceFactory.instance().getService("boNodeService");				

		List list = boNodeService.getNodeManage();
		
		List nodeList = new ArrayList();
		for(Iterator it = list.iterator();it.hasNext();)
		{
			BoNode bd = (BoNode)it.next();
			DtreeNode dn = new DtreeNode();
			dn.setDispindex(bd.getDispIndex());
			dn.setIcon(bd.getIcon());
			dn.setIconOpen(bd.getIconOpen());
			dn.setId(bd.getId());
			dn.setName(bd.getName());
			dn.setOpen("true");
			dn.setParentId(bd.getParentId());
			dn.setTarget("");
			dn.setTitle("");
			dn.setUrl("roleAction.do?action=roleManage&id="+bd.getId());
			nodeList.add(dn);
			
		}
		java.util.Collections.sort(nodeList);
		request.setAttribute("checkList", nodeList);
			}
	
}
