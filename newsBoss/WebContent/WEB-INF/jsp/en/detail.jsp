<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <base href="<%=basePath%>"/>
<title>Party School of State Grid Corporation of China | Advanced Training Center of State Grid Corporation of China</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/default.css">
</head>
<body text="#000000" bgColor="#e6e6e6" topMargin="0">
<%@ include file="head.jsp"%>

<Table cellSpacing=0 cellPadding=0 width=770 align=center border=0 bgcolor="#FFFFFF"> 
  <tr>
    <td>
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#e6e6e6" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book001.gif" width="770" height="14"></td>
        </tr>
      </Table>    </td>
  </tr>
  <tr>
    <td  valign="top" style="padding-left:3px" >
    
    
    <TABLE cellSpacing=0 cellPadding=0 width=740 border=0 style="padding-left:12px">

        <TR>

          <TD>
          <TABLE cellSpacing=0 cellPadding=0 width=551 border=0>
              <TR>
                <TD width=13 height=8><img src="image/main/home.gif" alt="" width="14" height="14" /></TD>
                <TD vAlign=center  height=25 style="padding-left:10px"><A  class="g13" 
                  href="mainAction.do?action=toIndexPage"><FONT 
                  class=g12>HOME</FONT></A> &gt; <A class="g13" 
                  href="enAction.do?action=toSecondaryPage&pnid=${news.boNavigationByNewsBig.id}&nid=-1"><FONT 
                  class=g12>${news.boNavigationByNewsBig.enname}</FONT></A> <c:if test="${news.boNavigationByNewsSmall!=null}"> &gt; <A class="g13" 
                  href="enAction.do?action=toSecondaryPage&pnid=${news.boNavigationByNewsBig.id}&nid=${news.boNavigationByNewsSmall.id}"><FONT 
                  class=g12>${news.boNavigationByNewsSmall.enname}</FONT></A></c:if></TD>
              </TR>
              </TABLE>
          </TD>
       </TR>

        <TR>
          <TD><IMG height=12 src="image/main/xl01.gif" width=740></TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TR>
                <TD width=1 bgColor=#f1dfa3></TD>
                <TD align=center bgColor=#fdfcf2>
                  <TABLE cellSpacing=4 cellPadding=0 width="94%" border=0>
                    <TR>
                      <TD align=center style="line-height:25px;">
<span style="font-weight:bold; font-size:14px; color:#000000;">

</span>
					<c:if test="${news.newsNameSet!='bigup'}">
															<span class="cmstitle">${news.newsName}</span>
															<br>
															<font
																style="font-weight: bold; font-size: 14px; color: #000000;">${news.newsName2}</font>
													</TD>
													</c:if>
													<c:if test="${news.newsNameSet=='bigup'}">
														<font
															style="font-weight: bold; font-size: 14px; color: #000000;">${news.newsName2}</font>										
														<br>
														<span class="cmstitle">${news.newsName}</span>
														</TD>
													</c:if>

                    </TR>

                    <TR>

                      <TD height=4></TD></TR>

                    <TR>

                      <TD background="image/main/xl03.gif" height=1></TD></TR>

                    <TR>

                      <TD height=4></TD></TR>

                    <TR>

                      <TD align="center" vAlign=top class=black12 style="font-size:14px;">Author：${news.newsAuthor}　　Release Date：<fmt:formatDate type="date" value="${news.newsTime}" pattern="yyyy-MM-dd"/>　　Clicks：${news.newsViewtimes}<span id="pageview"></span><br>

                          <br></TD>

                    </TR>

                    <TR>

                      <TD class="cmscontent"  align="left" vAlign=top>${news.newsContent}
<P>　　Source：${news.newsSource}</P></TD>

                    </TR>
                    
                     <TR>

                      <TD class="cmscontent"  align="left" vAlign=top>
<P>　　Attachment：   <table>   <c:forEach items="${encloMap}" var="enclo">
		
       <tr>
       <td style=" padding-left:30px">
      <a href="mainAction.do?action=download&fileName=${enclo.key}">${enclo.value}</a>
      <td>
      <tr>
     </c:forEach>
     
	</table>

</P></TD>



                    </TR>

                    <TR>

                      <TD align="center" vAlign=top class=black12></TD>

                    </TR>

                    <TR>

                      <TD align="center" vAlign=top class=black12><a href="javascript:window.close()"  style="color:#000000; text-decoration:none">【Close Window】</a></TD>
                    </TR>

</TBODY></TABLE></TD>

                <TD width=1 bgColor=#f1dfa3></TD></TR></TBODY></TABLE></TD></TR>

        <TR>

          <TD><IMG height=12 src="image/main/xl02.gif" width=740></TD></TR>

        <TR>

      <TD>&nbsp;</TD>

    <TD width="1" 

bgcolor="#FFFFFF"></TD></TR></TABLE>
    
    </td>
  </tr>

  
    <tr>
  
  

          <td>
    <Table cellSpacing=0 cellPadding=0 width="100%" border=0> 
        <tr>
          <td height=1 bgcolor="#ffffff" class="g12">&nbsp;</td>
        </tr>
        <tr>
          <td height=2><img src="image/main/book0021.gif" width="770" height="14"></td>
        </tr>
      </Table>     </td>
  </tr>
</table>



<Table cellSpacing=0 cellPadding=0 width="770" border=0  align="center"> 
      
       
        <tr >
          <td height=10 bgcolor="#e6e6e6">&nbsp;</td>
        </tr> </Table>
<%@ include file="bottom.jsp"%>

</body>

</HTML>