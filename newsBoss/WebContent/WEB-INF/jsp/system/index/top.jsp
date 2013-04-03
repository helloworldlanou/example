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
<title>无标题文档</title>
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
<link href="   css/text.css" rel="stylesheet" type="text/css" />
<link href="   css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="58" bgcolor="#D7F2C5"><table width="100%" height="58" border="0" cellpadding="0" cellspacing="0">
      <tr>
       
        <td align="center">&nbsp;</td>
         <td width="415" align="center" ><img src="image/logo/logo_title123.jpg" width="392" height="38" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="21" valign="bottom" background="   image/bg/line_h2.gif"><table width="100%"  border="0" cellpadding="2" cellspacing="0">
      <tr class="text12w">
        <td>&nbsp;</td>
        <%
		model.system.BoPerson p = (model.system.BoPerson)session.getAttribute("person");
		%>
        <td><%=new util.time.CalendarUtil().showDate()%></td>
        <td><%=p.getName()%> (<%=p.getUserName()%>) 您好！上次登录时间：<%=p.getLastLoginTime()%></td>
        <td align="right">  <a href="personAction.do?action=toModifyInfo" target="frmView" class="text12w">个人设定</a> | 帮助 | <a href=" loginAction.do?action=logout" target="_top" class="text12w">退出</a>　 &nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="8" background="   image/bg/line_h.gif"></td>
  </tr>
</table>
</body>
</html>
