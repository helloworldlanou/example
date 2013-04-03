<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <base href="<%=basePath%>"/>
<title>无标题文档</title>
<link href="css/text.css" rel="stylesheet" type="text/css" />
</head>

<body>
<p>&nbsp;</p>
<table width="99%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="20%">&nbsp;</td>
    <td width="28%"><div align="right"><img src="image/error/error.gif" width="180" height="228" /></div></td>
    <td width="52%" class="title14_red_line"><p>系统错误或者系统繁忙，请稍后再试!<br /></p>
<p>请联系网站维护人员!<br/></p>    </td>
  </tr>
</table>
</body>
</html>

