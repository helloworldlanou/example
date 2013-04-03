<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ page import="util.TokenProcessor"%>
<jsp:useBean id="util"  class="util.Util"/>
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
	<link href="css/form.css" rel="stylesheet" type="text/css" />
	<link href="css/text.css" rel="stylesheet" type="text/css" />
	
		<script language="JavaScript">
function del(){
	if(confirm("确认要删除此新闻么？")==1)
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
<script>
var subcat = new Array();
//二级的parantid,二级的名字,二级的id
<c:set value="0" var="i" />
<c:forEach var="lmSec" items="${secondList}">
  subcat[${i}]=new Array("${lmSec.parentId}","${lmSec.name}","${lmSec.id}")
  <c:set value="${i+1}" var="i" />
</c:forEach>
function changeselect1(locationid) 
{ 
  document.all.q2.length = 0; //初始化下拉列表 清空下拉数据 
  document.all.q2.options[0] = new Option("==全部==","-1"); //给第一个值 
  for (i=0; i<subcat.length; i++) 
  { 
 if (subcat[i][0] == locationid) //[0] [1] 第一列 第二列 
    {
     document.all.q2.options[document.all.q2.length] = new Option(subcat[i][1], subcat[i][2]);
    } //建立option 
  } 
}


var subcat2 = new Array();
//二级的parantid,二级的名字,二级的id
<c:set value="0" var="i2" />
<c:forEach var="lmSec2" items="${secondList2}">
  subcat2[${i2}]=new Array("${lmSec2.parentid}","${lmSec2.name}","${lmSec2.id}")
  <c:set value="${i2+1}" var="i2" />
</c:forEach>
function changeselect2(locationid) 
{ 
  document.all.q10.length = 0; //初始化下拉列表 清空下拉数据 
  document.all.q10.options[0] = new Option("==全部==",""); //给第一个值 
  for (i=0; i<subcat2.length; i++) 
  { 
 if (subcat2[i][0] == locationid) //[0] [1] 第一列 第二列 
    {
     document.all.q10.options[document.all.q10.length] = new Option(subcat2[i][1], subcat2[i][2]);
    } //建立option 
  } 
}
</script>


	</head>

	<body>
		<form id="form1" name="form1" method="post" action="newsManageAction.do?action=toManagePage">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="430" height="7"></td>
					<td rowspan="4" align="center">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td width="430" height="25" class="title14">新闻信息管理&gt;&gt; 
					</td>
				</tr>
				<tr>
					<td width="430" height="1" background="   image/bg/line_h_long.gif"></td>
				</tr>
				<tr>
					<td width="430" height="2"></td>
				</tr>
			</table>
			<table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
						  <tr>
                          <td bgcolor="#FFFFFF" class="title14">
                        查询条件：一级菜单 <select name="q1" id="q1" class="form12"  onchange="changeselect1(this.value);">
            <option value="-1">==全部==</option> 
     <c:forEach var="lmFir" items="${firstList}">
		<option <c:if test="${pageList.q1==lmFir.id}">selected</c:if> value="${lmFir.id}"> ${lmFir.name}</option>
        </c:forEach>
      </select> 二级菜单       <select id="q2" name="q2" class="form12" >
        <option value="-1">==全部==</option>
      </select>

 专题新闻
                          <select name="q3" id="q3"  class="form12"  onChange="changeselect2(this.value);" ><OPTION value="-1">==全部==</OPTION><c:forEach  items="${firstList2}" var="b"><option <c:if test="${pageList.q3==b.id}">selected</c:if> value="${b.id}">${b.name}</option></c:forEach></select>
                           专题小类
                          <select name="q10" id="q10"  class="form12"  ><option value="-1">==全部==</option></select>
                       </tr>   
                       <tr>
						<td bgcolor="#FFFFFF"   class="title14" style="padding-left:72px">   
                        <span >起始日期 <input name="q4" type="text" class="form12" id="q4" size="10" value="${pageList.q4}" readonly="true" />
                        <%=util.showDateSel("form1.q4")%>  终止日期 <input name="q5" type="text" class="form12" id="q5" size="10" value="${pageList.q5}"  onClick="" readonly="true"  />
                        <%=util.showDateSel("form1.q5")%> </span></td>
              </tr>
						  <tr>
						    <td bgcolor="#FFFFFF"   class="title14" style="padding-left:72px">中文新闻
						       <select   id="q6" name="q6" class="form12" >
						        <option value="-1" <c:if test="${pageList.q6=='-1'}">selected</c:if>>--全部--</option>
						        <option value="0"  <c:if test="${pageList.q6=='0'}">selected</c:if>>中文新闻</option>
						        <option value="1"  <c:if test="${pageList.q6=='1'}">selected</c:if>>英文新闻</option>
					          </select>
审核
<select  id="q7" name="q7"  class="form12"  >
  <option value="-1"  <c:if test="${pageList.q7=='-1'}">selected</c:if> >--全部--</option>
  <option value="1"  <c:if test="${pageList.q7=='1'}">selected</c:if>>已审核</option>
  <option value="0"  <c:if test="${pageList.q7=='0'}">selected</c:if>>未审核</option>
</select>
图片新闻
<select   id="q8" name="q8" class="form12"  >
  <option value="-1"  <c:if test="${pageList.q8=='-1'}">selected</c:if> >--全部--</option>
  <option value="1"  <c:if test="${pageList.q8=='1'}">selected</c:if>>图片新闻</option>
  <option value="0"  <c:if test="${pageList.q8=='0'}">selected</c:if>>文字新闻</option>
</select>
新闻作者
<input   id="q9"  name="q9" class="form12" value="${pageList.q9}"  type="text">
<input name="imageField" type="image" onClick="queryClick()" src="image/botton/query_s.jpg" /></td>
		      </tr>
                        </table>

<table width="%" border="0" cellpadding="2" cellspacing="0">

				<tr>
					<td class="text12">
						<label>
							共
							<c:out value="${pageList.totalnum}"></c:out>
							条记录

							<select name="fetch" class="form12" id="fetch"
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
					<td width="20%" background="image/bg/table_head.gif">新闻标题					</td>
					<td  width="10%" background="image/bg/table_head.gif">一级菜单</td>
					<td  width="8%" background="image/bg/table_head.gif">二级菜单</td>
					<td  width="8%" background="image/bg/table_head.gif">专题</td>
					<td  width="8%" background="image/bg/table_head.gif">专题小类</td>
					<td  width="5%" background="image/bg/table_head.gif">被审核</td>
					<td  width="7%" background="image/bg/table_head.gif">中文新闻</td>
					<td  width="7%" background="image/bg/table_head.gif">图片新闻</td>
					<td  width="7%" background="image/bg/table_head.gif">浏览次数</td>
					<td width="5%" height="30" background="image/bg/table_head.gif">
						作者					</td>
					<td width="7%" background="image/bg/table_head.gif">
						发布日期</td>
					<td width="15%" background="image/bg/table_head.gif">
						相应操作					</td>
				</tr>
				<c:forEach var="n" items="${list}">
					
					<tr align="center" bgcolor="#FFFFFF" class="text12">
						<td>
							<c:if test="${n.newsTop==1}">【头条新闻】</c:if><c:out value="${n.newsName}"></c:out>						</td>
						<td>${n.boNavigationByNewsBig.name}</td>
						<td>${n.boNavigationByNewsSmall.name}</td>
						<td>${n.boSpecial.name}</td>
						<td>${n.specialSmall.name}</td>
						<td><c:if test="${n.newsCheck==1}"><img src="image/icon/form/icon_right.gif"></c:if></td>
						<td><c:if test="${n.en==0}"><img src="image/icon/form/icon_right.gif"></c:if></td>
						<td><c:if test="${n.newsPicture==1}"><img src="image/icon/form/icon_right.gif"></c:if></td>
						<td>${n.newsViewtimes}</td>
						<td height="20">
							<c:out value="${n.newsAuthor}"></c:out>						</td>

						<td>
							<fmt:formatDate type="date" value="${n.newsTime}" pattern="yyyy-MM-dd"/>						</td>
						<td>
							<a href="newsAction.do?action=toModifyNewsPage&id=${n.id}"><font
								color="#33CCFF">修改</font></a> | 
							<a href="newsAction.do?action=delete&id=${n.id}"
								OnClick="return del()"><font color="#33CCFF">删除</font>							</a>						</td>
					</tr>
				</c:forEach>
			</table>
			
	</form>
	</body>
</html>
