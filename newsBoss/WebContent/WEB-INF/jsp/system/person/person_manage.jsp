<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
body{
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/dtree.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />
<script language="javascript">
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

</head>

<body>
 <form name="form1" method="post" action="personAction.do?action=toManagePage">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  
  <tr>
    <td><table width="100%" height="500"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="650" border="0" cellspacing="0" cellpadding="0">
				<tr>
                  <td width="430" height="6"></td>
                  <td rowspan="4" align="center">&nbsp;</td>
				</tr>
				<tr>
                  <td width="430" height="25" class="title14">　系统人员列表 &gt;&gt;</td>
                  </tr>
                <tr>
                  <td width="430" height="1" background="   image/bg/line_h_long.gif"></td>
                  </tr>
				<tr>
                  <td width="430" height="2"></td>
                  </tr>
              </table>                </td>
            </tr>
            <tr>
              <td>                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <table width="98%" border="0" cellpadding="2" cellspacing="0">

                          <tr>
                            <td class="text12"><label>
                              共<c:out value="${pageList.totalnum}"></c:out>条记录

							<select name="fetch" class="myselect" id="fetch" onChange="queryClick()">
                              <option value="10" <c:if test="${pageList.fetch==10}">selected</c:if> >每页10条</option>
                              <option value="20" <c:if test="${pageList.fetch==20}">selected</c:if> >每页20条</option>
                              <option value="40" <c:if test="${pageList.fetch==40}">selected</c:if> >每页40条</option>
                              <option value="-1" <c:if test="${pageList.fetch==pageList.totalnum}">selected</c:if> >不分页</option>
                            </select>
                            </label></td>
                            <td class="text12">共<c:out value="${pageList.totalpage}"></c:out>页 
							当前第<c:out value="${pageList.pagenum}"></c:out>页　　
                            <c:if test="${pageList.pagenum>1}">
                            <a href="javascript:currPage(1)" class="a1">第一页</a> <a href="javascript:currPage(<c:out value="${pageList.pagenum-1}"></c:out>)" class="a1">上一页</a>
                            </c:if>
                            <c:if test="${pageList.pagenum<=1}">
第一页 上一页
</c:if>
<c:if test="${pageList.pagenum!=pageList.totalpage}">
<a href="javascript:currPage(<c:out value="${pageList.pagenum+1}"></c:out>)" class="a1">下一页</a> <a href="javascript:currPage(<c:out value="${pageList.totalpage}"></c:out>)" class="a1">最后页</a>
</c:if>
<c:if test="${pageList.pagenum==pageList.totalpage}">
下一页 最后页
</c:if>
　　跳转到
<SELECT name="pagenum" id="pagenum" onchange="document.form1.submit()">

<c:forEach var="i" begin="1" end="${pageList.totalpage}" step="1">   
            
<c:if test="${i==pageList.pagenum}">
  <option selected="selected" value=<c:out value="${i}"/> ><c:out value="${i}"/> </option>
</c:if>   
<c:if test="${i!=pageList.pagenum}">
  <option  value=<c:out value="${i}"/> ><c:out value="${i}"/> </option>
</c:if>           
</c:forEach>  

</SELECT>
页 </td>
                          </tr>
                          
                        </table>
                  </td>
                </tr>
              </table>
                <table width="99%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr align="center" class="text14wb">
                   <td background="image/bg/table_head.gif">姓名</td>
                      <td height="30" background="image/bg/table_head.gif">用户名</td>
                      <td background="image/bg/table_head.gif">性别</td>
                      <td background="image/bg/table_head.gif">所属部门</td>
                      <td background="image/bg/table_head.gif">职务</td>
                      </tr>
<c:forEach var="n"  items="${list}" >   

                  <tr align="center" bgcolor="#FFFFFF" class="text12">
                  <td><c:out value="${n.name}" ></c:out></td>
                    <td height="20"><c:out value="${n.userName}" ></c:out></td>
                      
                      <td><c:if test='${n.sex=="male"}' >男</c:if><c:if test='${n.sex=="female"}' >女</c:if></td>
                      <td><c:out value="${n.depName}" ></c:out></td>
                      <td><c:out value="${n.duty}" ></c:out></td>
                      </tr>
     </c:forEach> 
                </table></td>
            </tr>
          </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
