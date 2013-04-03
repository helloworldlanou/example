<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.TokenProcessor"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <base href="<%=basePath%>"/>
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
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />

</head>
<body>


<table width="100%" height="500"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="430" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="6"></td>
            </tr>
            <tr>
              <td height="25" class="title14">　个人信息设定 &gt;&gt;</td>
            </tr>
            <tr>
              <td height="1" background="image/bg/line_h_long.gif"></td>
            </tr>
            <tr>
              <td height="12"></td>
            </tr>
             <tr bgcolor="#FFFFFF">
              <td><c:if test="${remind!=null}"><img src="image/icon/form/icon_remind.gif" /> </c:if><span class="errorAlert"><c:out value="${remind}"/></span><c:if test="${right!=null}"><img src="image/icon/form/icon_right.gif" /> </c:if><span class="rightAlert"><c:out value="${right}"/></span>
              </td>
            </tr>
           <tr>
              <td height="8"></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td><form action="personAction.do?action=pwdChange" method="post" name="form1" id="form1">
          <table width="100%" border="0" cellspacing="10" cellpadding="0">
            
            <tr>
              <td><span class="title14">键入您当前的密码：</span></td>
            </tr>
            <tr>
              <td><span class="text12">
                <input name="oldpassword" type="password" class="form12" id="oldpassword" size="70" />
              </span></td>
            </tr>
            <tr>
              <td><span class="title14">输入一个新密码：</span></td>
            </tr>
            <tr>
              <td><span class="text12">
                <input name="newpassword" type="password" class="form12"  id="newpassword" size="70" />
              </span></td>
            </tr>
            <tr>
              <td><span class="title14">再次输入确认新密码：</span></td>
            </tr>
            <tr>
              <td><span class="text12">
                <input name="newpasswordconfirm" type="password" class="form12" id="newpasswordconfirm"  size="70" />
              </span></td>
            </tr>
            <tr>
              <td class="title14_red_line">如果您的密码包含大小写字母，您必须在登录的时候采用同样的方式输入。</td>
            </tr>
            <tr>
              <td><table width="496" height="60"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="center"><input name="imageField" type="image" src=" image/botton/submit.jpg" width="102" height="29" border="0" />
                      　　<img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onclick="form1.reset()" /></td>
                  </tr>
              </table></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
            </tr>
          </table>
          </form>
            
    </table></td>
  </tr>
</table>
</body>
</html>
