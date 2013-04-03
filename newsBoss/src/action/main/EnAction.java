package action.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.management.BoNavigation;
import model.management.BoSpecial;
import model.news.BoNews;
import model.system.PageList;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import service.facility.BoFacilityService;
import service.facility.BoFacilityTypeService;
import service.management.BoLinksService;
import service.management.BoLinksSortService;
import service.management.BoNavigationService;
import service.management.BoParameterService;
import service.management.BoSpecialService;
import service.news.BoNewsService;
import util.string.StringUtil;
import factory.ServiceFactory;

public class EnAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			HttpSession session=request.getSession();
		if (request.getParameter("action").equals("toIndexPage")) {
			BoParameterService boParameterService = (BoParameterService) ServiceFactory
					.instance().getService("boParameterService");

			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			// 导航栏节点
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);
			// 提取站点类别
			BoLinksSortService boLinksSortService = (BoLinksSortService) ServiceFactory
					.instance().getService("boLinksSortService");
			List linksSort = boLinksSortService.getAllBoLinksSort();
			request.setAttribute("linksSort", linksSort);
			// 提取站点
			BoLinksService boLinksService = (BoLinksService) ServiceFactory
					.instance().getService("boLinksService");
			List links = boLinksService.getAllBoLinks();
			request.setAttribute("links", links);
			// 提取专题
			BoSpecialService boSpecialService = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			List special = boSpecialService.getAllBoSpecial();
			request.setAttribute("special", special);
			// 获取新闻
			BoNewsService boNewsService = (BoNewsService) ServiceFactory
			.instance().getService("boNewsService");
			List centernews = boNewsService.getEnBoCenterNews();
			request.setAttribute("centernews", centernews);
			//获取培训动态
			List trainingnews = boNewsService.getEnBoTrainingNews();
			request.setAttribute("trainingnews", trainingnews);
			//获取精品项目
			List projectnews = boNewsService.getEnBoProjectNews();
			request.setAttribute("projectnews", projectnews);
			//图片新闻
			List picnews = boNewsService.getEnBoPicNews();
			List picURL = new ArrayList();//存储图片名
			StringUtil getPicURL = new StringUtil();
			for(int i=0;i<picnews.size();i++){
				picURL.add(getPicURL.getPicFromFckStr(((BoNews)picnews.get(i)).getNewsContent()));
			}
			request.setAttribute("picURL", picURL);
			request.setAttribute("picnews", picnews);
			// 头条新闻
			BoNews top = boNewsService.getTopBoNewsEn();
			if(top!=null){
			request.setAttribute("top", top);
			request.setAttribute("topContent", new util.Util().htmlToStr(top
					.getNewsContent()));
			
			request.setAttribute("topPic", new util.string.StringUtil()
					.getPicFromFckStr(top.getNewsContent()));
			}
			request.setAttribute("floatPic", boParameterService.getBoParameter(
					"0").getFloatsite());
			request.setAttribute("para", boParameterService.getBoParameter(
			"0"));
			return mapping.findForward("toIndexPage");
		}

		else if (request.getParameter("action").equals("toSecondaryPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);

			//System.out.println("pnid============="+request.getParameter("pnid"));
			//System.out.println("nid=============="+request.getParameter("nid"));

			String pnid = request.getParameter("pnid");
			String nid = request.getParameter("nid");
			
			

			if (nid == null || pnid == null) {

				BoLinksSortService boLinksSortService = (BoLinksSortService) ServiceFactory
						.instance().getService("boLinksSortService");
				List linksSort = boLinksSortService.getAllBoLinksSort();
				request.setAttribute("linksSort", linksSort);
				// 提取站点
				BoLinksService boLinksService = (BoLinksService) ServiceFactory
						.instance().getService("boLinksService");
				List links = boLinksService.getAllBoLinks();
				request.setAttribute("links", links);
				// 提取专题
				BoSpecialService boSpecialService = (BoSpecialService) ServiceFactory
						.instance().getService("boSpecialService");
				List special = boSpecialService.getAllBoSpecial();
				request.setAttribute("special", special);
				// 获取新闻
				BoNewsService boNewsService = (BoNewsService) ServiceFactory
						.instance().getService("boNewsService");
				List news = boNewsService.getAllBoNews();
				request.setAttribute("news", news);
				// 头条新闻
				BoNews top = boNewsService.getTopBoNews();
				request.setAttribute("top", top);
				return mapping.findForward("toIndexPage");
			} else {
				BoNavigation pn = boNavigationService.getBoNavigation(pnid);
				List nlist = boNavigationService
						.getBoNavigationListByParentId(pnid);
				request.setAttribute("nlist", nlist);
				request.setAttribute("pn", pn);
				request.setAttribute("nid", nid);
				if (!nid.equals("-1") && !nid.equals("-2")) {
					BoNavigation nn = boNavigationService.getBoNavigation(nid);
					request.setAttribute("nname", nn.getEnname());
					request.setAttribute("pageType", nn.getType());
					if(nn.getType().equals("info"))
					{
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
						.getService("boNewsService");
						BoNews n = s.getBoNewsBySmallType(nid,"1");
						request.setAttribute("detail", n);
						
					}
					if(nn.getType().equals("news"))
					{
						DynaActionForm pageListForm = (DynaActionForm) form;
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
								.getService("boNewsService");
						PageList pageList = new PageList();
						if (pageListForm.get("fetch") != null) {
							pageList.setFetch(Integer.parseInt(pageListForm.get("fetch")
									.toString()));
						}
						if (pageListForm.get("pagenum") != null) {
							pageList.setPagenum(Integer.parseInt(pageListForm
									.get("pagenum").toString()));
						}
						if (pageListForm.get("q1").toString().length()>0) {
							pageList.setQ1(pageListForm.get("q1").toString());
							//System.out.println("q1============"+pageListForm.get("q1").toString());
						}
						else
						{
							pageList.setQ1(pnid);
						}
						if (pageListForm.get("q2").toString().length()>0) {
							pageList.setQ2(pageListForm.get("q2").toString());
							//System.out.println("q2============"+pageListForm.get("q2").toString());

						}
						else
						{
							pageList.setQ2(nid);
						}
						Map map = s.getBoNewsMapForSecondaryPage(pageList,"1");
						pageList = (PageList) map.get("pageList");
						List list = (List) map.get("list");

						request.setAttribute("pageList", pageList);
						request.setAttribute("list", list);
					}
					
				} else if (nid.equals("-1")) {
					request.setAttribute("nname", ((BoNavigation) nlist.get(0))
							.getEnname());
					
					BoNavigation nn = boNavigationService.getBoNavigation(((BoNavigation) nlist.get(0)).getId());
					request.setAttribute("pageType", nn.getType());
					if(nn.getType().equals("info"))
					{
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
						.getService("boNewsService");
						BoNews n = s.getBoNewsBySmallType(((BoNavigation) nlist.get(0)).getId(),"1");
						request.setAttribute("detail", n);
						
					}
					if(nn.getType().equals("news"))
					{
						DynaActionForm pageListForm = (DynaActionForm) form;
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
								.getService("boNewsService");
						PageList pageList = new PageList();
						if (pageListForm.get("fetch") != null) {
							pageList.setFetch(Integer.parseInt(pageListForm.get("fetch")
									.toString()));
						}
						if (pageListForm.get("pagenum") != null) {
							pageList.setPagenum(Integer.parseInt(pageListForm
									.get("pagenum").toString()));
						}
						if (pageListForm.get("q1").toString().length()>0) {
							pageList.setQ1(pageListForm.get("q1").toString());
							//System.out.println("q1============"+pageListForm.get("q1").toString());
						}
						else
						{
							pageList.setQ1(pnid);
						}
						if (pageListForm.get("q2").toString().length()>0) {
							pageList.setQ2(pageListForm.get("q2").toString());
							//System.out.println("q2============"+pageListForm.get("q2").toString());

						}
						else
						{
							pageList.setQ2(nid);
						}
						Map map = s.getBoNewsMapForSecondaryPage(pageList,"1");
						pageList = (PageList) map.get("pageList");
						List list = (List) map.get("list");

						request.setAttribute("pageList", pageList);
						request.setAttribute("list", list);
					}
					
				} else {
					request.setAttribute("nname", pn.getEnname());
					request.setAttribute("pageType", pn.getType());
					if(pn.getType().equals("info"))
					{
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
						.getService("boNewsService");
						BoNews n = s.getBoNewsByBigType(pn.getId(),"1");
						request.setAttribute("detail", n);
						
					}
					if(pn.getType().equals("news"))
					{
						DynaActionForm pageListForm = (DynaActionForm) form;
						BoNewsService s = (BoNewsService) ServiceFactory.instance()
								.getService("boNewsService");
						PageList pageList = new PageList();
						if (pageListForm.get("fetch") != null) {
							pageList.setFetch(Integer.parseInt(pageListForm.get("fetch")
									.toString()));
						}
						if (pageListForm.get("pagenum") != null) {
							pageList.setPagenum(Integer.parseInt(pageListForm
									.get("pagenum").toString()));
						}
						if (pageListForm.get("q1").toString().length()>0) {
							pageList.setQ1(pageListForm.get("q1").toString());
							//System.out.println("q1============"+pageListForm.get("q1").toString());
						}
						else
						{
							pageList.setQ1(pnid);
						}
							pageList.setQ2("-1");

						
						Map map = s.getBoNewsMapForSecondaryPage(pageList,"1");
						pageList = (PageList) map.get("pageList");
						List list = (List) map.get("list");

						request.setAttribute("pageList", pageList);
						request.setAttribute("list", list);
					
					}
				}

			}
			return mapping.findForward("toSecondaryPage");
		}
		else if (request.getParameter("action").equals("toFacilityPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);
			BoFacilityTypeService s = (BoFacilityTypeService) ServiceFactory
					.instance().getService("boFacilityTypeService");
			String pnid = request.getParameter("pnid");
			String nid = request.getParameter("nid");
			request.setAttribute("pnid", pnid);
			request.setAttribute("nid", nid);
			if (nid == null || pnid == null) {

				BoLinksSortService boLinksSortService = (BoLinksSortService) ServiceFactory
						.instance().getService("boLinksSortService");
				List linksSort = boLinksSortService.getAllBoLinksSort();
				request.setAttribute("linksSort", linksSort);
				// 提取站点
				BoLinksService boLinksService = (BoLinksService) ServiceFactory
						.instance().getService("boLinksService");
				List links = boLinksService.getAllBoLinks();
				request.setAttribute("links", links);
				// 提取专题
				BoSpecialService boSpecialService = (BoSpecialService) ServiceFactory
						.instance().getService("boSpecialService");
				List special = boSpecialService.getAllBoSpecial();
				request.setAttribute("special", special);
				// 获取新闻
				BoNewsService boNewsService = (BoNewsService) ServiceFactory
						.instance().getService("boNewsService");
				List news = boNewsService.getAllBoNews();
				request.setAttribute("news", news);
				// 头条新闻
				BoNews top = boNewsService.getTopBoNews();
				request.setAttribute("top", top);
				return mapping.findForward("toIndexPage");
			} else {
				BoNavigation pn = boNavigationService.getBoNavigation(pnid);
				List nlist = boNavigationService
						.getBoNavigationListByParentId(pnid);
				request.setAttribute("nlist", nlist);
				request.setAttribute("pn", pn);
				
				request.setAttribute("nid", nid);
				if (!nid.equals("-1") && !nid.equals("-2")) {
					BoNavigation nn = boNavigationService.getBoNavigation(nid);
					request.setAttribute("nname", nn.getEnname());
				} else if (nid.equals("-1")) {
					request.setAttribute("nname", pn.getEnname());
				} else {
					request.setAttribute("nname", pn.getEnname());
				}
				
				BoFacilityService s1 = (BoFacilityService)ServiceFactory.instance().getService("boFacilityService");		
				BoFacilityTypeService s2 = (BoFacilityTypeService)ServiceFactory.instance().getService("boFacilityTypeService");		

				DynaActionForm pageListForm = (DynaActionForm)form;
				PageList pageList = new PageList();
				if(pageListForm.get("fetch")!=null){
				pageList.setFetch(Integer.parseInt(pageListForm.get("fetch").toString()));
				}
				if(pageListForm.get("pagenum")!=null){
				pageList.setPagenum(Integer.parseInt(pageListForm.get("pagenum").toString()));	
				}
				if(pageListForm.get("q1")!=null){
					pageList.setQ1(pageListForm.get("q1").toString());
					request.setAttribute("q1", pageListForm.get("q1").toString());
				}
				Map map = s1.getBoFacilityMap(pageList);
				pageList = (PageList)map.get("pageList");
				List list = (List)map.get("list");
				
				request.setAttribute("pageList", pageList);			
				request.setAttribute("list", list);
				
				List typeList = s2.getAllBoFacilityType();
				request.setAttribute("typeList", typeList);
				

			}

			return mapping.findForward("toFacilityPage");
		}

		else if (request.getParameter("action")
				.equals("toSpecialSecondaryPage")) {
			
			
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);
			BoSpecialService boSpecialService = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			BoSpecial bs = boSpecialService.getBoSpecial(request
					.getParameter("specialid"));
			request.setAttribute("special", bs);
			List slist = boSpecialService.getAllBoSpecial();
			request.setAttribute("slist", slist);
			//获取此专题下的新闻
			BoNewsService ns=(BoNewsService)ServiceFactory.instance().getService("boNewsService");
			
			List snewslist  = ns.getCnSpecialBoNews(bs.getId(), "1");
				
					
				request.setAttribute("snewslist", snewslist);
				
				String specialid = request.getParameter("specialid");
				List sl = boSpecialService.getSmallBoSpecialByPid(specialid);
				
				request.setAttribute("sl", sl);
			return mapping.findForward("toSpecialSecondaryPage");
		}


		else if (request.getParameter("action").equals("toDetailPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);

			String newsid = request.getParameter("newsid");
			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			BoNews news = boNewsService.getBoNews(newsid);
			if(news.getNewsViewtimes()==null){
				news.setNewsViewtimes(1);
			}
			else
			{
				news.setNewsViewtimes(news.getNewsViewtimes() + 1);

			}
			boNewsService.updateBoNews(news);
			request.setAttribute("news", news);
			String enclo = news.getNewsEnclo();
			String[] e = enclo.split("/");
			Map map = new HashMap();
			////System.out.println(""+e[0]);
			if(e[0].length()>1)
			{
				////System.out.println("附件.,..............");
				
				for(int i=0;i<e.length;i++)
				{
					
					int k = e[i].indexOf("*");
					String file1 = e[i].substring(0,k);
					String file2 = e[i].substring(k+1,e[i].length());
					//file2 = file2.substring(0,file2.indexOf("."));
					//System.out.println("=file1=="+file1);
					//System.out.println("=file2=="+file2);
					//map.put(m[0], m[1]);
					map.put(file1, file2);
				}
			}
			request.setAttribute("encloMap",map);
			return mapping.findForward("toDetailPage");
		}
		
		
		else if (request.getParameter("action").equals("toSpecialDetailPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			request.setAttribute("rootList", rootList);
			request.setAttribute("mainList", mainList);

			String newsid = request.getParameter("newsid");
			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			BoNews news = boNewsService.getBoNews(newsid);
			if(news.getNewsViewtimes()==null){
				news.setNewsViewtimes(1);
			}
			else
			{
				news.setNewsViewtimes(news.getNewsViewtimes() + 1);

			}
			boNewsService.updateBoNews(news);
			request.setAttribute("news", news);
			String enclo = news.getNewsEnclo();
			String[] e = enclo.split("/");
			Map map = new HashMap();
			////System.out.println(""+e[0]);
			if(e[0].length()>1)
			{
				////System.out.println("附件.,..............");
				
				for(int i=0;i<e.length;i++)
				{
					
					int k = e[i].indexOf("*");
					String file1 = e[i].substring(0,k);
					String file2 = e[i].substring(k+1,e[i].length());
					//file2 = file2.substring(0,file2.indexOf("."));
					//System.out.println("=file1=="+file1);
					//System.out.println("=file2=="+file2);
					//map.put(m[0], m[1]);
					map.put(file1, file2);
				}
			}
			request.setAttribute("encloMap",map);
			return mapping.findForward("toSpecialDetailPage");
		}

		else if (request.getParameter("action").equals("download")) {
			String fileName = request.getParameter("fileName");
			
			//System.out.println("文件为==============="+request.getParameter("fileName"));
			
			// 如果是从服务器上取就用这个获得系统的绝对路径方法。 
			String filepath = request.getRealPath("/"+"\\upload\\");
			filepath = filepath+"\\"+fileName;
			request.setAttribute("filepath", filepath);
			return mapping.findForward("downloadPage");   

		}
		
		return null;
	}

}
