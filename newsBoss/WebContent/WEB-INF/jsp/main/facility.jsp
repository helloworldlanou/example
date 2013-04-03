<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<script type="text/javascript" src="js/highslide.js"></script>
<link rel="stylesheet" type="text/css" href="css/highslide.css" />

<script type="text/javascript">
    hs.graphicsDir = 'image/graphics/';
    hs.outlineType = 'rounded-white';
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
  <td background="image/main/1-8.gif" width="155" height="35"><span style="padding-left:60px"><a class="styleWhite" href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=-2"><c:out value="${pn.name}"/></a></span> </td>
</tr>
</c:if>
   <c:if test="${nid!=-2}">
<tr>
  <td background="image/main/1-8.gif" width="155" height="35"><span style="padding-left:60px"><a class="styleWhite" href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=-1"><c:out value="${pn.name}"/></a></span> </td>
</tr>
</c:if>
<tr>
  <td align="center" valign="top">
  <table width="160" border="0" cellspacing="0" cellpadding="0">
  <c:forEach items="${nlist}" var="n" >
    <tr>
      <td width="57" valign="middle"><c:if test='${n.id!=nid}'><img src="image/main/1-9.gif" alt="" width="28" height="28" /></c:if><c:if test='${n.id==nid}'><img src="image/icon/form/icon_right.gif" alt=""  /></c:if></td>
      <td height="40" align="left"><a href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=<c:out value='${n.id}' />&q1=${n.boFacilityType.id}"  class="g13"><c:out value="${n.name}" /></a></td>
    </tr>
	<tr>
      <td background=image/main/xxgl.gif height=1 colspan="2"></td>
    </tr>
  </c:forEach>  
  <c:if test="${nid==-2}">
      <tr>
      <td width="57" valign="middle"><img src="image/icon/form/icon_right.gif" alt=""  /></td>
      <td height="40" align="left"><a href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=-2" class="g13"><c:out value="${pn.name}" /></a></td>
    </tr>
	<tr>
      <td background=image/main/xxgl.gif height=1 colspan="2"></td>
    </tr>
  </c:if>              
  </table></td> 
</tr>


<tr height="20px" >
    <td>
 
     </td>
 </tr>
<tr height="20px" >
    <td>
         <table width="160" border="0" >
  <tr>
    <td style="padding-left:20px">
     
         <div><img src="image/main/phone.gif" />预定电话</br></div> 
         </br>
         <div>
         010-51978000<br /><br />
         010-51978888
         </div>
    </td>
  </tr>
</table>
     </td>
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
                  href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=-1"><FONT 
                  class=g12><c:out value="${pn.name}" /></FONT></A>
                  </c:if>
                  <c:if test="${nid=='-2'}">
                  <A class="g13" 
                  href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=-2"><FONT 
                  class=g12><c:out value="${pn.name}" /></FONT></A>
                  </c:if>
                  <c:if test='${nid!=-1&&nid!=-2}'> &gt; <A class="g13" 
                  href="mainAction.do?action=toFacilityPage&pnid=<c:out value = '${pn.id}' />&nid=${nid}&q1=${q1}"><FONT 
                  class=g12><c:out value="${nname}"/></FONT></A></c:if>
                  
                  
                  </TD>
              </TR>
              </TABLE>
        
        </td>
      </tr>
      <tr>
        <td>
         <form name="form1" method="post" action="mainAction.do?action=toFacilityPage">
         <input name="q1" type="hidden" value="${q1}" />
         <input name="pnid" type="hidden" value="${pnid}" />
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

       
        <table width="93%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr align="center" class="text14wb">
                   <td height="30" width="10%" bgcolor="#FFFFFF">序号</td>
                      <td width="20%"bgcolor="#FFFFFF">服务设施名字</td>
                      <td width="15%"bgcolor="#FFFFFF">门市价</td>
                      <td width="15%"bgcolor="#FFFFFF">优惠价</td>
                      <td width="15%"bgcolor="#FFFFFF">可容纳人数</td>
                      <td width="15%"bgcolor="#FFFFFF">可预定数量</td>
                       <td width="20%"bgcolor="#FFFFFF">详情（点击放大）</td>
                  </tr>
                  <c:set var='num' value='0'/> 
<c:forEach var="n"  items="${list}"  >   
 <c:set var='num' value="${num+1}"/> 
                  <tr align="center" bgcolor="#FFFFFF" class="text12">
                  <td height="20px"><c:out value="${num}"/></td>
                      <td><c:out value="${n.name}" ></c:out></td>
                        <td><c:out value="${n.price}" ></c:out></td>
                         <td><c:out value="${n.salePrice}" ></c:out></td>
                          <td><c:out value="${n.size}" ></c:out></td>
                           <td><c:out value="${n.num}" ></c:out></td>
                           <td bgcolor="#FFFFFF"><a  href="upload/facility/${n.bimage}" class="highslide" onclick="return hs.expand(this)"><img src="upload/facility/${n.simage}"  /></a></td>
                      
                  </tr>
     </c:forEach> 
                </table>
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
    
    </form>
        </td>
      </tr>
     
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
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



<Table cellSpacing=0 cellPadding=0 width="770" border=0  align="center"> 
      
       
        <tr >
          <td height=10 bgcolor="#e6e6e6">&nbsp;</td>
        </tr> </Table>

<%@ include file="bottom.jsp"%>

</body>

</HTML>