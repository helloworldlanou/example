<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css">
#newPreview
{
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
}
</style>
<script type="text/javascript" language="javascript">
<!--
function PreviewImg(imgFile)
{
   
    //新的预览代码，支持 IE6、IE7。
    var newPreview = document.getElementById("newPreview");
    newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgFile.value;
    newPreview.style.width = "160px";
    newPreview.style.height = "120px";
	document.getElementById("modifyPic").style.display = "none";
}

-->
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
              <td height="25" class="title14">　添加设施类别 &gt;&gt;</td>
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
        <td><form action="addFacilityAction.do?action=modify&id=${n.id}" method="post" enctype="multipart/form-data" name="form1" id="form1">
          <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          
            <tr bgcolor="#FFFFFF">
              <td width="200px" align="center" bgcolor="#84B969" class="text12w">服务设施名称</td>
              <td width="81%" bgcolor="#FFFFFF" class="text12"><input name="name" type="text" class="form12" value="${n.name}" id="name"size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">服务设施英文名称</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="enname" type="text" class="form12" id="enname" value="${n.enname}" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">设施类别</td>
              <td bgcolor="#FFFFFF" class="text12">
              <select name="fid" id="fid" class="form12">
              <c:forEach items='${flist}' var='item'>
   				 <option value="<c:out value='${item.id}'/>" <c:if test="${item.id==n.boFacilityType.id}"> selected="selected" </c:if>><c:out value='${item.name}'/></option>	
			  </c:forEach>
              </select>              </td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">门市价</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="price" value="${n.price}" type="text" class="form12" id="name3"size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">优惠价</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="salePrice" value="${n.salePrice}" type="text" class="form12" id="name4"size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">可容纳人数</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="size" type="text" value="${n.size}"  class="form12" id="name5"size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">可预定设施数量</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="num" type="text" value="${n.num}"  class="form12" id="name6"size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">大图上传</td>
              <td bgcolor="#FFFFFF" class="text12"><label>
                <input type="file" name="fileField" class="form12" id="fileField"  onchange="javascript:PreviewImg(this);"/>
              </label>
              <div id="modifyPic"><img src="upload/facility/${n.bimage}"  width = "160px" height = "120px" /></div>
              <div id="newPreview"></div>              </td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td align="center" bgcolor="#84B969" class="text12w">描述</td>
              <td bgcolor="#FFFFFF" class="text12"><label>
                <textarea name="des" id="textarea" cols="45" rows="5">${n.des}</textarea>
              </label></td>
            </tr>
			   </table>
          <table width="80%" height="60"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="imageField" type="image" src=" image/botton/modify.jpg" width="102" height="29" border="0" />　　
                  <img src=" image/botton/redo.jpg" width="102" height="29" style="CURSOR: hand" onclick="form1.reset()" /></td>
              </tr>
            </table>
          <p>&nbsp;</p>
        </form>
          <p>&nbsp;</p></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
