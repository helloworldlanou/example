/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package action.management;

import java.io.File;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.management.BoParameter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.management.BoParameterService;
import factory.ServiceFactory;

public class ParameterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getParameter("action").equals("toModifyInfo")){
			BoParameterService boParameterService = (BoParameterService)ServiceFactory.instance().getService("boParameterService");
			BoParameter parameter = boParameterService.getBoParameter("0");
			request.getSession().setAttribute("parameter", parameter);
			return mapping.findForward("toModifyInfo");		
		}
		
		else if(request.getParameter("action").equals("modifyInfo")){

			int i=0;
			String enclosure = "";
			String[]parameter=new String[10];
			request.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			 String fileName= "";
			try {
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
					   //System.out.println(item.getString()+"#############"+i);
					   parameter[i]=item.getString("UTF-8");
					   //System.out.println(parameter[i]+"#############");
					   i++;
					  
					}
					
					else {
						if (item.getName() != null && !item.getName().equals("")) {
							String ext = item.getName().substring(item.getName().indexOf("."),item.getName().length());
							fileName = java.util.UUID.randomUUID().toString()+ext;
							//System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
							//System.out.println("�ϴ��ļ�������:" + item.getContentType());
							// item.getName()�����ϴ��ļ��ڿͻ��˵�����·������
							//System.out.println("�ϴ��ļ�������:" + item.getName());
							 
							int last =item.getName().lastIndexOf("\\");
							String temString=item.getName().substring(last+1)+"/";
                            enclosure =enclosure + temString;
                            //System.out.println("�ϴ�ʱ��ʾһ�Σ�"+enclosure);
							File tempFile = new File(item.getName());
							File file = new File(servlet.getServletContext().getRealPath("/")+"\\upload\\parameter\\", fileName);
							item.write(file);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				String title = parameter[1];
				String website = parameter[2];
		 		//String floatsite = "";
				String copyright = parameter[3];
				String email = parameter[4];
				String newscheck = "0";
				int guestnumber = 0;
				if(i==9){
					newscheck = "1";
					guestnumber = Integer.parseInt(parameter[6]);
				}else{
					newscheck = "0";
					guestnumber = Integer.parseInt(parameter[5]);
				}
				
				
				
				BoParameter b = (BoParameter)request.getSession().getAttribute("parameter");
				java.io.File bigDelFile = new java.io.File(servlet.getServletContext().getRealPath("/")+"\\upload\\facility\\"+b.getFloatsite());
			    bigDelFile.delete();
				b.setTitle(title);
				b.setWebsite(website);
				if(fileName.length()>0)
				{
					b.setFloatsite(fileName);
				}
				
				b.setCopyright(copyright);
				b.setEmail(email);
				b.setNewscheck(newscheck);
				b.setGuestnumber(guestnumber);
				
				
				
				BoParameterService boParameterService = (BoParameterService)ServiceFactory.instance().getService("boParameterService");				
				boParameterService.updateBoParameter(b);
				request.getSession().setAttribute("parameter", b);
				request.setAttribute("right", "�޸ĳɹ�");
	
			return mapping.findForward("toModifyInfo");		
		}
		
		return null;
	}
	


}