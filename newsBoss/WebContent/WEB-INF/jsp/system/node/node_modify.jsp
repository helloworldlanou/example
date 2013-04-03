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

          <%
		TokenProcessor processor = TokenProcessor.getInstance();
		String token0 = processor.getToken(request);
		%>
<script language="javascript">
function deleteZ(id){

<c:if test="${canDelete}">
if( confirm('你确认要删除吗?')){
parent.window.location.href="menuAction.do?action=delete&id="+id+"&boss.token=<%=token0%>";
}
</c:if>
<c:if test="${!canDelete}">
alert("该节点有孩子节点，请先删除孩子结点");
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
		//d.add("<c:out value='${n.id}'/>","<c:out value='${n.parentId}'/>","<c:out value='${n.name}'/>");
		d.add("0","-1","系统模块树","menuAction.do?action=nodeManage&id=0","系统模块树");
		<c:forEach items="${nodeList}" var="n1">
		d.add("<c:out value='${n1.id}'/>","<c:out value='${n1.parentId}'/>","<c:out value='${n1.name}'/>","menuAction.do?action=nodeManage&id=<c:out value='${n1.id}'/>","<c:out value='${n1.title}'/>","<c:out value='${n1.target}'/>","<c:out value='${n1.icon}'/>","<c:out value='${n1.iconOpen}'/>",<c:out value="${n1.open}"/>);
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
            <td height="25" class="title14">　栏目功能节点设定 &gt;&gt;</td>
          </tr>
          <tr>
            <td height="1" background="  image/bg/line_h_long.gif"></td>
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
<c:if test="${n.type=='father'}">
          <form action="menuAction.do?action=modify&id=<c:out value='${n.id}'/>"  target="_parent" method="post" name="form1" id="form1">
        <%

		String token = processor.getToken(request);
		%>
        <input name="boss.token" type="hidden" value="<%=token%>" />
            <table width="90%" height="80"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC"> 
              <tr bgcolor="#FFFFFF">
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">栏目名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12">
                <input name="name" type="text" class="form12" id="name" value="<c:out value='${n.name}'/>" size="40" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">所属类别</td>
                <td bgcolor="#FFFFFF" class="text12"><input name="parentid" type="text" class="form12" id="parentid" readonly="readonly" value="<c:out value='${fn.name}'/>"  /></td>
              </tr>
              <c:if test="${fn.id=='0'}">
               <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">栏目图标</td>
                <td bgcolor="#FFFFFF" class="text12"><p>
                   <c:forEach items="${rootFileList}" var="f">
                   <c:if test="${f==n.bigIcon}">
                    <input name="bigIcon" type="radio" checked="checked" value="<c:out value='${f}'/>" />
                   </c:if>
                   <c:if test="${f!=n.bigIcon}">
                    <input name="bigIcon" type="radio" value="<c:out value='${f}'/>" />
                   </c:if>
                    <img src="<c:out value='${f}'/>" width="35" height="35" /> 
                   </c:forEach>
                </p></td>
              </tr>
              </c:if>
            </table>
            <table width="90%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/modify.jpg" width="102" height="29" border="0" />
                     <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除"  border="0" onClick="deleteZ('<c:out value='${n.id}'/>')" /><img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onClick="form1.reset()" /></td>
              </tr>
            </table>
            <p>&nbsp;</p>
          </form>
</c:if>
<c:if test="${n.type=='child'}">
          <form action="menuAction.do?action=modify&id=<c:out value='${n.id}'/>"  target="_parent"   method="post" name="form1" id="form1">
                  <%
		String token = processor.getToken(request);
		%>
        <input name="boss.token" type="hidden" value="<%=token%>" />
            <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              
              <tr bgcolor="#FFFFFF">
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">功能名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><input name="name" type="text" class="form12" id="name" value="<c:out value='${n.name}'/>" size="40" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">所属类别</td>
                <td bgcolor="#FFFFFF" class="text12"><input name="parentid" type="text" class="form12" id="parentid"  readonly="readonly" value="<c:out value='${fn.name}'/>" />
              </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">链接页面</td>
                <td bgcolor="#FFFFFF" class="text12"><input name="url" type="text" class="form12" id="url" value="<c:out value='${n.url}'/>" size="40" />                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">模块状态</td>
                <td bgcolor="#FFFFFF" class="text12"><label>
                <c:if test="${n.state=='use'}">
                  <input name="state" type="radio" value="use"  checked="checked"  />
                  启用
                  <input type="radio" name="state" value="nouse"  />
                  不启用 
				  <input type="radio" name="state" value="hide" />
                  隐藏
                </c:if>
                <c:if test="${n.state=='nouse'}">
                  <input name="state" type="radio" value="use"/>
                  启用
                  <input type="radio" name="state" value="nouse"  checked="checked"    />
                  不启用 
				  <input type="radio" name="state" value="hide" />
                  隐藏
                </c:if>
                 <c:if test="${n.state=='hide'}">
                  <input name="state" type="radio" value="use"/>
                  启用
                  <input type="radio" name="state" value="nouse"    />
                  不启用 
				  <input type="radio" name="state" value="hide" checked="checked"   />
                  隐藏
                </c:if>
                 
                 
                 </label></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center" bgcolor="#84B969" class="text12w">功能图标</td>
                <td bgcolor="#FFFFFF" class="text12"><p>
                   <c:forEach items="${fileList}" var="f">
                   <c:if test="${f==n.icon}">
                    <input name="icon" type="radio" checked="checked" value="<c:out value='${f}'/>" />
                   </c:if>
                   <c:if test="${f!=n.icon}">
                    <input name="icon" type="radio" value="<c:out value='${f}'/>" />
                   </c:if>
                    <img src="<c:out value='${f}'/>" width="18" height="18" /> 
                   </c:forEach>
                </p></td>
              </tr>
            </table>
            <table width="90%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/modify.jpg" width="102" height="29" border="0" />
                    <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除" onClick="deleteZ('<c:out value='${n.id}'/>')"  border="0"/> <img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onClick="form1.reset()" /></td>
              </tr>
            </table>
            <p>&nbsp;</p>
          </form>
          
</c:if>
          </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
