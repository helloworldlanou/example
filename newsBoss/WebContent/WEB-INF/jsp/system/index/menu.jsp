<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!-- ///---
	scrollbar-3dlight-color:green;
	scrollbar-arrow-color:green;
	scrollbar-base-color:white;
	scrollbar-darkshadow-color:white;
	scrollbar-face-color:#CCFFCC;
	scrollbar-highlight-color:white;
	scrollbar-shadow-color:white;
	scrollbar-track-color:#CCFFCC;
	-->
 
}
-->
</style>
<link rel="stylesheet" type="text/css" href="css/dtree.css">
<link rel="stylesheet" type="text/css" href="css/text.css">
<script type="text/javascript" src="js/dtree.js"></script>
</head>

<body>

<c:forEach items="${nodeFatherRootList}" var="n">
<c:if test="${n.id!=selectedNodeId}">
<table width="100%" height="46" border="0" cellpadding="0" cellspacing="0" background="   image/bg/menu_botton_bg.gif">
  <tr>
    <td><table height="35" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20">&nbsp;</td>
        <td width="50"><img src="<c:out value='${n.bigIcon}'/>" width="35" height="35" /></td>
        <td width="130" valign="bottom" class="menuw16"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td><a href="menuAction.do?action=selectNodeId&id=<c:out value='${n.id}'/>" class="menuw16">【<c:out value="${n.name}"/>】</a></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</c:if>
<c:if test="${n.id==selectedNodeId}">
<table width="100%" height="46" border="0" cellpadding="0" cellspacing="0" background="   image/bg/menu_botton_bg_s.gif">
  <tr>
    <td><table height="35" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20">&nbsp;</td>
        <td width="50"><img src="<c:out value='${n.bigIcon}'/>_s" width="35" height="35" /></td>
        <td width="130" valign="bottom" class="menuw16"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><a href="menuAction.do?action=unSelectNodeId&id=<c:out value='${n.id}'/>" class="menuw16">【<c:out value="${n.name}"/>】</a></td>
          </tr>
        </table>
          </td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="5" cellspacing="7" bgcolor="#D7F2C5">
  <tr>
    <td colspan="2" bgcolor="#FFFFFF">
    <!--菜单-->
    <div class="dtree">
	<script type="text/javascript">
		dmenu = new dTree("dmenu");
		dmenu.add("<c:out value='${n.id}'/>","-1","<c:out value='${n.name}'/>");
		<c:forEach items="${nodeChildList}" var="n1">
		dmenu.add("<c:out value='${n1.id}'/>","<c:out value='${n1.parentId}'/>","<c:out value='${n1.name}'/>","<c:out value='${n1.url}'/>","<c:out value='${n1.title}'/>","<c:out value='${n1.target}'/>","<c:out value='${n1.icon}'/>","<c:out value='${n1.iconOpen}'/>",<c:out value="${n1.open}"/>);
		</c:forEach>
		document.write(dmenu);
	</script>
	</div>
    </td>
  </tr>
</table>
</c:if>
</c:forEach>
</body>
</html>
