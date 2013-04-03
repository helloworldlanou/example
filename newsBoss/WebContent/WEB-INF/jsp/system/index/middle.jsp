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
<title>中间页</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<SCRIPT>
function Submit_onclick(){
   if(parent.info_show_frame.cols=="196,22,*"){
		parent.info_show_frame.cols="0,22,*";
		document.getElementById("switchbar").src="   image/bg/open_side.jpg"
	}else{
		parent.info_show_frame.cols="196,22,*"
		document.getElementById("switchbar").src="   image/bg/close_side.jpg"
	}
}
</SCRIPT>
</head>

<body>
<table width="20" height="5000" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="7" valign="top" background="   image/bg/line_v.gif"><p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p><A title=点击缩放窗口 style="CURSOR: hand" 
            href="javascript:Submit_onclick()"><IMG 
            src="   image/bg/close_side.jpg" name="switchbar" width=7 height=30 
    border=0 id=switchbar></p></td>
    <td width="13"></td>
  </tr>
</table>
</body>
</html>
