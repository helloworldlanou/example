package util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.text.DateFormat;

public class CalendarUtil {
	TimeZone tz = TimeZone.getTimeZone("GMT+8");
	Calendar now = Calendar.getInstance(tz);
	public int year = now.get(Calendar.YEAR);
	public int month = now.get(Calendar.MONTH) + 1;
	public int day_of_month = now.get(Calendar.DAY_OF_MONTH);
	public int day_of_week = now.get(Calendar.DAY_OF_WEEK); // 周的第几天，星期日为1
	public int week_of_year = now.get(Calendar.WEEK_OF_YEAR);
	public int hh = now.get(Calendar.HOUR_OF_DAY);
	public int mm = now.get(Calendar.MINUTE);
	public int ss = now.get(Calendar.SECOND);
	public int dd = now.get(Calendar.MILLISECOND);
	String[] week = { "", "日", "一", "二", "三", "四", "五", "六" };// 年的第几周
	
	public String showDate() {
		return ("今天是：" + year + "年" + month + "月" + day_of_month + "日 星期"
				+ week[day_of_week] + "　　" + year + "年第" + week_of_year + "周");
	}
	
	public String getDate(){
		return(year + "-" + month + "-" + day_of_month + " " + hh + ":" + mm + ":" + ss);
	}

    public String getTimeForDB() {
        String result = year + "-" + twoChar(month) + "-"
                + twoChar(day_of_month) + " " + twoChar(hh) + ":" + twoChar(mm);
        return result;
    }
    
    public String getOnlyTimeForDB() {
    	return(" " + hh + ":" + mm + ":" + ss);
    }

    public String getDateForDB() {
        String result = year + "-" + twoChar(month) + "-" + twoChar(day_of_month)  ;
        return result;
    }

	private String twoChar(int input) {
		String result = new String("" + input);
		if (result.length() == 1) {
			result = "0" + result;
		}
		return result;
	}
	
	public String twoChar(String input) {

		if (input.length() == 1) {
			input = "0" + input;
		}
		return input;
	}
	
	private String threeChar(int input) {
		String result = new String("" + input);
		if (result.length() == 1) result = "00" + result;
		if (result.length() == 2) result = "0" + result;
		return result;
	}

	public String showTimeForWorldTime() {
		return year + "," + (month - 1) + "," + day_of_month + "," + hh + ","
				+ mm + "," + ss;
	}
	
	public String creatFileName(){
		return year+twoChar(month)+twoChar(day_of_month)+twoChar(hh)+twoChar(mm)+twoChar(ss)+threeChar(dd);
	}
	
