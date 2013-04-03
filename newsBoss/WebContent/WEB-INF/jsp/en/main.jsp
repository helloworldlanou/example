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
<title>Party School of State Grid Corporation of China | Advanced Training Center of State Grid Corporation of China </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
 

.collapsed {
display: none;
}
.expanded{
}
-->
</style>

<script type="text/javascript">
<!--
var LastLeftID = "";

function DoMenu(emid)
{

var obj = document.getElementById(emid);


obj.className = (obj.className.toLowerCase() == "expanded"?"collapsed":"expanded");

if((LastLeftID!="")&&(emid!=LastLeftID)) //关闭上一个Menu
{
document.getElementById(LastLeftID).className = "collapsed";
}

//LastLeftID = emid;
}

-->
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
    <td width="164"  valign="top" style="padding-left:3px"> 
    
    <c:forEach items="${mainList}" var="mainnode" >
    <c:set var="havechild" value="no" scope="page"/>
    <c:forEach items="${rootList}" var="node" >
        
          <c:if test="${node.parentId==mainnode.id}" var="have">
          </c:if>
          <c:if test="${have}">
          <c:set var="havechild" value="yes"/>
          </c:if>
         
       </c:forEach>
   <Table width=164  border=0 cellPadding=0 cellSpacing=0 bgColor=#ededed> 
   <c:if test="${havechild=='no'}">
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" >
       <span style="padding-left:35px">
       <a class="styleWhite" style="cursor:pointer"  onclick="DoMenu('${mainnode.id}')" ><c:out value = "${mainnode.enname}" /></a></span>
       </td>
     </tr>
     </c:if>
        <c:if test="${havechild=='yes'}">
     <tr>
       <td height=24  vAlign=middle background="image/main/headline.gif" bgcolor="#FFFFFF" >
      	 <c:if test="${mainnode.type!='custom'}">
<span style="padding-left:35px">
       <a class="styleWhite" style="cursor:pointer" onclick="DoMenu('${mainnode.id}')"><c:out value = "${mainnode.enname}" /></a></span>
       </c:if>
       <c:if test="${mainnode.type=='custom'}">
