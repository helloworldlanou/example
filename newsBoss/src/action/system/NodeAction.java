
package action.system;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.system.BoNode;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import service.system.BoNodeService;
import factory.ServiceFactory;


/** 
 * MyEclipse Struts
 * Creation date: 10-28-2008
 * 
 * XDoclet definition:
 * @struts.action
 * @struts.action-forward name="toManagePage" path="/WEB-INF/jsp/test/admin_test_manage.jsp"
 */
public class NodeAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("action").equals("toLoginPage")){
		return mapping.findForward("toLoginPage");		
		}
		if(request.getParameter("action").equals("login")){
			BoNodeService boNodeService = (BoNodeService)ServiceFactory.instance().getService("boNodeService");				
			request.getSession().setAttribute("selectedNodeId", "11");			
			List nodeFatherRootList = boNodeService.getNodeFatherRoot();
			List nodeChildList = boNodeService.getNodeChildByPid(request.getSession().getAttribute("selectedNodeId").toString());
			request.getSession().setAttribute("nodeFatherRootList", nodeFatherRootList);
			request.getSession().setAttribute("nodeChildList", nodeChildList);
			
			return mapping.findForward("toFramePage");		
		}
		return null;
	}
}