	//取得当前日期是多少周
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	//取得当前日期所在周的第一天
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); 
		return c.getTime();
	}
	
	//得到当前所在周的每一天
	public static List getWeek(int year, int month, int date) {
		List result = new ArrayList();
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date);
		Date d = CalendarUtil.getFirstDayOfWeek(c.getTime());
		for (int i = 0; i < 7; i++) {
			Calendar gc = new GregorianCalendar();
			gc.setTime(d);
			gc.add(Calendar.DAY_OF_MONTH, i);
			gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
					.get(Calendar.DATE));
			result.add(gc);
		}
		return result;
	}
	
	//计算每周的同一天
	public static List getDayOfWeek(Date d1,Date d2){
		List result=new ArrayList();
		Calendar gc = new GregorianCalendar();
		gc.setTime(d1);
		Calendar gc2 = new GregorianCalendar();
		gc2.setTime(d2);
		for(;gc.compareTo(gc2)<=0;gc.add(Calendar.DAY_OF_MONTH, 7)){
			Calendar c = new GregorianCalendar();
			
			gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
					.get(Calendar.DATE));
			
			c.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
					.get(Calendar.DATE));
			result.add(c);
		}
		return result;
	}
	
	//计算两个时间之间的月份长度
	public static int monthNumber(java.util.Date start, java.util.Date end) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(start);
		int startMonth = calendar.get(Calendar.MONTH);
		int startYear = calendar.get(Calendar.YEAR);
		calendar.setTime(end);
		int endMonth = calendar.get(Calendar.MONTH);
		int endYear = calendar.get(Calendar.YEAR);
		int number = 1;
		if (endYear > startYear) {
			number = (endMonth - startMonth + 1) + (endYear - startYear) * 12;
		} else if (endYear < startYear) {
			number = -((startMonth - endMonth + 1) + (startYear - endYear) * 12);
		} else {
			if (endMonth >= startMonth) {
				number = endMonth - startMonth + 1;
			} else {
				number = -(startMonth - endMonth + 1);
			}
		}
		return number;
	}

	//计算每月的同一天
	public static List getDayOfMonth(Date d1, Date d2) {
		List result = new ArrayList();
		Calendar gc2 = new GregorianCalendar();
		gc2.setTime(d2);
		int index=CalendarUtil.monthNumber(d1,d2);
		for(int i=0;i<index;i++){
			Calendar c = new GregorianCalendar();
			c.setTime(d1);
			c.add(Calendar.MONTH,i);
			if(c.compareTo(gc2)>0) break;
			result.add(c);
		}
		return result;
	}
	
	public int getCuryear(){
		return year;
	}
	public int getCurmonth(){
		return month;
	}
	
	//得到两个时间之间的所有天
	public static List getDays(Date d1, Date d2){
		List result=new ArrayList();
		Calendar gc = new GregorianCalendar();
		gc.setTime(d1);
		Calendar gc2 = new GregorianCalendar();
		gc2.setTime(d2);
		for(;gc.compareTo(gc2)<=0;gc.add(Calendar.DAY_OF_MONTH, 1)){
			Calendar c = new GregorianCalendar();
			c.setTime(gc.getTime());
			result.add(c);
		}
		return result;
	}
	
	//计算两个String类型日期的间隔时间
	public int calculateDate(String from,String to){
		Calendar c1 = Calendar.getInstance(tz);
		Calendar c2 = Calendar.getInstance(tz);
		int result = 0;
		c1.set(Integer.parseInt(from.substring(0, 4)),Integer.parseInt(from.substring(5, 7)),Integer.parseInt(from.substring(8, 10)));
		c2.set(Integer.parseInt(to.substring(0, 4)),Integer.parseInt(to.substring(5, 7)),Integer.parseInt(to.substring(8, 10)));
		while(c1.compareTo(c2)<0){
			c1.add(c1.DAY_OF_MONTH, 1);
			result++;
		}
		return result;
	}
    public String getYear(String curdate){
    	String year = "";
    	try{
    		if(curdate == "" || curdate == null){
        		year = "    ";
        	}
        	else
        		year = curdate.substring(0,4);
    	}catch(Exception e){
    		year = "数据库数据有错误！";
    	}
    	  	
    	return year;
    }
    
    public String getMonth(String curdate){
    	String month = "";
    	try{
    		if(curdate == "" || curdate == null){
        		month = "  ";
        	}
        	else{
    	    	int temp1 = curdate.indexOf("-") +1;
    	    	int temp2 = curdate.lastIndexOf("-");
    	    	month = curdate.substring(temp1,temp2);
    	    	month = twoChar(month);
        	}
    	}catch(Exception e){
    		month = "数据库数据有错误";
    	}
    	   	
    	return month;
    }
    
    public static String formatDate(Date d)
    {
        TimeZone tz = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance(tz);
        cal.setTime(d);
        String tmp=cal.get(Calendar.YEAR)+"-";
        if(cal.get(Calendar.MONTH)<10)tmp+="0";
        tmp+=(cal.get(Calendar.MONTH)+1)+"-";
        if(cal.get(Calendar.DAY_OF_MONTH)<10)tmp+="0";
        tmp+=cal.get(Calendar.DAY_OF_MONTH)+" ";
        
        if(cal.get(Calendar.HOUR_OF_DAY)<10)tmp+="0";
        tmp+=cal.get(Calendar.HOUR_OF_DAY)+":";
        if(cal.get(Calendar.MINUTE)<10)tmp+="0";
        tmp+=cal.get(Calendar.MINUTE)+":";
        if(cal.get(Calendar.SECOND)<10)tmp+="0";
        tmp+=cal.get(Calendar.SECOND);
        return tmp;
    }
    
    //cong 0 zone -> 8 zone +8hours
    public static Date getBeijingDate(Date zdate)
    {
        long t=zdate.getTime();
        t+=8*60*60*1000;  //+8hours
        return new Date(t);
    }
    
    public String getDay(String curdate){
    	String day = "";
    	try{
    		if(curdate == "" || curdate == null){
        		day = "  ";
        	}
        	else{
        		int temp = curdate.trim().length();
        		if (temp > 10){
        			int temp1 = curdate.lastIndexOf("-") +1;
        	    	int temp2 = curdate.indexOf(" ");
        	    	day = curdate.substring(temp1, temp2);
        		}
        		else{
        			int temp1 = curdate.lastIndexOf("-") +1;
        	    	day = curdate.substring(temp1,temp);   	    	
        		}  
        		day = twoChar(day);
        	}
    	}catch(Exception e){
    		day = "数据库数据有错误";
    	}
    	
    	return day;
    }
    
    public String getHour(String curdate){
    	String hour = "";
    	
    	try{
    		if(curdate == "" || curdate == null || curdate.equals(" ")){
        		hour = "  ";
        	}
        	else{
    	    	int temp1 = curdate.indexOf(" ") +1;
    	    	int temp2 = curdate.indexOf(":");
    	    	hour = curdate.substring(temp1,temp2);
    	    	hour = twoChar(hour);
        	}
    	}catch(Exception e){
    		hour = "数据库数据有错误";
    	}
    	
    	return hour;
    }
    
    public String getMinute(String curdate){
    	String minute = "";
    	
    	try{
    		if(curdate == "" || curdate == null){
        		minute = "  ";
        	}
        	else{
    	    	int temp1 = curdate.indexOf(":") +1;
    	    	int temp2 = curdate.lastIndexOf(":");
    	    	minute = curdate.substring(temp1,temp2);
    	    	minute = twoChar(minute);
        	}
    	}catch(Exception e){
    		minute = "数据库数据有错误";
    	}
    	
    	return minute;
    }
    //  linelen:每行长度
    //	linenum:总行数
    public int getBr(String content , int linelen , int linenum){
    	int totle = content.length();
    	int br;
    	if(totle / linelen >= linenum)
    		br = 0;
    	else{
    		br = linenum - totle / linelen;
        	int temp = totle % linelen;
        	if(temp != 0)
        		br --;
    	} 	
    	return(br);
    }
	
    public String fileName(){

    	return ""+year+month+day_of_month+hh+mm+ss+dd;
    }
    //String->Date
    public static Date string2date(String sdate){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	sdf.setLenient(false);
    	Date ddate = null;
    	try {
			ddate=sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ddate;
    }
    //
    public  List<String>getDays(String s1,String s2){
    	List l =getDays(string2date(s1),string2date(s2));
		Iterator itor = l.iterator();
		List<String> list = new ArrayList();
		while(itor.hasNext()){
			Calendar m = (Calendar)itor.next();
			String s = ""+m.get(Calendar.YEAR)+"-"+twoChar(m.get(Calendar.MONTH)+1)+"-"+twoChar(m.get(Calendar.DATE));
			list.add(s);
		}
		return list;
    }
    public String tomorrow(){
    	  java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd");
		  java.util.Calendar calendar=java.util.Calendar.getInstance();
		  calendar.roll(java.util.Calendar.DAY_OF_YEAR,1);
		  return df.format(calendar.getTime());
    }
    public String yesterday(){
    	  java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd");
		  java.util.Calendar calendar=java.util.Calendar.getInstance();
		  calendar.roll(java.util.Calendar.DAY_OF_YEAR,-1);
		  return df.format(calendar.getTime());
    }
    
	public static void main(String[] args){
		//CalendarUtil cu = new CalendarUtil();
		////System.out.println("hello" + cu.getCuryear() + "month" + cu.getCurmonth());
	/*	Date s1 =null;
		Date s2 =null;
		try {
			s1 = string2date("2008-05-04");
			s2 = string2date("2008-06-02");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List l = getDays(s1,s2);
		Iterator itor = l.iterator();
		while(itor.hasNext()){
			Date m = (Date)itor.next();
			//System.out.println(m.toString());
		}
		*/
		////System.out.print(string2date("2008-05-04").toString());
		/*List l =getDays(string2date("2007-05-01"),string2date("2008-06-05"));
		Iterator itor = l.iterator();
		while(itor.hasNext()){
			Calendar m = (Calendar)itor.next();
			//System.out.println(""+m.get(Calendar.YEAR)+"-"+(m.get(Calendar.MONTH)+1)+"-"+m.get(Calendar.DATE));
		}*/
		/*List l = new CalendarUtil().getDays("2001-01-01","2002-01-01");
		Iterator itor = l.iterator();
		while(itor.hasNext()){
			//System.out.println((String)itor.next());
		}
		*/

		  java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd");
		  java.util.Calendar calendar=java.util.Calendar.getInstance();
		  calendar.roll(java.util.Calendar.DAY_OF_YEAR,-1);
		  //System.out.println("昨天："+df.format(calendar.getTime()));
		  calendar=java.util.Calendar.getInstance();
		  //System.out.println("今天："+df.format(calendar.getTime()));
		  calendar.roll(java.util.Calendar.DAY_OF_YEAR,1);
		  //System.out.println("明天："+df.format(calendar.getTime()));

		  //System.out.println("===="+new CalendarUtil().getTimeForDB());
	}

}
