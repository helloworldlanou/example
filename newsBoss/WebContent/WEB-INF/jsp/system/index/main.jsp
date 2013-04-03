<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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

<link href=" css/form.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/dtree.css">
<link rel="stylesheet" type="text/css" href="css/text.css">
<script type="text/javascript" src="js/dtree.js"></script>

<script language="javascript">
function deleteZ(id){

<c:if test="${canDelete}">
if( confirm('你确认要删除吗?')){
parent.window.location.href="menuAction.do?action=delete&id="+id;
}
</c:if>
<c:if test="${!canDelete}">
alert("该节点有孩子节点，请先删除孩子结点");
</c:if>

}



</script>
</head>

<body>
<table width="100%%" border="0">
  <tr>
    <td height="97">&nbsp;</td>
  </tr>
  <tr>
    <td height="195" align="center"s><img src="image/welcome.gif" width="379" height="89" /></td>
  </tr>
  <tr>
    <td height="218">&nbsp;</td>
  </tr>
</table>

</body>
</html>
