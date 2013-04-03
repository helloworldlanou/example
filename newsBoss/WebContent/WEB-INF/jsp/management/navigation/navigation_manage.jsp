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
window.location.href="navigationAction.do?action=delete&id="+id+"&boss.token=<%=token1%>";
}
</c:if>
<c:if test="${!canDelete}">
alert("该菜单不能被删除，请先删除该该菜单的下级菜单");
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
            <td height="25" class="title14">　导航栏菜单管理 &gt;&gt;</td>
          </tr>
          <tr>
            <td height="1" background=" image/bg/line_h_long.gif"></td>
          </tr>
          <tr>
            <td height="12"></td>
          </tr>
           <tr bgcolor="#FFFFFF">
              <td><c:if test="${remind!=null}"><img src="image/icon/form/icon_remind.gif" /> </c:if><span class="errorAlert"><c:out value="${remind}"/></span><c:if test="${right!=null}"><img src="image/icon/form/icon_right.gif" /> </c:if><span class="rightAlert"><c:out value="${right}"/></span>
              </td>
            </tr>
        </table></td>
      </tr>
     
      <tr>
        <td width="12">&nbsp;</td>
        <td><p>
</p>
 <c:if test="${type=='dep'&&n.id!='0'}">
          <form action="" method="post" name="form1" id="form1">
 <p>
 <c:if test='${fn.id==0}'>          
 <a href="navigationAction.do?action=toAddNavigation&id=<c:out value='${n.id}'/>"><img src=" image/botton/add.jpg" width="102" height="29" border="0" /></a>
 </c:if>
                <c:if test="${canUp}">
                        <%
		String token2 = processor.getToken(request);
		%>
                <a href="navigationAction.do?action=moveUp&id=<c:out value='${n.id}'/>&boss.token=<%=token2%>"  ><img src=" image/botton/up.jpg" width="102" height="29" border="0" /></a>
                </c:if>
                <c:if test="${!canUp}">
                <img src=" image/botton/up_no.jpg" width="102" height="29" border="0" />
                </c:if>
                <c:if test="${canDown}">
                 <%
		String token3 = processor.getToken(request);
		%>
                <a href="navigationAction.do?action=moveDown&id=<c:out value='${n.id}'/>&boss.token=<%=token3%>" ><img src=" image/botton/down.jpg" width="102" height="29" border="0" /></a>
               </c:if>
               <c:if test="${!canDown}">
                <img src=" image/botton/down_no.jpg" width="102" height="29" border="0" />
                </c:if>
              <IMG style="CURSOR: pointer" src="image/botton/delete.jpg"  alt="删除" onClick="deleteZ('<c:out value='${n.id}'/>')"  border="0"/>
              <a href="navigationAction.do?action=toModifyPage&id=<c:out value='${n.id}'/>"><img src=" image/botton/modify.jpg" width="102" height="29" border="0" /></a></p>
            <table width="90%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              
              <tr bgcolor="#FFFFFF"  height="20" >
                <td width="19%" align="center" bgcolor="#84B969" class="text12w">名称</td>
                <td width="81%" bgcolor="#FFFFFF" class="text12"><c:out value="${n.name}"/></td>
              </tr>
              <tr bgcolor="#FFFFFF"  height="20" >
                <td align="center" bgcolor="#84B969" class="text12w">英文名称</td>
                <td bgcolor="#FFFFFF" class="text12">${n.enname}</td>
              </tr>
              <c:if test='${fn.id!=0}'>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">所属菜单</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${fn.name}"/></td>
              </tr>
              </c:if>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">菜单类型</td>
                <td bgcolor="#FFFFFF" class="text12">
                <c:if test="${n.type=='info'}">
                单页信息型                </c:if>
                <c:if test="${n.type=='news'}">
                信息发布型                </c:if>
                <c:if test="${n.type=='custom'}">
                外连接型                </c:if>                </td>
              </tr>
              <c:if test="${n.type=='custom'}">
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">外连接URL</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${n.url}"/></td>
              </tr>
              </c:if>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">菜单描述</td>
                <td bgcolor="#FFFFFF" class="text12"><c:out value="${n.des}"/></td>
              </tr>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">首页中部显示</td>
                <td bgcolor="#FFFFFF" class="text12">  <c:if test="${n.centershow=='no'}" >否 </c:if>
                 <c:if test="${n.centershow=='yes'}" >是 </c:if>                 </td>
              </tr>
                              <c:if test="${n.parentId=='0'}">

              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">默认选择项</td>
                <td bgcolor="#FFFFFF" class="text12">  <c:if test="${n.defaultchecked=='unchecked'}" >否 </c:if>
                 <c:if test="${n.defaultchecked=='checked'}" >是 </c:if>                 </td>
              </tr>
              <tr bgcolor="#FFFFFF" height="20">
                <td align="center" bgcolor="#84B969" class="text12w">导航栏显示</td>
                <td bgcolor="#FFFFFF" class="text12"><c:if test="${n.showup=='noshowup'}" >否 </c:if>
                    <c:if test="${n.showup=='showup'}" >是 </c:if>
                </td>
              </tr>
              </c:if>
            </table>
          </form>
</c:if>
 
         
          <c:if test="${type=='dep'&&n.id=='0'}">
          
          <p><a href="navigationAction.do?action=toAddNavigation&id=0" ><img src=" image/botton/add.jpg" width="102" height="29" border="0"/></a></p>
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