<span style="padding-left:35px">
       <a class="styleWhite"  style="cursor:pointer" onclick="DoMenu('${mainnode.id}')"><c:out value = "${mainnode.enname}" /></a></span>
       </c:if>
       
       </td>
     </tr>
     </c:if>
      <tr>
      <td width="160" bgcolor="#FFFFFF">
          <Table id="${mainnode.id}"  class="expanded" valign="top" width=160 border=0 cellPadding=0 cellSpacing=2 background="image/main/di0011.gif" bgcolor="#e6e6e6">
          <c:forEach items="${rootList}" var="node" >
         
          <c:if test="${node.parentId==mainnode.id}" var="have">
          	 <tr >
                <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                <td height=20>
                <c:if test="${node.type!='custom'}">
                <A class=g12  href="enAction.do?action=toSecondaryPage&pnid=<c:out value = '${mainnode.id}' />&nid=<c:out value = '${node.id}' />" >&nbsp;<c:out value="${node.enname}" /></A>
                </c:if>
                <c:if test="${node.type=='custom'}">
                <A class=g12  href="enAction.do?action=toFacilityPage&pnid=<c:out value = '${mainnode.id}' />&nid=<c:out value = '${node.id}' />&q1=${node.boFacilityType.id}" >&nbsp;<c:out value="${node.enname}" /></A>
                </c:if>
                </td>
             </tr>
             <tr>
                 <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
             </tr>
          
          </c:if>
          <c:if test="${have}">
          <c:set var="havechild" value="yes"/>
          </c:if>
          </c:forEach>
          <c:if test="${havechild=='no'}">
           <tr >
                <td align=right ><IMG height=9  src="image/main/arrow_021.gif" width=12></td>
                <td height=20><A class=g12 href="enAction.do?action=toSecondaryPage&pnid=<c:out value = '${mainnode.id}' />&nid=-2" >&nbsp;<c:out value="${mainnode.enname}" /></A></td>
             </tr>
             <tr>
                 <td colSpan=2><IMG height=2  width="160"  src="image/main/line01.gif" ></td>
             </tr>
          </c:if>
      
       </Table></td></tr>
      </Table>
    
    </c:forEach>
    
         
    <td width="585"  valign="top" style=" padding-left:12px">
    
    
    <table width="575" border="0">
      <tr>
        <td width="575">    
    		<table cellSpacing=0 cellPadding=0 width=560 border=0> 
         		<tr>
             		 <td><IMG height=17 src="image/main/tt-011.gif" width=575></td>
       	      </tr> 
   		    </table>
   		     <table cellSpacing=0 cellPadding=0 width=575 border=0> 
                <tr>
                     <td vAlign=top width=6 height=179><IMG height=179 src="image/main/tt_02.gif" width=6></td>
                     <td vAlign=top align=middle>
                     	 <table cellSpacing=0 cellPadding=0 width="99%" border=0> 
                        	<tr>
                          		<td vAlign=top align=middle width=5><c:if test="${top.id!=null}"> <a href="enAction.do?action=toDetailPage&newsid=${top.id}" target="_blank" ></c:if><c:if test="${topPic!=null}"><IMG height=160 src="${topPic}"  width=200 border=0></c:if><c:if test="${topPic==null}"><IMG height=160 src="image/error/error.jpg"  width=200 border=0></c:if><c:if test="${top.id==null}"></a></c:if></td>
                         		 <td>
                         		 <table width="99%" height="151"    border=0 cellPadding=0 cellSpacing=4> 
                             	 		<tr>
                              	 			 <td align=middle><B  style="FONT-SIZE: 14px; COLOR: #000000; LINE-HEIGHT: 22px"></B></td>
                               		    </tr>
                              			 <tr>
                                			 <c:if test="${top.newsNameSet!='bigup'}">
                                			<td align=middle><B  style="FONT-SIZE: 16px; COLOR: #9c0000"><c:if test="${top.id==null}">Now there is no headline!</c:if>${top.newsName}</B>
                                			<br>
											<font style="font-weight: bold; font-size: 14px; color: #000000;">${top.newsName2}</font></td>
											</c:if>
											<c:if test="${top.newsNameSet=='bigup'}">
											<td align=middle><font style="font-weight: bold; font-size: 14px; color: #000000;">${top.newsName2}</font>
                                			<br>
                                			<B  style="FONT-SIZE: 16px; COLOR: #9c0000"><c:if test="${top.id==null}">Now there is no headline!</c:if>${top.newsName}</B>
                                			</td>
											</c:if>
                                			
                               			 </tr>
                              			
                             	 		
                             			 <tr>
											 <td style="LINE-HEIGHT: 20px"  align=left>　&nbsp;&nbsp;<c:set var="contentlength" value='${fn:length(topContent)}'/>
                  <c:choose>
                 	 <c:when test="${ contentlength < 160 }" >
                 		 <a class=black12 href="enAction.do?action=toDetailPage&newsid=${top.id}" target="_blank"><c:out value="${topContent}" /></a>
                  	 </c:when>
                  	 <c:otherwise>
                  		<c:set var="subname" value='${fn:substring(topContent,0,159)}'/>
                   	 <a class=black12 href="enAction.do?action=toDetailPage&newsid=${top.id}" target="_blank"><c:out value="${subname}" />......</a>
                  	 </c:otherwise>
                  </c:choose></td>
                             			 </tr>
                             	</table>                            	</td>
                            </tr>
                       </table>                         </td>
                    <td vAlign=top width=6><IMG height=179  src="image/main/tt_02.gif" width=6></td>
              </tr> 
          </table>                 </td>
      </tr>
      <tr>
        <td>
        
        
<table width="585" border="0">
  <tr>
    <td width="387" valign="top">
    
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
             <tr>
              	 <td background="image/main/1-3.gif" height="30"  align="left"><span  style="padding-left:60px"><a class="styleWhite" href="enAction.do?action=toSecondaryPage&pnid=4a4cc0c91f6d690d011f6d6f773b0003&nid=4a4cc0ef1fff14f7011fff2a542d0003">Center News</a></span><span   style="padding-left:150px">	  <a class="styleWhite" href="enAction.do?action=toSecondaryPage&pnid=4a4cc0c91f6d690d011f6d6f773b0003&nid=4a4cc0ef1fff14f7011fff2a542d0003" >
	  More>>
	  </a></span> </td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
      
      <c:forEach items="${centernews}" var="centernews" varStatus="number">
        <c:if test="${number.count<=10 }" >
         <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="71%" height=17><div align="left"><A class=black12  href="enAction.do?action=toDetailPage&newsid=${centernews.id}" 
                  target=_blank>
                  <c:set var="namelength" value='${fn:length(centernews.newsName)}'/>
                  <c:choose>
                 	 <c:when test="${ namelength < 20 }" >
                 		 <c:out value="${centernews.newsName}" />
                  	 </c:when>
                  	 <c:otherwise>
                  		<c:set var="subname" value='${fn:substring(centernews.newsName,0,19)}'/>
                   	 <c:out value="${subname}" />...
                  	 </c:otherwise>
                  </c:choose>
                  
                  </A> 
                  <script language="JavaScript">
					//MM-DD-YYYY格式,返回相差的天数
					var now = new Date(<fmt:formatDate type="date" value="${now}" pattern="yyyy,MM,dd"/>);
					var newstime = new Date(<fmt:formatDate type="date" value="${centernews.newsTime}" pattern="yyyy,MM,dd"/>)
					
					var iDays = parseInt((now.getTime()-newstime.getTime())/86400000)  //把相差的毫秒数转换为天数
					if(iDays <= 3){
						document.write("<img src=\"image/main/new1.gif\" alt=\"\" width=\"22\" height=\"9\" />");
					}	
				 </script>

                  </div></td>
                <td class=black12 width="25%">( <fmt:formatDate type="date" value="${centernews.newsTime}" pattern="MM.dd.yyyy"/> )</td>
        </tr>
        </c:if>
      </c:forEach>
        
    </table>   
    <!-- 
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
              <tr>
              	 <td background="image/main/1-3.gif" width="184" height="30"><span  style="padding-left:60px"><A class="styleWhite"  href="enAction.do?action=toSecondaryPage" 
