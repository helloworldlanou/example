<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>

<!--[if IE 7]><!--><link href="css/default.css" rel="stylesheet" type="text/css" /><!--<![endif]-->
<!--[if lte IE 6]><link rel="stylesheet" type="text/css" href="css/defaultIE6.css" /><![endif]-->

<TABLE cellSpacing=0 cellPadding=0 width=780 align=center border=0>
  <TR>
    <TD width=1 bgColor="#ffffff"></TD>
    <TD width="779" bgColor="#ffffff">
      <TABLE cellSpacing=0 cellPadding=0 width="779" border=0>
       
        <TR>
          <TD width=422><a href="enAction.do?action=toIndexPage" ><img src="image/main/logo1112.jpg" width="422" height="100" border="0" /></a></TD>
          <TD align=left width=357><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100%" height="100" title="top">
    <param name="movie" value="image/main/banner0904.swf" />
    <param name="quality" value="high" />
	<param name="wmode" value="transparent"/>
    <embed src="image/main/banner0904.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100%" height="100"></embed>
  </object></TD>
      </TR></TABLE></TD>
    </TR></TABLE>
<TABLE width=780 border=0 align=center cellPadding=0   cellSpacing=0>

  <TR>
    
    <TD width="780" bgColor=#ffffff>

      <TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor="#e6e6e6"  border=0>
        
        <TR>
        <td width="1" ></td>
          <TD width=""  align=middle class=w12>
          
          
<div id=menu>
		<!-- Navigation Level 2 (Drop-down menus) --> 
        <ul id="navigation"> 
	
	          <!-- Navigation item --> 
          
            <li><a href="enAction.do?action=toIndexPage" >HOME
			
			</a>
			</li> 
	
	 <c:forEach items="${mainList}" var="mainnode" >
	  <c:if test="${mainnode.showup=='showup'}" var="have">
	   <c:set var="havechild" value="no" scope="page"/>
	    <!-- 判断此一级菜单有没有二级菜单 -->
	   <c:forEach items="${rootList}" var="node" >
        
          <c:if test="${node.parentId==mainnode.id}" var="have">
          </c:if>
          <c:if test="${have}">
          <c:set var="havechild" value="yes"/>
          </c:if>
         
       </c:forEach>
	 <c:choose>
	 <c:when test="${havechild=='no'}">
     <c:if test="${mainnode.type!='custom'}">
	 	<!-- Navigation item --> 
         <li><a href="enAction.do?action=toSecondaryPage&pnid=<c:out value = '${mainnode.id}' />&nid=-2" ><c:out value = "${mainnode.enname}" /></a>   </li> 
     </c:if>
     <c:if test="${mainnode.type=='custom'}">
	 	<!-- Navigation item --> 
         <li><a href="enAction.do?action=toFacilityPage&pnid=<c:out value = '${mainnode.id}' />&nid=-2" ><c:out value = "${mainnode.enname}" /></a>   </li> 
     </c:if>
	 </c:when>
	 <c:otherwise>
      <c:if test="${mainnode.type!='custom'}">
	 	 <!-- Navigation item --> 
            <li><a href="enAction.do?action=toSecondaryPage&pnid=<c:out value = '${mainnode.id}' />&nid=-1" ><c:out value = "${mainnode.enname}" />
			 <!--[if IE 7]><!-->
			 </a>
			 <!--<![endif]-->
			  <table><tr><td>
                <ul> 
     </c:if>   
           <c:if test="${mainnode.type=='custom'}">
	 	 <!-- Navigation item --> 
            <li><a href="enAction.do?action=toFacilityPage&pnid=<c:out value = '${mainnode.id}' />&nid=-1" ><c:out value = "${mainnode.enname}" />
			 <!--[if IE 7]><!-->
			 </a>
			 <!--<![endif]-->
			  <table><tr><td>
                <ul> 
     </c:if>            
                
          <c:forEach items="${rootList}" var="node" >
          
          <c:if test="${node.parentId==mainnode.id}" var="have">
          <c:if test="${node.type=='custom'}">
          	 <li><a href="enAction.do?action=toFacilityPage&pnid=<c:out value = '${mainnode.id}' />&nid=<c:out value = '${node.id}' />&q1=${node.boFacilityType.id}" ><c:out value="${node.enname}" /></a></li> 
          </c:if>
          <c:if test="${node.type!='custom'}">
          	 <li><a href="enAction.do?action=toSecondaryPage&pnid=<c:out value = '${mainnode.id}' />&nid=<c:out value = '${node.id}' />"  ><c:out value="${node.enname}" /></a></li> 
          </c:if>
          </c:if>
         
          </c:forEach>
      </ul> 
       </td></tr>
      </Table>
          <!--[if lte IE 6]>
            </a>
            <![endif]-->
            </li> 
	 
	 
	 </c:otherwise>
	 </c:choose>
</c:if>
    </c:forEach>
    
	    <li ><a href="mainAction.do?action=toIndexPage" >中文版
			
			</a>
			</li> 
	      
            
        </ul>
        
		


</div></TD>
 
        </TR></TABLE>
        </TD>
</TR></TABLE>
