<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.TokenProcessor"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改专题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  
<table width="430" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="7"></td>
            </tr>
            <tr>
              <td height="25" class="title14">　修改专题&gt;&gt;</td>
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
        </table>
		
	<form action="specialAction.do?action=modifySpecial&id=${n.id}" method="post" name="form1" id="form1">
          <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          
            <tr bgcolor="#FFFFFF">
              <td width="19%" colspan="2" align="center" bgcolor="#84B969" class="text12w">专题名称</td>
              <td width="81%" bgcolor="#FFFFFF" class="text12"><input name="name" type="text" maxlength="32" class="form12" id="name" value="<c:out value='${n.name }' />" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">英文名称</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="enname" type="text" maxlength="32" class="form12" id="enname" value="<c:out value='${n.enname }' />" size="40" /></td>
            </tr>
			   </table>
<table width="80%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/submit.jpg" width="102" height="29" border="0" />　　
                  <img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onClick="form1.reset()" />　　
                  <a href="specialAction.do?action=toSpecialManagePage" ><img src="image/botton/back.jpg"  width="102" height="29" border="0"></a>
                  </td> 
                       </tr>
      </table>
          <p>&nbsp;</p>
  </form>	
  </body>
</html>