>Training Dynamic</A></span></td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
          <c:forEach items="${trainingnews}" var="trainingnews" varStatus="number">
        <c:if test="${number.count<=10 }" >
         <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="71%" height=17><div align="left"><A class=black12  href="enAction.do?action=toDetailPage&newsid=${trainingnews.id}" 
                  target=_blank>
                  <c:set var="namelength" value='${fn:length(trainingnews.newsName)}'/>
                  <c:choose>
                 	 <c:when test="${ namelength < 20 }" >
                 		 <c:out value="${trainingnews.newsName}" />
                  	 </c:when>
                  	 <c:otherwise>
                  		<c:set var="subname" value='${fn:substring(trainingnews.newsName,0,19)}'/>
                   	 <c:out value="${subname}" />...
                  	 </c:otherwise>
                  </c:choose>
                  
                  </A> 
                  <script language="JavaScript">
					//MM-DD-YYYY格式,返回相差的天数
					var now = new Date(<fmt:formatDate type="date" value="${now}" pattern="yyyy,MM,dd"/>);
					var newstime = new Date(<fmt:formatDate type="date" value="${trainingnews.newsTime}" pattern="yyyy,MM,dd"/>)
					
					var iDays = parseInt((now.getTime()-newstime.getTime())/86400000)  //把相差的毫秒数转换为天数
					if(iDays <= 3){
						document.write("<img src=\"image/main/new1.gif\" alt=\"\" width=\"22\" height=\"9\" />");
					}	
				 </script>

                  </div></td>
                <td class=black12 width="25%">( <fmt:formatDate type="date" value="${trainingnews.newsTime}" pattern="MM.dd.yyyy"/> )</td>
        </tr>
        </c:if>
      </c:forEach>
    </table>    
     -->
     <table cellSpacing=0 cellPadding=0 width=384 border=0> 
             <tr>
              	 <td background="image/main/1-3.gif" height="30"  align="left"><span  style="padding-left:60px"><a class="styleWhite" href="enAction.do?action=toSecondaryPage&pnid=4a4cc0c91f6d690d011f6d7007370006&nid=8a81fa2220a36ab50120a37984b10002">Success Cases</a></span><span   style="padding-left:134px">	  <a class="styleWhite" href="enAction.do?action=toSecondaryPage&pnid=4a4cc0c91f6d690d011f6d7007370006&nid=8a81fa2220a36ab50120a37984b10002" >
	  More>>
	  </a></span> </td>
              </tr>
              <tr>
                <td height=8></td>
              </tr>
     </table>
     <table width="384" border=0 cellPadding=0 cellSpacing=2> 
          <c:forEach items="${projectnews}" var="projectnews" varStatus="number">
        <c:if test="${number.count<=10 }" >
         <tr>
                <td class=black12 align=middle width="4%">·</td>
                <td class=black12 width="71%" height=17><div align="left"><A class=black12  href="enAction.do?action=toDetailPage&newsid=${projectnews.id}" 
                  target=_blank>
                  <c:set var="namelength" value='${fn:length(projectnews.newsName)}'/>
                  <c:choose>
                 	 <c:when test="${ namelength < 20 }" >
                 		 <c:out value="${projectnews.newsName}" />
                  	 </c:when>
                  	 <c:otherwise>
                  		<c:set var="subname" value='${fn:substring(projectnews.newsName,0,19)}'/>
                   	 <c:out value="${subname}" />...
                  	 </c:otherwise>
                  </c:choose>
                  
                  </A> 
                  <script language="JavaScript">
					//MM-DD-YYYY格式,返回相差的天数
					var now = new Date(<fmt:formatDate type="date" value="${now}" pattern="yyyy,MM,dd"/>);
					var newstime = new Date(<fmt:formatDate type="date" value="${projectnews.newsTime}" pattern="yyyy,MM,dd"/>)
					
					var iDays = parseInt((now.getTime()-newstime.getTime())/86400000)  //把相差的毫秒数转换为天数
					if(iDays <= 3){
						document.write("<img src=\"image/main/new1.gif\" alt=\"\" width=\"22\" height=\"9\" />");
					}	
				 </script>

                  </div></td>
                <td class=black12 width="25%">( <fmt:formatDate type="date" value="${projectnews.newsTime}" pattern="MM.dd.yyyy"/> )</td>
        </tr>
        </c:if>
      </c:forEach>
    </table>    
    
     
     </td>
    <td width="188" valign="top">
    
    
   <Table width=180 border=0 align="center" cellPadding=0 cellSpacing=2> 
              <tr>
                <td width="176" height="25" align=center background="image/main/mainright_top1.gif" bgColor=#f3f3f1 class="red14b STYLE47">Special reports</td>
              </tr>
              <c:forEach items="${special}" var="spe">
              <tr>
                <td align=middle >
                  <Table cellSpacing=0 cellPadding=0 width=172 align=center  border=0 > 
                  <tr>
                      <td height=10 colspan="2"></td></tr>
                    <tr>
                    <tr>
                      <td width="30"  align="left" ><img src="image/main/1-4.gif" alt="" width="30" height="30" /></td>
                      <td width="142"  align="left" ><a href="enAction.do?action=toSpecialSecondaryPage&specialid=<c:out value='${spe.id}' />" class=g13>${spe.enname }</a></td>
                    </tr>
                    <tr>
                      <td height=6 colspan="2"></td></tr>
                    <tr>
                      <td background=image/main/xxgl.gif height=1 colspan="2"></td></tr>
                    <tr>
                      <td height=6 colspan="2"> </td></tr>
                       </Table> </td>
                    </tr>
                    </c:forEach>
                    
                  </Table>
    

     <Table cellSpacing=0 cellPadding=0 width="180" border=0> 
              <tr>
                <td height=25></td>
                </tr>
     </Table>
     
    
         </td>
  </tr>
