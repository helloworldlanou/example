<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.TokenProcessor"%>
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
<link rel="stylesheet" type="text/css" href="css/dtree.css"/>
<link rel="stylesheet" type="text/css" href="css/text.css"/>
<script type="text/javascript" src="js/dtree.js"></script>
          <%
		TokenProcessor processor = TokenProcessor.getInstance();
		String token1 = processor.getToken(request);
		%>
<script language="javascript">


function deleteZ(id){

<c:if test="${canDelete}">
if( confirm('你确认要删除吗?')){
window.location.href="roleAction.do?action=delete&id="+id+"&boss.token=<%=token1%>";
}
</c:if>
<c:if test="${!canDelete}">
alert("该角色下有人员，请先删除该角色下的人员");
</c:if>

}


</script>
</head>

<body>
<table width="100%" height="500"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="197" valign="top"><table width="197" height="500" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="327" valign="top"><table width="197" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="10">&nbsp;</td>
            <td>
            <!--树形-->
			<div class="dtree">
	<script type="text/javascript">
		d = new dTree("d");
		<c:forEach items="${depList}" var="n1">
		d.add("<c:out value='${n1.id}'/>","<c:out value='${n1.parentId}'/>","<c:out value='${n1.name}'/>","<c:out value='${n1.url}'/>","<c:out value='${n1.title}'/>","<c:out value='${n1.target}'/>","<c:out value='${n1.icon}'/>","<c:out value='${n1.iconOpen}'/>",<c:out value="${n1.open}"/>);
		</c:forEach>
		document.write(d);
	</script>
	</div>
            
            </td>
          </tr>
          <tr>
            <td width="10">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      
    </table></td>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12">&nbsp;</td>
        <td><table width="430" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="6"></td>
          </tr>
          <tr>
            <td height="25" class="title14">　系统角色管理 &gt;&gt;</td>
          </tr>
          <tr>
            <td height="1" background=" image/bg/line_h_long.gif"></td>
          </tr>
          <tr>
            <td height="12"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="12">&nbsp;</td>
        <td><p>
</p>
 <c:if test="${n.id!='0'}">
          <form action="" method="post" name="form1" id="form1">
            <p><a href="roleAction.do?action=to_role_person&id=<c:out value='${n.id}'/>"><img src=" image/botton/add_role_person.gif" width="102" height="29" border="0" /></a><a href="roleAction.do?action=to_role_right&id=<c:out value='${n.id}'/>"><img src=" image/botton/role_right.gif" width="102" height="29" border="0" /></a>
     
              <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除" onClick="deleteZ('<c:out value='${n.id}'/>')"  border="0"/>
              <a href="roleAction.do?action=toModifyPage&id=<c:out value='${n.id}'/>"><img src=" image/botton/modify.jpg" width="102" height="29" border="0" /></a></p>
            <table width="90%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              
              <tr bgcolor="#FFFFFF"  height="20" >
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">角色名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><c:out value="${n.name}"/></td>
              </tr>
              <c:if test='${fn.id!=0}'>              </c:if>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">角色描述</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${n.des}"/></td>
              </tr>
            </table>
          </form>
</c:if>
         

         
          <c:if test="${n.id=='0'}">
          
          <p><a href="roleAction.do?action=toAddRole" ><img src=" image/botton/add_role.jpg" width="102" height="29" border="0"/></a><a href="roleAction.do?action=toSelectIcon" ><img src=" image/botton/select_icon.jpg" width="102" height="29" border="0"/></a></p>
          <p align="center"><img src=" image/welcome.gif" width="379" height="89" /></p>
          <p>          </p>
          </c:if></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
