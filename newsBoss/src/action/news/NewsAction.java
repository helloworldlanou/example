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
			int mark1 = 0; //标志是否有二级菜单
			int mark2 = 0; //标志是否有头条新闻
			String top = "0"; //设置初始头条新闻状态
			String picture = "0"; //设置初始图片新闻新闻状态
			String en = "0";
			String enclosure = "";
			int mark3 = 0; //设置专题报道状态,为1时表示此新闻为专题
			int mark4 = 0; //标志是否有图片新闻
			int mark5 = 0; //标志是否是英文新闻
			String small = "";//小类的ID
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
						////System.out.println("获取的表单名字："+item.getFieldName()+"------------"+"获取的表单值："+item.getString("UTF-8"));
						if (item.getString("UTF-8").equals("-2")) //表示是专题报道
						{
							mark3 = 1;
						}
						if (item.getFieldName().equals("top")) //是头条新闻时，需把以前的头条新闻状态改变，因为只有一个头条新闻
						{

							top = "1";

						}
						if (item.getFieldName().equals("picture")) //图片新闻，是按获取的表单名来判断该字段属于那项
						{
							picture = "1";
						}
						if (item.getFieldName().equals("en")) //英文新闻，是按获取的表单名来判断该字段属于那项
						{
							//mark5=1;
							en = "1";
						}
						if (item.getFieldName().equals("NclassId")) //有二级菜单
						{
							if (para.get("NclassId") != null
									&& !para.get("NclassId").equals("")) {
								mark1 = 1;
								//System.out.println("二级菜单下的值是："+para.get("NclassId"));
							}
						}
						if (item.getFieldName().equals("small") && mark3 == 1) //是专题而且有小类的话
						{
							System.out.println("small");
							System.out
									.println("有小类菜单下的值是：" + para.get("small"));
							small = para.get("small");
						}

					}

					else {
						if (item.getName() != null
								&& !item.getName().equals("")) {
							//System.out.println("上传文件的大小:" + item.getSize());
							//System.out.println("上传文件的类型:" + item.getContentType());
							// item.getName()返回上传文件在客户端的完整路径名称
							//System.out.println("上传文件的名称:" + item.getName());

							int last = item.getName().lastIndexOf("\\");
							String temString = item.getName().substring(
									last + 1)
									+ "/";

							//输出长传附件的后缀名
							String read = item.getName().substring(last + 1);
							String suffix = read.substring(read
									.lastIndexOf("."));
							//System.out.println("附件后缀名："+suffix);

							String uuid = java.util.UUID.randomUUID()
									.toString();

							temString = uuid + suffix + "*" + temString; //附件名字为：uuid*真实名称
							enclosure = enclosure + temString; //在上传附件时记录附件的名字
							//System.out.println("上传时显示一次："+enclosure);
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
			if (para.get("MyTextarea").length() > 0) { //判断新闻内容是否为空

				BoNews b = new BoNews();

				//System.out.println("mark3==="+mark3);
				if (mark3 == 1) //是否添加专题
				{

					BoSpecial b1 = new BoSpecial();
					b1.setId(para.get("NclassId"));
					//System.out.println("专题添加。。。。。。。。。。。。"+para.get("NclassId"));
					b.setBoSpecial(b1); //添加专题名字
					BoSpecial b2 = new BoSpecial();
					b2.setId(small);
					b.setSpecialSmall(b2);

				} else {
					//System.out.println("mark1==="+mark1);
					if (mark1 == 1) //判断是否有二级菜单
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
						"yyyy-MM-dd hh:mm:ss"); //设置时间存储格式

				if (time.length() <= 10) {
					time += new util.time.CalendarUtil().getOnlyTimeForDB();
				}
				date = sdf.parse(time);
				b.setNewsTime(date);
				b.setNewsEnclo(enclosure);
				b.setEn(en);

				BoParameterService boParameter = (BoParameterService) ServiceFactory
						.instance().getService("boParameterService");
				BoParameter boP = boParameter.getBoParameter("0"); //获取审核信息

				String check = boP.getNewscheck();

				b.setNewsCheck(check);
				b.setNewsPicture(picture);
				b.setNewsViewtimes(0);

				if (top.equals("1")) //如果是头条新闻还得判断是英文头条还是中文头条
				{
					if (en.equals("1")) //英文头条写入
					{
						BoNews abo = boNewsService.getTopBoNewsEn();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					} else { //中文头条写入
						BoNews abo = boNewsService.getTopBoNews();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					}
				}
				b.setNewsTop(top);

				boNewsService.addBoNews(b);

				request.setAttribute("right", "恭喜，添加成功！");

			} else {
				request.setAttribute("remind", "添加失败！新闻内容为空，请重新输入！");
			}

			return mapping.findForward("toManagePage");
		} else if (request.getParameter("action").equals("toAddNewsPage")) {
			BoNavigationService boNavigationService = (BoNavigationService) ServiceFactory
					.instance().getService("boNavigationService");
			List rootList = boNavigationService.getNodeManage();
			List mainList = boNavigationService.getBoNavigationRootList();
			//获取专题信息
			BoSpecialService bospecial = (BoSpecialService) ServiceFactory
					.instance().getService("boSpecialService");
			List special = bospecial.getAllBoSpecial();

			BoNewsService boNewsService = (BoNewsService) ServiceFactory
					.instance().getService("boNewsService");
			List news = boNewsService.getAllBoSmallNews();

			List Small = boNavigationService.getNodeManageSmall();
			//System.out.println("单页信息型的个数："+Small.size());

			//System.out.println("新闻小类的个数："+news.size());

			String tem[] = new String[50];
			int num = 0;
			BoNews bo = new BoNews();
			BoNavigation bn = new BoNavigation();

			for (int i = 0; i < news.size(); i++) //查找到目前新闻表中已经存在的属于info型的Navigation的ID，并记录到tem中
			{
				bo = (BoNews) news.get(i);
				for (int j = 0; j < Small.size(); j++) {
					bn = (BoNavigation) Small.get(j);
					if (bo.getBoNavigationByNewsSmall().getId().equals(
							bn.getId())) {
						tem[num] = bn.getId();
						//System.out.println("已经有的info型新闻id："+tem[num]);
						num++;
						break;

					}

				}
			}

			for (int i = 0; i < rootList.size(); i++) //将rooslist中删去已经添加的info型新闻，使add_news.jsp中不刷出该菜单项
			{
				bn = (BoNavigation) rootList.get(i);
				for (int j = 0; j < num; j++) {
					if (bn.getId().equals(tem[j])) {
						//System.out.println("将要删除的"+bn.getName());
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
			//System.out.println("相同的个数："+num);
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

				for (int i = 0; i < enclo.length; i++) //通过UUId来删除附件
				{
					int n = enclo[i].indexOf("*");
					enclo[i] = enclo[i].substring(0, n);
					//System.out.println(enclo[i]+"要删除的附件");
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

			String oldEnclosure = bo.getNewsEnclo(); //保留原始的附件内容，此字段与最后获得的新附件内容比较来删除附件
			String[] old = oldEnclosure.split("/"); //把附件字段拆开
			String[] original = new String[old.length];

			if (oldEnclosure.endsWith("/"))
				for (int i = 0; i < old.length; i++) {
					int n = old[i].indexOf("*");
					original[i] = old[i].substring(n + 1);
					old[i] = old[i].substring(0, n);
					//System.out.println(old[i]+"原始的附件名字");

				}

			request.setAttribute("mes", bo);
			int i = 0;
			int mark1 = 0; //标志是否有二级菜单
			String top = "0"; //设置初始头条新闻状态
			String picture = "0"; //设置初始图片新闻新闻状态
			String en = "0";
			String enclosure = "";
			int mark3 = 0; //设置专题报道状态,为1时表示此新闻为专题
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
						//System.out.println("获取的表单名字："+item.getFieldName()+"------------"+"‘修改’获取的表单值："+item.getString("UTF-8"));
						if (item.getString("UTF-8").equals("-2")) //表示是专题报道
						{
							mark3 = 1;
						}
						if (item.getFieldName().equals("top")) //是头条新闻时，需把以前的头条新闻状态改变，因为只有一个头条新闻
						{

							top = "1";

						}
						if (item.getFieldName().equals("picture")) //图片新闻，是按获取的表单名来判断该字段属于那项
						{
							picture = "1";
						}
						if (item.getFieldName().equals("en")) //英文新闻，是按获取的表单名来判断该字段属于那项
						{
							en = "1";
						}
						if (item.getFieldName().equals("NclassId")) //有二级菜单
						{
							if (para.get("NclassId") != null
									&& !para.get("NclassId").equals("")) {
								mark1 = 1;
								//System.out.println("二级菜单下的值是："+para.get("NclassId"));
							}
						}

						aa[i] = item.getString("UTF-8");

						if (item.getFieldName().equals("check")) //获取新的附件字段
						{
							//System.out.println("剩下的附件："+item.getString("UTF-8"));

							for (int h = 0; h < old.length; h++) //将保留下来的附件附上原始的UUID
							{
								if (item.getString("UTF-8").equals(original[h])) {
									String tem = old[h] + "*"
											+ item.getString("UTF-8") + "/";
									enclosure = enclosure + tem;
								}
							}
						}

						//System.out.println(item.getString("UTF-8")+"修改后的值"+item.getFieldName()+"(()))");

					}

					else {
						if (item.getName() != null
								&& !item.getName().equals("")) {
							//System.out.println("上传文件的大小:" + item.getSize());
							//System.out.println("上传文件的类型:" + item.getContentType());
							// item.getName()返回上传文件在客户端的完整路径名称
							//System.out.println("上传文件的名称:" + item.getName());
							int last = item.getName().lastIndexOf("\\");
							String temString = item.getName().substring(
									last + 1)
									+ "/";

							//输出长传附件的后缀名
							String read = item.getName().substring(last + 1);
							String suffix = read.substring(read
									.lastIndexOf("."));
							//System.out.println("附件后缀名："+suffix);

							String uuid = java.util.UUID.randomUUID()
									.toString();

							temString = uuid + suffix + "*" + temString;
							//在上传附件时记录附件的名字

							enclosure = enclosure + temString; //有新附件时添加到字段中
							//System.out.println("上传时显示二次："+enclosure+"((((((((((((((((((((((");
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
			if (para.get("MyTextarea").length() > 0) { //判断新闻内容是否为空

				if (mark3 == 1) //是否添加专题
				{

					BoSpecial b4 = new BoSpecial();
					b4.setId(para.get("NclassId"));
					bo.setBoSpecial(b4);

					BoSpecial b5 = new BoSpecial();
					b5.setId(para.get("small"));
					bo.setSpecialSmall(b5);
					
					bo.setBoNavigationByNewsBig(null);
					bo.setBoNavigationByNewsSmall(null);

				} else //如果不是专题，那就添加到大小类中
				{
					//System.out.println("mairk1="+mark1);
					if (mark1 == 1) //判断是否有二级菜单
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
						"yyyy-MM-dd hh:mm:ss"); //设置时间存储格式
				if (time.length() <= 10) {
					time += new util.time.CalendarUtil().getOnlyTimeForDB();
				}

				date = sdf.parse(time);

				bo.setNewsTime(date);
				bo.setNewsPicture(picture);

				bo.setEn(en);

				if (top.equals("1")) //如果是头条新闻还得判断是英文头条还是中文头条
				{
					if (en.equals("1")) //英文头条写入
					{
						//System.out.println("修改英文头条");
						BoNews abo = boNewsService.getTopBoNewsEn();
						if (abo != null) {
							//System.out.println(abo.getEn()+"--"+abo.getNewsTop()+"--"+abo.getNewsName());
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					} else { //中文头条写入
						//System.out.println("修改中文头条");
						BoNews abo = boNewsService.getTopBoNews();
						if (abo != null) {
							abo.setNewsTop("0");
							boNewsService.updateBoNews(abo);
						}
					}
				}
				bo.setNewsTop(top);

				bo.setNewsEnclo(enclosure);
				//System.out.println("修改后附件的内容变为："+enclosure);
				String[] newEnclosure = enclosure.split("/");//新的附件内容
				//System.out.println("共有几个附件"+newEnclosure.length);
				if (enclosure.endsWith("/")) //判断附件是否以“/”结束，如果不是，则说明没有附件
				{
					for (int g = 0; g < newEnclosure.length; g++) //提取附件中的uuid名
					{
						int n = newEnclosure[g].indexOf("*");

						newEnclosure[g] = newEnclosure[g].substring(0, n);
						//System.out.println(newEnclosure[g]+"新的附件名字");

					}
				}

				for (int ii = 0; ii < old.length; ii++) //根据原始附件字段和新附件字段逐个比较删除不要的附件
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
				//request.setAttribute("right", "恭喜，修改成功");   //修改成功
				return new ActionForward(
						"/newsManageAction.do?action=toManagePage");
			}

			else {
				request.setAttribute("remind", "新闻修改失败！新闻内容为空，请重新输入！");
			}

			//重新加载时显示最新修改后的内容

			String enclo = bo.getNewsEnclo();
			//System.out.println(enclo+"修改后附件的内容");
			if (enclo != null) {
				String[] newEnclo = enclo.split("/");
				request.setAttribute("enclo", newEnclo);
			}

			//System.out.println("附件内容是："+"12345678");
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

			request.setAttribute("rootList", rootList); //获取所有大小类
			request.setAttribute("mainList", mainList); //获取大类字段
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
					//System.out.println(enclosure[i]+"要传给修改页面时的附件名字");

				}
				request.setAttribute("enclo", enclosure);
			}
			String name = "";
			String id = "";
			////System.out.println("小类的ID是："+b.getNewsSmall());

			//  String smallid=b.getNewsSmall();
			// BoNavigation boNav =boNavigationService.getBoNavigation(smallid);
			////System.out.println(b.getBoNavigationByNewsSmall().getId());
			if (b.getBoNavigationByNewsSmall() != null) //如果小类ID不为空，需要获得小类的ID和名字作为二级菜单显示
			{
				BoNavigation boNav = boNavigationService.getBoNavigation(b
						.getBoNavigationByNewsSmall().getId());

				//System.out.println("小类ID不为空！！");
				name = boNav.getName();
				id = boNav.getId();
			}

			if (b.getBoSpecial() != null) //如果专题ID不为空，需要获得专题的ID和名字作为二级菜单显示
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
			request.setAttribute("specialsize", special.size()); //获取专题的名称
			request.setAttribute("special", special);

			request.setAttribute("smallname", name); //用于二级菜单的显示名字
			request.setAttribute("smallid", id); //用于二级菜单的id显示
			request.setAttribute("mes", b);
			request.setAttribute("secl", boNavigationService.getSecondNodeList());
			List sl = bospecial.getSmallBoSpecial();
			request.setAttribute("sl", sl);
			return mapping.findForward("toModifyPage");
		}

		return null;
	}

}