</table>        </td>
      </tr>
    </table>   </td>
  </tr>
  <tr >
  
  
    <td colspan="2" style=" padding-left:5px; padding-right:5px">
 
   <DIV id=demom style="OVERFLOW: hidden; WIDTH: 760px">
                  <Table borderColor=#ffffff cellSpacing=0 cellPadding=0  width=610 align=center border=0 cellspace="0"> 
                    <tr>
                      <td id=demom1 vAlign=center>
                        <Table borderColor=#ffffff height=104 cellSpacing=0   cellPadding=0 align=center border=0> 
                          <tr>
                           
                     <c:set var="picURL" value="${picURL}" scope="request"/>
      				<c:forEach items="${picnews}" var="picnews" varStatus="picnumber">
       					 <c:if test="${picnumber.count<=10&&picnews.newsPicture=='1'}">
          					 <td vAlign=bottom noWrap align=middle>
                              <Table cellSpacing=1 cellPadding=1 bgColor=#569d95   border=0> 
                                <tr>
                                <td bgColor=#ffffff><A title="<c:out value = '${picnews.newsName}' />"
                                href="mainAction.do?action=toDetailPage&newsid=${picnews.id}"  target=_blank>
								<IMG height=100 src="<c:out value="${picURL[picnumber.count-1]}"/>" width=149 border=0 />
                                </A></td>
                                </tr>
                              </Table>
                           </td>
                           <td vAlign=bottom noWrap align=middle width=3></td>
        				</c:if>
      				</c:forEach>

                          </tr>
                       </Table>
                    </td>
                      <td id=demom2 vAlign=top>java</td></tr></Table></DIV>
      <SCRIPT language=javascript>

var speed=15

demom2.innerHTML=demom1.innerHTML

function Marquee1(){

if(demom2.offsetWidth-demom.scrollLeft<=0)

demom.scrollLeft-=demom1.offsetWidth

else{

demom.scrollLeft++

}

}

var MyMar1=setInterval(Marquee1,speed)

demom.onmouseover=function() {clearInterval(MyMar1)}

demom.onmouseout=function() {MyMar1=setInterval(Marquee1,speed)}

</SCRIPT>                
 
 
    </td>
  </tr>
  
    <tr>
  
  

          <td colspan="2">
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

<div id="img" style="position:absolute;">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align=right><span onclick="closediv();" style="cursor:hand">[关闭]</span></td>
	</tr>
	<tr>
		<td><a href="" target=_blank><img border=0  src="upload/parameter/${floatPic}"></a></td>
	</tr>
</table>
</div>

<script language="JavaScript" src="js/float.js"></script>
<script language="JavaScript">
start();
function closediv() {
	img.style.display = "none";
}
</script>


<Table cellSpacing=0 cellPadding=0 width="770" border=0  align="center"> 
      
       
        <tr >
          <td height=10 bgcolor="#e6e6e6">&nbsp;</td>
        </tr> </Table>
        
<%@ include file="bottom.jsp"%>

</body>

</HTML>
