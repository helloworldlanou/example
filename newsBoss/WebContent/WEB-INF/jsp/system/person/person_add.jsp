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
<link rel="stylesheet" type="text/css" href="css/dtree.css"/>
<link rel="stylesheet" type="text/css" href="css/text.css"/>
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
              <td height="25" class="title14">　添加系统人员 &gt;&gt;</td>
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
        <td><form action="personAction.do?action=addPerson"  method="post" name="form1" id="form1">
        <%
		TokenProcessor processor = TokenProcessor.getInstance();
		String token = processor.getToken(request);
		%>
        <input name="id" type="hidden" value="<c:out value='${dn.id}'/>" />
        <input name="boss.token" type="hidden" value="<%=token%>" />
            <table width="80%" height="86"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">人员姓名</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><input name="name" type="text" class="form12" id="name" size="40" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">所属部门</td>
                <td bgcolor="#FFFFFF" class="text12"><input name="depname" type="text" class="form12" id="parentid" value="<c:out value='${dn.name}'/>"  readonly="readonly"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">姓别</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                <input type="radio" name="sex" id="female" value="male" <c:if test="${person.sex==male}"> checked="checked" </c:if> />男
                <input type="radio" name="sex" id="male" value="female" <c:if test="${person.sex==female}"> checked="checked" </c:if> />女  
</label></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">用户名</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                  <input name="username" type="text" class="form12" id="name5" size="40" />
                </label></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">密码</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                默认为888888</label></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">职务</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                  <input name="duty" type="text" class="form12" id="name4" size="40" />
                </label></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">角色</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                  <select name="roleId" id="roleId" class="form12">
                  <option value="-1">--请选择--</option>
                  <c:forEach items="${roleIdList}" var="n1">
                  <option value="<c:out value='${n1.id}'/>"><c:out value='${n1.name}'/></option>
                  </c:forEach>
                  </select>
                </label></td>
              </tr>
            </table>
          <table width="80%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/add_person.jpg" width="102" height="29" border="0" />　　
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
