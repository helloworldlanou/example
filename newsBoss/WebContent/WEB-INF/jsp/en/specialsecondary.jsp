<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <base href="<%=basePath%>"/>
<title>国家电网公司高级培训中心</title>
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
function showMore(ssid){
var hid = "hiddenField"+ssid;
var mid = ssid+"more";
if(document.getElementById(hid).value=="notmore")
{
for(var i=1;i<100;i++)
{
var ids = ssid+""+i;

if(document.getElementById(ids)!=null){
document.getElementById(ids).style.display="";


}

}
document.getElementById(hid).value="more";
document.getElementById(mid).innerText="Close>>";
}

else
{
for(var i=7;i<100;i++)
{
var ids = ssid+""+i;
if(document.getElementById(ids)!=null){
document.getElementById(ids).style.display="none";

}

}
document.getElementById(hid).value="notmore";
document.getElementById(mid).innerText="More>>";
}

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

<tr>
  <td background="image/main/1-8.gif" width="155" height="35" class="styleWhite"><span style="padding-left:60px">Reports</span> </td>
</tr>
<tr>
  <td align="center" valign="top">
  <table width="160" border="0" cellspacing="0" cellpadding="0">
 <c:forEach items="${slist}"  var="spe">
    <tr>
      <td width="38" valign="middle"><c:if test='${spe.id!=special.id}'><img src="image/main/1-9.gif" alt="" width="28" height="28" /></c:if><c:if test='${spe.id==special.id}'><img src="image/icon/form/icon_right.gif" alt=""  /></c:if></td>
      <td width="122" height="40" align="left" class="g10"><a href="enAction.do?action=toSpecialSecondaryPage&specialid=<c:out value ='${spe.id}'/>" class="g10">${spe.enname}</a></td>
    </tr>
<tr>
                      <td background="image/main/xxgl.gif" height=1 colspan="2"></td></tr>
                      </c:forEach>
         
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
                  href="enAction.do?action=toIndexPage"><FONT 
                  class=g12>HOME</FONT></A> &gt; <A class="g13" 
                  href="enAction.do?action=toSpecialSecondaryPage&specialid=<c:out value = '${special.id}'/>"><FONT 
                  class=g12>Reports</FONT></A> &gt; <A class="g13" 
                  href="enAction.do?action=toSpecialSecondaryPage&specialid=<c:out value = '${special.id}'/>"><FONT 
                  class=g12>${special.enname }</FONT></A></TD>
              </TR>
              </TABLE>
        
        </td>
      </tr>
      
      <tr>
        <td>

        

        
        <table width="550" border=0 cellPadding=0 cellSpacing=2>        
        
         
         
         <!--循环开始-->
      <c:forEach items='${sl}' var='item'>

   



      
      <tr>
        <td>
        
        <TABLE cellSpacing=0 cellPadding=0 width=551 border=0>
              <TR>
                <TD  height=30 background="image/main/show1.gif"><span style="padding-left:60px"><a class="styleWhite" href="enAction.do?action=toSpecialSecondaryPage&specialid=<c:out value = '${special.id}'/>">${item.enname}</a></span> </TD>
                </TR>
              </TABLE>
        
        </td>
      </tr>
       <c:set value="0" var="i" />
       <c:forEach var="n"  items="${snewslist}"  >   
       <c:if test="${n.specialSmall.id==item.id}">
       <c:set value="${i+1}" var="i" />
      

           <tr id="${n.specialSmall.id}${i}" style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(image/main/news-bg.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 22px;" <c:if test="${i>6}"> style="display:none"</c:if>><td><table cellSpacing=0 cellPadding=0 width=551 border=0>
                <td class=black12 align=middle width="4%"><img src="image/main/dig.gif" alt="" width="9" height="7" /></td>
                <td class=black12 width="77%" height=30><div align="left"><A class=black12   href="enAction.do?action=toSpecialDetailPage&newsid=${n.id}" 
                  target=_blank>${n.newsName}</A>  <script language="JavaScript">
					//MM-DD-YYYY格式,返回相差的天数
					var now = new Date(<fmt:formatDate type="date" value="<%=new java.util.Date()%>" pattern="yyyy,MM,dd"/>);
					var newstime = new Date(<fmt:formatDate type="date" value="${n.newsTime}" pattern="yyyy,MM,dd"/>)
					
					var iDays = parseInt((now.getTime()-newstime.getTime())/86400000)  //把相差的毫秒数转换为天数
					if(iDays <= 3){
						document.write("<img src=\"image/main/new1.gif\" alt=\"\" width=\"22\" height=\"9\" />");
					}	
				 </script></div></td>
              <td class=black12 width="19%"><div align="right">( <fmt:formatDate type="date" value="${n.newsTime}" pattern="yyyy-MM-dd"/> )</div></td></table></td>
          </tr>

           </c:if>  
         </c:forEach>  
         
         
         <c:if test="${i==0}">
          <tr>
        <td style="padding-left:10px; padding-top:10px">No Content</td>
      </tr>
         </c:if>
      <tr>
       <c:if test="${i!=0}">

        <td class="g13" style="text-align:right; padding-right:10px"><a href="javascript:showMore('${item.id}')"><span id="${item.id}more">More>></span></a></td>
      </tr>

</c:if>
      <tr>
        <td><input type="hidden" name="hiddenField${item.id}" id="hiddenField${item.id}" value="notmore" /></td>
      </tr>
    
    
  </c:forEach>    
     
     <!--循环结束-->
         
         <tr>
        <td>
          <c:if test="${fn:length(sl)==0}">
       <table width="540" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="45">&nbsp;</td>
    <td width="164"><img src="image/error/errorinfo_pic.jpg" width="154" height="165" /></td>
    <td width="300" class="title14_red_line"><p>This page is being processed, will soon be re-used.<br />
   </p>
      <p>Inconvenience caused to you that in this sorry!<br />
     </p>
    </td>
  </tr>
</table>
       </c:if> 
        </td>
      </tr>
         
    </table>
    
    
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