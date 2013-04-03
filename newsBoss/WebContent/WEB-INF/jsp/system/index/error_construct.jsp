<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
 <title>无标题</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/form.css"/>
<link rel="stylesheet" type="text/css" href="css/text.css"/>
</head>

<body>
<p>&nbsp;</p>
<table width="540" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="45">&nbsp;</td>
    <td width="164"><img src="image/error/errorinfo_pic.jpg" width="154" height="165" /></td>
    <td width="300" class="title14_red_line"><p>此模块正在处理中，将于近期恢复使用。<br />
    This model is being under construction. </p>
      <p>对您造成的不便在此表示抱歉！<br />
      We are sorry about that! </p>
    </td>
  </tr>
</table>
</body>
</html>
