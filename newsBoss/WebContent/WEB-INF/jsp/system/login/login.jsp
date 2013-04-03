<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
 <title>欢迎使用MIS系统</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/form.css"/>
<link rel="stylesheet" type="text/css" href="css/text.css"/>

</head>

<body>
<table width="661" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">&nbsp;</td>
  </tr>
  <tr>
    <td height="441" background=" image/bg/login123.jpg">
    <form id="form1" name="form1" method="post" action="loginAction.do?action=login" >
      <table width="90%" height="350" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="77%">&nbsp;</td>
          <td width="23%" height="140">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>
            <input name="user" type="text" class="form12" id="user" size="16" />
		  </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input name="pwd" type="password" class="form12" id="pwd" size="18" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td valign="middle">
          <input name="button" type="image" id="button" value="提交" src="image/botton/login.jpg" />
          </td>
        </tr>
      </table>
        </form>
    </td>
  </tr>
</table>
</body>
</html>
