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
<link href=" css/form.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/dtree.css">
<link rel="stylesheet" type="text/css" href="css/text.css">
<script type="text/javascript" src="js/dtree.js"></script>

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
              <td height="25" class="title14">　分配角色权限 &gt;&gt;</td>
            </tr>
            <tr>
              <td height="1" background="image/bg/line_h_long.gif"></td>
            </tr>
            <tr>
              <td height="12"></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td width="12">&nbsp;</td>
        <td><form action="roleAction.do?action=role_right&roleId=<c:out value='${roleId}'/>"  method="post" name="form1" id="form1">
        <%
		TokenProcessor processor = TokenProcessor.getInstance();
		String token = processor.getToken(request);
		%>
        <input name="boss.token" type="hidden" value="<%=token%>" />
            <table width="80%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td  class="text12w">
                 
                  <div class="dtree">
	<script type="text/javascript">
		d2 = new dTree("d2");
		d2.config.useCheckBox = true;
		d2.add("0","-1","系统模块树");
		 d2.config.check=true;//显示复选框
        d2.config.mycheckboxName="dTreeChk";//设置<input type='checkbox' name="ids"/>name的属性
		<c:forEach items="${checkList}" var="n1">
		d2.add("<c:out value='${n1.id}'/>","<c:out value='${n1.parentId}'/>","<c:out value='${n1.name}'/>","<c:out value='${n1.url}'/>","<c:out value='${n1.title}'/>","<c:out value='${n1.target}'/>","<c:out value='${n1.icon}'/>","<c:out value='${n1.iconOpen}'/>",<c:out value="${n1.open}"/>);
		</c:forEach>
		document.write(d2);
		d2.setCheck("<c:out value='${defaultChecked}'/>"); //设置默认选中的项目
	</script>
	</div>
                </td>
                </tr>
            </table>
          <table width="80%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src="image/botton/role_right.gif" width="102" height="29" border="0" />　　
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
