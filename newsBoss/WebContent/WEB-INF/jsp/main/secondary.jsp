<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="now" class="java.util.Date" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <base href="<%=basePath%>"/>
<title>中共国家电网公司党校 | 国家电网公司高级培训中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/default.css"/>
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
<body text="#000000" bgColor="#e6e6e6" topMargin="0">
<%@ include file="head.jsp"%>
<Table cellSpacing=0 cellPadding=0 width=770 align=center border=0 bgcolor="#FFFFFF"> 
  <tr>
    <td colspan="2">
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#e6e6e6" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book001.gif" width="770" height="14"></td>
        </tr>
      </Table>
    </td>
  </tr>
  <tr>
    <td width="164"  valign="top" style="padding-left:3px" background="image/main/di0011.gif" bgcolor="#e6e6e6">
    
 <table width="155" border="0" cellpadding="0" cellspacing="0" background="image/main/di0011.gif" bgcolor="#e6e6e6">
   <c:if test="${nid==-2}">
<tr>
  <td background="image/main/1-8.gif" width="155" height="35"><span style="padding-left:60px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=-2"><c:out value="${pn.name}"/></a></span> </td>
</tr>
</c:if>
   <c:if test="${nid!=-2}">
<tr>
  <td background="image/main/1-8.gif" width="155" height="35"><span style="padding-left:60px"><a class="styleWhite" href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=-1"><c:out value="${pn.name}"/></a></span> </td>
</tr>
</c:if>
<tr>
  <td align="center" valign="top">
  <table width="160" border="0" cellspacing="0" cellpadding="0">
  <c:forEach items="${nlist}" var="n" >
    <tr>
      <td width="57" valign="middle"><c:if test='${n.id!=nid}'><img src="image/main/1-9.gif" alt="" width="28" height="28" /></c:if><c:if test='${n.id==nid}'><img src="image/icon/form/icon_right.gif" alt=""  /></c:if></td>
      <td height="40" align="left"><a href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=<c:out value='${n.id}' />" class="g13"><c:out value="${n.name}" /></a></td>
    </tr>
	<tr>
      <td background=image/main/xxgl.gif height=1 colspan="2"></td>
    </tr>
  </c:forEach>  
  <c:if test="${nid==-2}">
      <tr>
      <td width="57" valign="middle"><img src="image/icon/form/icon_right.gif" alt=""  /></td>
      <td height="40" align="left"><a href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=-2" class="g13"><c:out value="${pn.name}" /></a></td>
    </tr>
	<tr>
      <td background=image/main/xxgl.gif height=1 colspan="2"></td>
    </tr>
  </c:if>              
  </table></td> 
</tr>
</table>
    </td> 
                
                
                  
                  
    <td width="585"  valign="top" style=" padding-left:12px">
    <table width="585"  border=0 cellPadding=0 cellSpacing=0>
      <tr>
        <td>
        
         <TABLE cellSpacing=0 cellPadding=0 width=551 border=0>
              <TR>
                <TD width=13 height=8><img src="image/main/home.gif" alt="" width="14" height="14" /></TD>
                <TD vAlign=center  height=25 style="padding-left:10px"><A  class="g13" 
                  href="mainAction.do?action=toIndexPage"><FONT 
                  class=g12>首页</FONT></A> &gt; 
                  <c:if test="${nid!='-2'}">
                  <A class="g13" 
                  href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=-1"><FONT 
                  class=g12><c:out value="${pn.name}" /></FONT></A>
                  </c:if>
                  <c:if test="${nid=='-2'}">
                  <A class="g13" 
                  href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=-2"><FONT 
                  class=g12><c:out value="${pn.name}" /></FONT></A>
                  </c:if>
                  <c:if test='${nid!=-1&&nid!=-2}'> &gt; <A class="g13" 
                  href="mainAction.do?action=toSecondaryPage&pnid=<c:out value = '${pn.id}' />&nid=${nid}"><FONT 
                  class=g12><c:out value="${nname}"/></FONT></A></c:if>
                  
                  
                  </TD>
              </TR>
              </TABLE>
        
        </td>
      </tr>
      <tr>
        <td>
        
         <form name="form1" method="post" action="mainAction.do?action=toSecondaryPage">
         <input name="pnid" type="hidden" value="${pn.id}" />
         <input name="nid" type="hidden" value="${nid}" />
        
        <TABLE cellSpacing=0 cellPadding=0 width=551 border=0>
              <TR>
                <TD  height=30 background="image/main/show1.gif"><span style="padding-left:60px" class="styleWhite"><c:out value="${nname}"/></span> </TD>
                </TR>
              </TABLE>
        
        </td>
      </tr>
      <tr>
        <td>
        <c:if test="${pageType=='news'}">
        
                <c:if test="${fn:length(list)==0}">
        <p>&nbsp;</p>
