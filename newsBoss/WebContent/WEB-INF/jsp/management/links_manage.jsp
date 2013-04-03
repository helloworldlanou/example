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

		<title>修改链接</title>

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
			action="linksAction.do?action=toManagePage">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="430" height="7"></td>
					<td rowspan="4" align="center">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="430" height="25" class="title14">站点链接管理 &gt;&gt; 
					</td>
				</tr>
				<tr>
					<td width="430" height="1" background="   image/bg/line_h_long.gif"></td>
				</tr>
				<tr>
					<td width="430" height="2"></td>
				</tr>
			</table>

			<table width="%" border="0" cellpadding="2" cellspacing="0">

				<tr>
					<td class="text12">
						<label>
							共
							<c:out value="${pageList.totalnum}"></c:out>
							条记录

							<select name="fetch" class="myselect" id="fetch"
								onChange="queryClick()">
								<option value="10"
									<c:if test="${pageList.fetch==10}">selected</c:if>>
									每页10条
								</option>
								<option value="20"
									<c:if test="${pageList.fetch==20}">selected</c:if>>
									每页20条
								</option>
								<option value="40"
									<c:if test="${pageList.fetch==40}">selected</c:if>>
									每页40条
								</option>
								<option value="-1"
									<c:if test="${pageList.fetch==pageList.totalnum}">selected</c:if>>
									不分页
								</option>
							</select>
						</label>
					</td>
					<td class="text12">
						共
						<c:out value="${pageList.totalpage}"></c:out>
						页 当前第
						<c:out value="${pageList.pagenum}"></c:out>
						页
						<c:if test="${pageList.pagenum>1}">
							<a href="javascript:currPage(1)" class="a1">第一页</a>
							<a
								href="javascript:currPage(<c:out value="${pageList.pagenum-1}"></c:out>)"
								class="a1">上一页</a>
						</c:if>
						<c:if test="${pageList.pagenum<=1}">
第一页 上一页
</c:if>
						<c:if test="${pageList.pagenum!=pageList.totalpage}">
							<a
								href="javascript:currPage(<c:out value="${pageList.pagenum+1}"></c:out>)"
								class="a1">下一页</a>
							<a
								href="javascript:currPage(<c:out value="${pageList.totalpage}"></c:out>)"
								class="a1">最后页</a>
						</c:if>
						<c:if test="${pageList.pagenum==pageList.totalpage}">
下一页 最后页
</c:if>
						跳转到
						<SELECT name="pagenum" id="pagenum"
							onchange="document.form1.submit()">

							<c:forEach var="i" begin="1" end="${pageList.totalpage}" step="1">

								<c:if test="${i==pageList.pagenum}">
									<option selected="selected" value=<c:out value="${i}"/>>
										<c:out value="${i}" />
									</option>
								</c:if>
								<c:if test="${i!=pageList.pagenum}">
									<option value=<c:out value="${i}"/>>
										<c:out value="${i}" />
									</option>
								</c:if>
							</c:forEach>

						</SELECT>
						页
					</td>
				</tr>

			</table>



			<table width="95%" border="0" cellspacing="1" bgcolor="#CCCCCC">
				<tr align="center" class="text14wb">
					<td background="image/bg/table_head.gif">站点链接名称 
					</td>
					<td height="30" background="image/bg/table_head.gif">
						所属类别
					</td>
					<td background="image/bg/table_head.gif">
						链接URL
					</td>
					<td background="image/bg/table_head.gif">
						相应操作
					</td>
				</tr>
				<c:forEach var="n" items="${list}">
					
					<tr align="center" bgcolor="#FFFFFF" class="text12">
						<td>
							<c:out value="${n.name}"></c:out>
						</td>
						<td height="20">
							<c:out value="${n.boLinksSort.sortname}"></c:out>
						</td>

						<td>
							<c:out value="${n.url}"></c:out>
						</td>
						<td>
							<a href="linksAction.do?action=toModifyLinksPage&id=${n.id}"><font
								color="#33CCFF">修改</font>
							</a>
							<a href="linksAction.do?action=delete&id=${n.id}"
								OnClick="return del()"><font color="#33CCFF">删除</font>
							</a>
						</td>

					</tr>
				</c:forEach>
				
			</table>
			<table>
			<tr>
                <td align="center">　　
                  <a href="linksAction.do?action=toAddPage" ><img src="image/botton/add_links.gif"  width="102" height="29" border="0"></a>
                  </td>
                  <td align="center">　　
                  <a href="linksAction.do?action=toAddLinksSortPage" ><img src="image/botton/add_linkssort.gif"  width="102" height="29" border="0"></a>
                  </td>
                  <td align="center">　　
                  <a href="linksAction.do?action=toLinksSortManagePage" ><img src="image/botton/sort_manage.jpg"  width="102" height="29" border="0"></a>
                  </td>
              </tr>
              </table>
		</form>
	</body>
</html>
