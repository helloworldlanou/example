package action.news;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DownloadAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fileName = request.getParameter("fileName");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		OutputStream fos = null;
		InputStream fis = null;

		// ����Ǵӷ�������ȡ����������ϵͳ�ľ���·�������� 
		String filepath = request.getRealPath("/"+"\\upload\\");
		filepath = filepath+fileName;
		//System.out.println("�ļ�·��" + filepath);
		File uploadFile = new File(filepath);
		fis = new FileInputStream(uploadFile);
		bis = new BufferedInputStream(fis);
		fos = response.getOutputStream();
		bos = new BufferedOutputStream(fos);
		// ����;��ǵ������ضԻ���Ĺؼ�����
		response.setHeader("Content-disposition", "attachment;filename="
				+ URLEncoder.encode(filepath, "utf-8"));
		int bytesRead = 0;
		// ����ط���ͬ�ϴ���һ�����ҾͲ���˵�ˣ������������������ȶ���Ȼ���������ȥд��Ψһ��ͬ�������õ��ǻ������������
		byte[] buffer = new byte[8192];
		while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}
		bos.flush();
		fis.close();
		bis.close();
		fos.close();
		bos.close();//System.out.print("");
		
		return null;

		
	}
}
