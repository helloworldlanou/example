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

		<title>链接类别管理</title>

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
	if(confirm("确认要删除此链接信息么？")==1)
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
			action="linksAction.do?action=toAddLinksSortPage">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="430" height="7"></td>
					<td rowspan="4" align="center">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td width="430" height="25" class="title14">站点类别管理 &gt;&gt;<br>
						<c:if test="${remind!=null}"><img src="image/icon/form/icon_remind.gif" /> </c:if><span class="errorAlert"><c:out value="${remind}"/></span><br> 
					</td>
				</tr>
				<tr>
					<td width="430" height="1" background="   image/bg/line_h_long.gif"></td>
				</tr>
				<tr>
					<td width="430" height="2"></td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="1" bgcolor="#CCCCCC">
				<tr align="center" class="text14wb">
					<td background="image/bg/table_head.gif">
						类别名称
					</td>
					<td height="30" background="image/bg/table_head.gif">
						排序序号
					</td>
					<td background="image/bg/table_head.gif">
						创建时间
					</td>
					<td background="image/bg/table_head.gif">
						相应操作
					</td>
				</tr>
				<c:forEach var="n" items="${list}" varStatus="i">
					
					<tr align="center" bgcolor="#FFFFFF" class="text12">
						<td>
							<c:out value="${n.sortname}"></c:out>
						</td>
						<td height="20">
							<c:out value="${n.serial}"></c:out>
						</td>

						<td>
							<fmt:formatDate value="${n.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
						<c:if test="${!i.first}">
						<a href="linksAction.do?action=LinksSortMoveUp&id=${n.id}"><font color="#33CCFF">上移</font>
							</a></c:if>
							<c:if test="${!i.last}">
							<a href="linksAction.do?action=LinksSortMoveDown&id=${n.id}"><font color="#33CCFF">下移</font>
							</a>	</c:if>
							
							<a href="linksAction.do?action=toModifyLinksSortPage&id=${n.id}"><font
								color="#33CCFF">修改</font>
							</a>
							
							<a href="linksAction.do?action=deletesort&id=${n.id}"
								OnClick="return del()"><font color="#33CCFF">删除</font>
							</a>
						
							
						</td>

					</tr>
				</c:forEach>
				
			</table>
			<table>
			<tr>
                
                  <td align="center">　　
                  <a href="linksAction.do?action=toAddLinksSortPage" ><img src="image/botton/add_linkssort.gif"  width="102" height="29" border="0"></a>
                  </td>
                   <td align="center">　　
                  <a href="linksAction.do?action=toManagePage" ><img src="image/botton/linksmanage.jpg"  width="102" height="29" border="0"></a>
                  </td>

              </tr>
              </table>
		</form>
	</body>
</html>
