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
	int flag = 0;//判断是不是第一次调用

	//输出日期选择控件
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
	
	

	//在网页中显示提示信息
	public String alertMsg(String msg) {
		String m = "<script>alert('";
		msg.replaceAll("<", "&lt;");
		msg.replaceAll(">", "&gt;");
		msg.replaceAll("\'", "\"");
		m += msg;
		m += "');</script>";

		return m;
	}

	//传入1或其他，显示是与否
	public String yesOrNo(Integer input) {
		if (input == 1)
			return "是";
		return "否";
	}

	//不显示null
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
	   //top页面使用的提示语
	   public String showUser(HttpSession session){
	       Person p = (Person) session.getAttribute("user");
	       return p.getName()+"（ "+p.getUsername()+" ）您好！上次登录时间："+p.getLastlogintime();
	   }
	   
	   //显示用户的姓名
	   public String showUserName(HttpSession session){
	       Person p = (Person) session.getAttribute("user");
	       return p.getName();
	   }
	 */
	//将姓名输出格式化
	public String showName(String name) {
		if (name.length() == 2)
			name = name.substring(0, 1) + "　" + name.substring(1, 2);
		return name;
	}

	/**
	 * 去掉字符串的html代码
	 * @param htmlStr 字符串
	 * @return 结果
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
		
		return result.toString().replaceAll("&nbsp;", "").replace("&ldquo;", "“").replace("&rdquo;", "”").replace("&lsquo;", "‘").replace("&rsquo;", "’");
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
