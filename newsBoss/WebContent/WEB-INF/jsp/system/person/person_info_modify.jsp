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
        <td><form action="personAction.do?action=modifyInfo" method="post" name="form1" id="form1">
          <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          
            <tr bgcolor="#FFFFFF">
              <td width="19%" colspan="2" align="center" bgcolor="#84B969" class="text12w">姓 名 <input name="id" type="hidden" id="id" value="<c:out value='${person.id}'/>" /></td>
              <td width="81%" bgcolor="#FFFFFF" class="text12"><input name="name" type="text" class="form12" id="name" value="<c:out value='${person.name}'/>" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">所属部门</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.depName}'/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">性 别</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="sex" type="radio" value="male"  <c:if test='${person.sex=="male"}'>  checked="checked" </c:if> />
                男
                <input type="radio" name="sex" value="female"  <c:if test='${person.sex=="female"}'>  checked="checked" </c:if>/>
                女</td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">用户名</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="username" type="text" class="form12" id="username" value="<c:out value='${person.userName}'/>" size="40" /> 
                <a href="personAction.do?action=toPwdChange">修改密码</a></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">职 务</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.duty}'/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">角色</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.roleName}'/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">上次登录时间</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.lastLoginTime}'/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">账号注册时间</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.registerTime}'/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">登录次数</td>
              <td bgcolor="#FFFFFF" class="text12"><c:out value='${person.loginTimes}'/></td>
            </tr>
			   </table>
          <table width="80%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/modify.jpg" width="102" height="29" border="0" />　　
                  <img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onclick="form1.reset()" /></td>
              </tr>
            </table>
          <p>&nbsp;</p>
        </form>
            <p>&nbsp;</p></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
