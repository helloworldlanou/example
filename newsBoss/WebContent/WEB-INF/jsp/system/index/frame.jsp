<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用新闻发布系统</title>
</head>
	<FRAMESET border=0 frameSpacing=0 rows=87,*,22 frameBorder=NO cols=*>
		<FRAME border=0 name=topFrame frameSpacing=0 src="top.do" frameBorder=NO noResize scrolling=no height="30">
			<FRAMESET id=info_show_frame border=0 frameSpacing=0 rows=* frameBorder=NO cols=196,22,*>
				<FRAME name=leftFrame src="menu.do">
				<FRAME name=midFrame src="middle.do" frameBorder=0 noResize scrolling=no>
				<FRAME name=frmView src="main.do" frameBorder=0>
			</FRAMESET>
		<FRAME border=0 name=bottomFrame frameSpacing=0 src="bottom.do" frameBorder=NO noResize scrolling=no height="30">	
	</FRAMESET>
	<noframes></noframes>
</html>
