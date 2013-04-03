<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
 <form name="form1" method="post" action="facilityTypeAction.do?action=toManagePage">
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
                  <td width="430" height="25" class="title14">　设施类别列表 &gt;&gt;</td>
                  </tr>
                <tr>
                  <td width="430" height="1" background="   image/bg/line_h_long.gif"></td>
                  </tr>
				            <tr>
              <td height="12"></td>
            </tr>
             <tr bgcolor="#FFFFFF">
              <td><c:if test="${remind!=null}"><img src="image/icon/form/icon_remind.gif" /> </c:if><span class="errorAlert"><c:out value="${remind}"/></span><c:if test="${right!=null}"><img src="image/icon/form/icon_right.gif" /> </c:if><span class="rightAlert"><c:out value="${right}"/></span>
              </td>
            </tr>
           <tr>
              <td height="8"></td>
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
<SELECT name="pagenum" id="pagenum" class="myselect" onchange="document.form1.submit()">

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
                <table width="90%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr align="center" class="text14wb">
                   <td height="30" width="200px" background="image/bg/table_head.gif">序号</td>
                      <td background="image/bg/table_head.gif">设施类别名字</td>
                      <td background="image/bg/table_head.gif">对应的二级栏目</td>
                      <td background="image/bg/table_head.gif">英文名</td>
                      <td background="image/bg/table_head.gif">数量</td>
                      <td background="image/bg/table_head.gif">相应操作</td>
                  </tr>
                  <c:set var='num' value='0'/> 
<c:forEach var="n"  items="${list}"  >   
 <c:set var='num' value="${num+1}"/> 
                  <tr align="center" bgcolor="#FFFFFF" class="text12">
                  <td height="20px"><c:out value="${num}"/></td>
                      <td><c:out value="${n.name}" ></c:out></td>
                      <td ><c:out value="${n.boNavigation.name}" /></td>
                      <td >${n.enname}</td>
                      <td >
                      ${fn:length(n.boFacilities)}                      </td>
                      <td ><a href="facilityTypeAction.do?action=toModifyPage&id=<c:out value='${n.id}'/>"><img src="image/icon/dtree/179.gif" alt="修改"  border="0"  /></a> | <a href="facilityTypeAction.do?action=delete&id=<c:out value='${n.id}'/>"><img src="image/icon/dtree/trash.gif" alt="删除"  border="0" /></a></td>
                  </tr>
     </c:forEach> 
                </table></td>
            </tr>
          </table>
          
          
          
          <table width="700px"  border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td bgcolor="#FFFFFF"><a href="facilityTypeAction.do?action=toAddPage"><img src="image/botton/add.jpg" width="102" height="29" border="0" /></a></td>
	<td bgcolor="#FFFFFF">&nbsp;</td>
  </tr>
</table>

          </td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
