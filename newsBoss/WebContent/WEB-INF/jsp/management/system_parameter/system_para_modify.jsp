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
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />
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
              <td height="25" class="title14">　网站信息设定 &gt;&gt;</td>
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
        <td><form action="parameterAction.do?action=modifyInfo" method="post" ENCTYPE="multipart/form-data" name="form1" id="form1">
          <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">网站标题<input name="id" type="hidden" id="id" value="<c:out value='${parameter.id}'/>" /></td>
              <td bgcolor="#FFFFFF" class="text12"><input name="title" type="text" maxlength="255" class="form12" id="title" value="<c:out value='${parameter.title}'/>" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">网 址</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="website" maxlength="255" type="text" class="form12" id="website" value="<c:out value='${parameter.website}'/>" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">浮动框图片</td>
              <td bgcolor="#FFFFFF" class="text12">
                 <input type="file" name="fileField" class="form12" id="fileField" size="40"  onchange="javascript:PreviewImg(this);"/>

              <div id="modifyPic"><img src="upload/parameter/${parameter.floatsite}"  width = "160px" height = "120px" /></div>
              <div id="newPreview"></div>
              
                            </td>
              </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">版权信息</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="copyright" type="text" maxlength="255" class="form12" id="copyright" value="<c:out value='${parameter.copyright}'/>" size="80" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">站长信箱</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="email" type="text" maxlength="255" class="form12" id="email" value="<c:out value='${parameter.email}'/>" size="40" /></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">新闻审核</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="newscheck" type="checkbox" class="form12" id="newscheck" value="newscheck"
			<c:if test="${parameter.newscheck==1}">
              checked 
              </c:if>
              size="40" /> <span class="title14">新闻默认为已审核</span></td>
            </tr>
            <tr bgcolor="#FFFFFF">
              <td colspan="2" align="center" bgcolor="#84B969" class="text12w">已访问人数</td>
              <td bgcolor="#FFFFFF" class="text12"><input name="guestnumber" type="text" class="form12" id="guestnumber" value="<c:out value='${parameter.guestnumber}'/>" size="40" /></td>
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
