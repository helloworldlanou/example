package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;

public class Util {
	Session session = null;
	HttpServletRequest request;
	HttpSession httpsession;
	HttpServletResponse response;
	int flag = 0;//�ж��ǲ��ǵ�һ�ε���

	//�������ѡ��ؼ�
	public String showDateSel(String input) {
		String s = "";
		if (flag == 0) {
			s += "<script language=\"JavaScript\" src=\"js/calendar/c1.js\" "
					+ "type=\"text/javascript\"></script>"
					+ "<script language=\"JavaScript\" src=\"js/calendar/c2.js\" "
					+ "type=\"text/javascript\"></script>"
					+ "<div id=\"overDiv\" style=\"position:absolute; visibility:hidden; z-index:1000;\"></div>";
		}
		flag = 1;
		s += "<a href=\"javascript:show_calendar('"
				+ input
				+ "');\">"
				+ "<img src=\"image/botton/sel_date.gif\" width=\"18\" height=\"18\" border=\"0\" />"
				+ "</a>";
		return s;
	}
	
	

	//����ҳ����ʾ��ʾ��Ϣ
	public String alertMsg(String msg) {
		String m = "<script>alert('";
		msg.replaceAll("<", "&lt;");
		msg.replaceAll(">", "&gt;");
		msg.replaceAll("\'", "\"");
		m += msg;
		m += "');</script>";

		return m;
	}

	//����1����������ʾ�����
	public String yesOrNo(Integer input) {
		if (input == 1)
			return "��";
		return "��";
	}

	//����ʾnull
	public String noNull(Object input) {
		if (input == null)
			return "";
		return input.toString();
	}

	public Double numNull(Object input) {
		if (noNull(input) == "")
			return 0.0;
		else
			return Double.valueOf(input.toString());
	}

	public String numEmpty(Double input) {
		if (input == 0)
			return "";
		else
			return input.toString();
	}

	public String showDate() {
		util.time.CalendarUtil show = new util.time.CalendarUtil();
		return show.showDate();
	}

	public String showTimeForWorldTime() {
		util.time.CalendarUtil show = new util.time.CalendarUtil();
		return show.showTimeForWorldTime();
	}

	/*   
	   //topҳ��ʹ�õ���ʾ��
	   public String showUser(HttpSession session){
	       Person p = (Person) session.getAttribute("user");
	       return p.getName()+"�� "+p.getUsername()+" �����ã��ϴε�¼ʱ�䣺"+p.getLastlogintime();
	   }
	   
	   //��ʾ�û�������
	   public String showUserName(HttpSession session){
	       Person p = (Person) session.getAttribute("user");
	       return p.getName();
	   }
	 */
	//�����������ʽ��
	public String showName(String name) {
		if (name.length() == 2)
			name = name.substring(0, 1) + "��" + name.substring(1, 2);
		return name;
	}

	/**
	 * ȥ���ַ�����html����
	 * @param htmlStr �ַ���
	 * @return ���
	 */
	public String htmlToStr(String htmlStr) {
		String result = "";
		boolean flag = true;
		if (htmlStr == null) {
			return null;
		}
		char[] a = htmlStr.toCharArray();
		int length = a.length;
		for (int i = 0; i < length; i++) {
			if (a[i] == '<') {
				flag = false;
				continue;
			}
			if (a[i] == '>') {
				flag = true;
				continue;
			}
			if (flag == true) {
				result += a[i];
			}
		}
		
		return result.toString().replaceAll("&nbsp;", "").replace("&ldquo;", "��").replace("&rdquo;", "��").replace("&lsquo;", "��").replace("&rsquo;", "��");
	}
	
	
	public String getFirstImg(String htmlStr)
	{
		String result = "";
		result = htmlStr.substring(htmlStr.indexOf("src="),htmlStr.length()-1);
		result = result.substring(result.indexOf("/>"));
		return result;
	}

	public static void main(String[] args) {
		//System.out.println(new util.Util().showDateSel("form1.q1"));

	}

}
