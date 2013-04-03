<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="fckeditor/fckeditor.js"></script>


<script type="text/javascript">




var subcat = new Array();
<c:forEach items="${rootList}" var="e" begin="0" end="${trLSize}" step="1" varStatus="x"> 
 subcat[<c:out value="${x.index}"/>] = new Array("<c:out value='${e.name}'/>","<c:out value='${e.id}'/>","<c:out value='${e.parentId}'/>");        
</c:forEach>

var tem = ${trLSize};
<c:forEach items="${special}" var="e"  step="1" varStatus="x"> 
 subcat[<c:out value="${x.index}"/>+tem] = new Array("<c:out value='${e.name}'/>","<c:out value='${e.id}'/>","-2");        
</c:forEach>

var onecount;

onecount=${trLSize}+${specialsize};


function changelocation(locationid)
{

document.form1.NclassId.length = 0;
var locationid = locationid;
var i;

for (i=0;i<onecount;i++)
{
if (subcat[i][2] == locationid)
{
document.form1.NclassId.options[document.form1.NclassId.length] = new Option(subcat[i][0], subcat[i][1]);

}
}
}
</script>


</head>

<body>

<table width="100%" height="500"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="430" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="6"></td>
            </tr>
            <tr>
              <td height="25" class="title14">　新闻信息内容 &gt;&gt;</td>
            </tr>
            <tr>
              <td height="1" background="image/bg/line_h_long.gif"></td>
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
        </table></td>
      </tr>
      <tr>
        <td>
        
    <form id="form1" name="form1" action="" method="post" enctype="multipart/form-data" onsubmit="return affice()">
 <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
	  <tr><td width="100px" align="center" bgcolor="#84B969" class="text12w">一级菜单</td>
	       <td  bgcolor="#FFFFFF">
                                <c:forEach items="${mainList}" var="n2">
                                <c:if test="${n2.id==mes.boNavigationByNewsBig.id}"><span class="title14">${n2.name}</span></c:if>
                               </c:forEach>
                               <c:if test="${mes.boNavigationByNewsBig.id==null||mes.boNavigationByNewsBig.id==''}">专题报道</c:if>
                             </td></tr>
          
          <tr ><td align="center" bgcolor="#84B969" class="text12w">二级菜单</td>
	       <td  bgcolor="#FFFFFF" ><span class="title14"><span class="title14">${smallname}</span></td></tr>
           <c:if test="${mes.specialSmall!=null}">
           <tr ><td align="center" bgcolor="#84B969" class="text12w">专题小类</td>
	       <td  bgcolor="#FFFFFF" ><span class="title14"><span class="title14">${mes.specialSmall.name}</span></td></tr>
           </c:if>
           
	  <tr><td align="center" bgcolor="#84B969" class="text12w" ><font color="#FF0000">*</font>&nbsp&nbsp大标题</td>
	      <td width="650"  bgcolor="#FFFFFF" ><span class="title14">${mes.newsName}</span></td></tr>
	      <tr><td align="center" bgcolor="#84B969" class="text12w" >&nbsp&nbsp小标题</td>
	      <td width="650"  bgcolor="#FFFFFF" ><span class="title14">${mes.newsName2}</span></td></tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w"  >新闻作者</td>
	      <td  bgcolor="#FFFFFF" ><span class="title14">${mes.newsAuthor}</span></td>
	  </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w"  >新闻来源</td>
	       <td  bgcolor="#FFFFFF" ><span class="title14">${mes.newsSource}</span></td>
	   </tr>
	              <tr><td align="center" bgcolor="#84B969" class="text12w" >新闻类型</td>
	    <td  bgcolor="#FFFFFF"  >
	    <c:if test="${mes.newsTop=='1'}"><font size="3" color="#FF0000">头条新闻</c:if>
	    <c:if test="${mes.newsPicture=='1'}"><font size="3" color="#FF0000">图片新闻</c:if>
       <c:if test="${mes.en=='1'}"><font size="3" color="#FF0000">英文新闻</c:if>
	    </td>
           </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w" valign="top">新闻内容</td>
           <td  bgcolor="#FFFFFF" >${mes.newsContent}</td>
           </tr>
            <tr><td align="center" bgcolor="#84B969" class="text12w">发布时间</td>
	       <td  bgcolor="#FFFFFF" ><span class="title14"><fmt:formatDate type="both" value='${mes.newsTime}'/></span></td>
	    </tr>

      <tr><td align="center" bgcolor="#84B969" class="text12w">附件内容</td>
	   <td  bgcolor="#FFFFFF">
       <c:if test="${mes.newsEnclo==null||mes.newsEnclo==''}"><font size="3" color="#FF0000">没有附件！</font></c:if>
        <c:if test="${mes.newsEnclo!=null&&mes.newsEnclo!=''}">
	    <c:forEach items="${enclo}" var="name">
          
             <font size="3" color="#FF0000">${name}</font>
          </c:forEach>
        </c:if>
	   </td>
       </tr>
       
       
      </table>
 <div id="left" >
    <table width="790" align="center" cellpadding="0" cellspacing="0"id="enclosure" name="table1">
      <tr>
          <td align="left">
		  <a href="javascript:history.back();"><img src="image/botton/back.jpg" border="0"  /></a>
		   <c:if test="${mes.newsCheck=='0'}">
		   <a href="newsManageAction.do?action=tohavechecked&id=${mes.id}"><img src="image/botton/fee_checked.jpg" border="0"  /></a>
           </c:if>
     </tr>
    </table>
</div>
  </form>
            
    </table></td>
  </tr>
</table>



</body>
</html>
