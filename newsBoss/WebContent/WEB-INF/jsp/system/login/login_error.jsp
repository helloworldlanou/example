<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用OA系统</title>
<link href=" css/form.css" rel="stylesheet" type="text/css" />
<link href=" css/text.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="661" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">&nbsp;</td>
  </tr>
  <tr>
    <td height="441" background=" image/bg/login123.jpg"><form id="form1" name="form1" method="post" action="loginAction.do?action=login">
      <table width="500" height="260" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
      <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="77%" height="30">&nbsp;</td>
          <td width="23%" height="30"><label>
            <input name="user" type="text" class="form12" id="user" size="16" />
          </label></td>
        </tr>
        <tr>
          <td height="35">&nbsp;</td>
          <td height="35"><input name="pwd" type="password" class="form12" id="pwd" size="18" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td valign="middle"><label>
            <input type="image" name="imageField" onclick="javascript:form1.submit();this.disabled=true;" src=" image/botton/login.jpg" />
            <br />
            <span class="title14_red_line">用户名密码错误<br />
            请重新登录！</span>          </label></td>
        </tr>
      </table>
        </form>
    </td>
  </tr>
</table>
</body>
</html>
