package action.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.system.BoDepartment;
import model.system.BoPerson;
import model.system.DtreeNode;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.system.BoDepartmentService;
import service.system.BoPersonService;
import util.TokenProcessor;
import factory.ServiceFactory;

public class DepartmentAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("action").equals("toManagePage")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("departmentManage")){
			request.setAttribute("type", "dep");
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("toAddDepartment")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toAddPage");		
		}
		
		else if(request.getParameter("action").equals("addDepartment")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
			
			String id = request.getParameter("id");
			if(!id.equals("0"))
			{
				BoDepartment fn = boDepartmentService.getNodeParent(id);
				request.setAttribute("fn", fn);
			}
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			BoDepartment d = new BoDepartment();
			d.setParentId(id);
			d.setDes(des);
			d.setName(name);
			d.setDispIndex(boDepartmentService.getMaxDispIndex());
			boDepartmentService.addBoDepartment(d);

			BoDepartment fn = boDepartmentService.getBoDepartment(d.getParentId());
			request.setAttribute("fn", fn);
			BoDepartment n =boDepartmentService.getBoDepartment(id);	
			request.setAttribute("n", n);
			treeInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			return mapping.findForward("toManagePage");		
		}
		
		
		else if(request.getParameter("action").equals("toModifyPage")){
			treeInit( mapping,form,request,response);
			tableInit( mapping,form,request,response);
			return mapping.findForward("toModifyPage");		
		}
		
		else if(request.getParameter("action").equals("modify")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");							
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String des = request.getParameter("des");
			
			BoDepartment d = boDepartmentService.getBoDepartment(id);
			d.setDes(des);
			d.setName(name);
			boDepartmentService.updateBoDepartment(d);
			BoDepartment fn = boDepartmentService.getBoDepartment(d.getParentId());
			request.setAttribute("fn", fn);
			BoDepartment n =boDepartmentService.getBoDepartment(id);	
			request.setAttribute("n", n);
			treeInit( mapping,form,request,response);
			request.setAttribute("type", "dep");
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("toSelectIcon")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
			List fileList = boDepartmentService.listFile(request.getRealPath("/")+"\\image\\icon\\dtree");
			request.getSession().setAttribute("fileList",fileList);

			BoDepartment bdid0 = boDepartmentService.getBoDepartment("0");
			String bdIcon = bdid0.getIcon();
			request.setAttribute("icon", bdIcon);
			request.setAttribute("type", "dep");
			treeInit(mapping,form,request,response);
			return mapping.findForward("toIconPage");		
		}
		
		else if(request.getParameter("action").equals("selectIcon")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
			BoDepartment bdid0 = boDepartmentService.getBoDepartment("0");
			bdid0.setIcon(request.getParameter("icon"));
			bdid0.setIconOpen(request.getParameter("icon"));
			boDepartmentService.updateBoDepartment(bdid0);

			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}
		
		else if(request.getParameter("action").equals("delete")){
			BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
			String id = request.getParameter("id");
			boDepartmentService.deleteBoDepartment(id);
			treeInit(mapping,form,request,response);
			return mapping.findForward("toManagePage");		
		}

		return mapping.findForward("toManagePage");
	}
	
	public void tableInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		BoDepartmentService boDepartmentService = (BoDepartmentService)ServiceFactory.instance().getService("boDepartmentService");				
		String id = request.getParameter("id");
		if(id==null){
			id = "0";
		}
		if(!id.equals("0"))
		{
			BoDepartment fn = boDepartmentService.getNodeParent(id);
			request.setAttribute("fn", fn);
		}
		BoDepartment n =boDepartmentService.getBoDepartment(id);	
		request.setAttribute("n", n);
		request.setAttribute("canDelete", boDepartmentService.canDeleteBoDepartment(id));
		}
	
	public void treeInit(ActionMapping mapping, ActionForm form,
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
		request.setAttribute("depList", depList);
			}
}
