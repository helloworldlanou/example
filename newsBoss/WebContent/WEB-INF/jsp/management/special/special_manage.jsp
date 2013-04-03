<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="util.TokenProcessor"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>专题管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script language="JavaScript">
function del(){
	if(confirm("确认要删除此专题信息么？")==1)
	{
	return true;
	}
    else
    {
    return false;
    }
}
function queryClick(){
  var form = document.form1;
  form.pagenum.value="1";
  form.submit();
}
function currPage(page){
  var form = document.form1;
  form.pagenum.value=page;
  form.submit();
}

</script>
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<form name="form1" method="post"
			action="linksAction.do?action=toAddLinksSortPage"><table width="60%" border="0" cellspacing="0" cellpadding="0"><tr><td width="430" height="7"></td><td rowspan="4" align="center"></td></tr><tr><td width="430" height="25" class="title14">专题管理 &gt;&gt;<br>
						<c:if test="${remind!=null}"><img src="image/icon/form/icon_remind.gif" /> </c:if><span class="errorAlert"><c:out value="${remind}"/></span><br> 
					</td>
				</tr>
				<tr>
					<td width="430" height="1"  ></td>
				</tr>
				<tr>
					<td width="430" height="2"></td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="1" bgcolor="#CCCCCC">
				<tr align="center" height="30" class="text14wb">
					<td background="image/bg/table_head.gif">
						专题名称					</td>
					<td background="image/bg/table_head.gif">英文名称</td>
					<td height=30 background="image/bg/table_head.gif">
						创建时间					</td>
					<td background="image/bg/table_head.gif">
						相应操作					</td>
				</tr>
				<c:forEach var="n" items="${list}" varStatus="i">
					
					<tr align="center" bgcolor="#FFFFFF" class="text12">
						<td height="20">
							<c:out value="${n.name}"></c:out>						</td>


						<td><c:out value="${n.enname}"></c:out>	</td>
						<td>
							<fmt:formatDate value="${n.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>						</td>
						<td>
						
							
							<a href="specialAction.do?action=toModifySpecialPage&id=${n.id}"><font
								color="#33CCFF">修改</font>							</a>
							
							<a href="specialAction.do?action=deleteSpecial&id=${n.id}&vote=b"
								OnClick="return del()"><font color="#33CCFF">删除</font>							</a>						</td>
					</tr>
				</c:forEach>
			</table>
		  <table>
			<tr>
                
                  <td align="center">　　
                  <a href="specialAction.do?action=toAddSpecialPage" ><img src="image/botton/special_add_big.gif"  width="102" height="29" border="0"></a>
                  </td>
                  <c:if test='${!isnull}'>
               <td align="center">　　
                  <a href="specialAction.do?action=toAddSmallSpecialPage" ><img src="image/botton/special_add_small.gif"  width="102" height="29" border="0"></a>
                  </td>  
                  <td align="center">　　
                  <a href="specialAction.do?action=toSmallManagePage" ><img src="image/botton/special_manage_small.gif"  width="102" height="29" border="0"></a>
                  </td>  
				</c:if>
              </tr>
              
              </table>
		</form>
	</body>
</html>
