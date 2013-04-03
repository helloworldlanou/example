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

<c:if test="${type=='dep'}">
function deleteZ(id){

<c:if test="${canDelete}">
if( confirm('你确认要删除吗?')){
window.location.href="departmentAction.do?action=delete&id="+id+"&boss.token=<%=token1%>";
}
</c:if>
<c:if test="${!canDelete}">
alert("该部门下有人员，请先删除该部门的人员");
</c:if>

}

</c:if>

<c:if test="${type=='peo'}">
function deleteZ(id){

<c:if test="${canDelete}">
if( confirm('你确认要删除吗?')){
window.location.href="personAction.do?action=delete&id="+id+"&boss.token=<%=token1%>";
}
</c:if>
}


</c:if>

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
		//d.add("<c:out value='${n.id}'/>","<c:out value='${n.parentId}'/>","<c:out value='${n.name}'/>");
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
            <td height="25" class="title14">　部门人员管理 &gt;&gt;</td>
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
 <c:if test="${type=='dep'&&n.id!='0'}">
          <form action="" method="post" name="form1" id="form1">
            <p><a href="departmentAction.do?action=toAddDepartment&id=<c:out value='${n.id}'/>"><img src=" image/botton/add_dept.jpg" width="102" height="29" border="0" /></a><a href="personAction.do?action=toAddPerson&id=<c:out value='${n.id}'/>"><img src=" image/botton/add_person.jpg" width="102" height="29" border="0" /></a>
              
              <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除" onClick="deleteZ('<c:out value='${n.id}'/>')"  border="0"/>
              <a href=" departmentAction.do?action=toModifyPage&id=<c:out value='${n.id}'/>"><img src=" image/botton/modify.jpg" width="102" height="29" border="0" /></a></p>
            <table width="90%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              
              <tr bgcolor="#FFFFFF"  height="20" >
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">部门名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><c:out value="${n.name}"/></td>
              </tr>
              <c:if test='${fn.id!=0}'>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">所属部门</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${fn.name}"/></td>
              </tr>
              </c:if>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">部门描述</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${n.des}"/></td>
              </tr>
            </table>
          </form>
</c:if>
         
 <c:if test="${type=='peo'}">
          <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除" onClick="deleteZ('<c:out value='${n.id}'/>')"  border=0/> 　  <a href=" personAction.do?action=toModifyPage&id=<c:out value='${n.id}'/>"><img src=" image/botton/modify.jpg" width="102" height="29" border="0" /></a>
          <form action="node_modify_child_do.jsp" method="post" name="form1" id="form1">
            <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">员工名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><c:out value='${n.name}'/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">所属部门</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value='${n.depName}'/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">性别</td>
                <td bgcolor="#FFFFFF" class="text12"><c:if test='${n.sex=="male"}'>男</c:if><c:if test='${n.sex=="female"}'>女</c:if></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">职务</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value='${n.duty}'/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">用户名</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value='${n.userName}'/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">角色</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value='${n.roleName}'/></td>
              </tr>
            </table>
            <p>&nbsp;</p>
          </form>
</c:if> 
         
          <c:if test="${type=='dep'&&n.id=='0'}">
          
          <p><a href="departmentAction.do?action=toAddDepartment&id=0" ><img src=" image/botton/add_dept.jpg" width="102" height="29" border="0"/></a><a href=" departmentAction.do?action=toSelectIcon" ><img src=" image/botton/department_icon.gif" width="102" height="29" border="0"/></a><a href=" personAction.do?action=toSelectIcon" ><img src=" image/botton/person_icon.gif" width="102" height="29" border="0"/></a></p>
          <p align="center"><img src=" image/welcome.gif" width="379" height="89" /></p>
          <p>
          </p>
          </c:if></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