<table width="540" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="45">&nbsp;</td>
    <td width="164"><img src="image/error/errorinfo_pic.jpg" width="154" height="165" /></td>
    <td width="300" class="title14_red_line"><p>此页面正在处理中，将于近期恢复使用。<br />
   </p>
      <p>对您造成的不便在此表示抱歉！<br />
     </p>
    </td>
  </tr>
</table>
        </c:if>
        
          <c:if test="${fn:length(list)>0}">
        
        <table width="550" border=0 cellPadding=0 cellSpacing=2>         
        <c:forEach var="n"  items="${list}"  >   
           <tr style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(image/main/news-bg.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 22px">
                <td class=black12 align=middle width="4%"><img src="image/main/dig.gif" alt="" width="9" height="7" /></td>
                <td class=black12 width="77%" height=30><div align="left"><A class=black12   href="mainAction.do?action=toDetailPage&newsid=${n.id}" 
                  target=_blank>${n.newsName}</A>                   
				  <script language="JavaScript">
					//MM-DD-YYYY格式,返回相差的天数
					var now = new Date(<fmt:formatDate type="date" value="${now}" pattern="yyyy,MM,dd"/>);
					var newstime = new Date(<fmt:formatDate type="date" value="${n.newsTime}" pattern="yyyy,MM,dd"/>)
					
					var iDays = parseInt((now.getTime()-newstime.getTime())/86400000)  //把相差的毫秒数转换为天数
					if(iDays <= 3){
						document.write("<img src=\"image/main/new1.gif\" alt=\"\" width=\"22\" height=\"9\" />");
					}	
				 </script></div></td>
              <td class=black12 width="19%"><div align="right">( <fmt:formatDate type="date" value="${n.newsTime}" pattern="yyyy-MM-dd"/> )</div></td>
          </tr>
         </c:forEach>  
         
    </table>
    
    
    
    
    
    
    
        </td>
      </tr>
      <tr>
        <td>
        
         <table width="93%"  border="0" cellpadding="2" cellspacing="1">

           <tr>
                            <td class="text12"><label>
                              共<c:out value="${pageList.totalnum}"></c:out>条记录

							
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
        </c:if>
        </c:if>
        <c:if test="${pageType=='info'}">
		<c:if test="${detail.id==null}">
        <p>&nbsp;</p>
<table width="540" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="45">&nbsp;</td>
    <td width="164"><img src="image/error/errorinfo_pic.jpg" width="154" height="165" /></td>
    <td width="300" class="title14_red_line"><p>此页面正在处理中，将于近期恢复使用。<br />
   </p>
      <p>对您造成的不便在此表示抱歉！<br />
     </p>
    </td>
  </tr>
</table>
        </c:if>
        <c:if test="${detail.id!=null}">
        <table width="550" border="0">
  <tr>
    <td>${detail.newsContent}</td>
  </tr>
</table>

        
        </c:if>
        </c:if>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>

  
    <tr>
  
  

          <td colspan="2">
           </form>
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#ffffff" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book0021.gif" width="770" height="14"></td>
        </tr>
      </Table>

     </td>
   
  </tr>
        
  
</table>



<Table cellSpacing=0 cellPadding=0 width="770" border=0  align="center"> 
      
       
        <tr >
          <td height=10 bgcolor="#e6e6e6">&nbsp;</td>
        </tr> </Table>

<%@ include file="bottom.jsp"%>

</body>

</HTML>