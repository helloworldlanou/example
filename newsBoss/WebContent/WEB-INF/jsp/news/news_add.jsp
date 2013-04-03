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
window.onload = function()
{
var oFCKeditor = new FCKeditor( 'MyTextarea' ) ;
oFCKeditor.Config["CustomConfigurationsPath"] = "<%out.print(path+"/");%>js/myConfig.js"  ;
oFCKeditor.BasePath = "<%out.print(path+"/");%>fckeditor/" ;
oFCKeditor.ToolbarSet ="news";
oFCKeditor.Height="250";
oFCKeditor.ReplaceTextarea() ;
}

var temp = 0; 
function add(num)
{ 
  var ss = null; 
  for(var i = 0;i < num; i++)
  { 
    ss = document.createElement("div"); 
    ss.id = "ss"+temp; 
    ss.innerHTML = "<input type=\"file\" class=\"form12\"  name=\"dd"+temp+"\"><a href=\"javascript:;\" onclick=\"ss"+temp+".removeNode(true)\"><img src=\"image/botton/delete_s.jpg\" border=\"0\" /></a>"; 
    document.form1.insertAdjacentElement("beforeEnd",ss); 
    temp++; 
   } 
}

function affice(){
	if(document.form1.special.value=="-10"){
		alert("一级菜单不能为空！");
		document.form1.special.focus();
		return false;
	}
	if(document.form1.NclassId.value=="-10"){
		alert("二级菜单不能为空！");
		document.form1.NclassId.focus();
		return false;
	}
	if(document.form1.special.value=="-2"&&document.form1.small.value=="-1"){
	
		alert("专题小类不能为空！");
		document.form1.small.focus();
		return false;
	}
	
	
	if(document.form1.title.value==""){
		alert("标题不能为空！");
		document.form1.title.focus();
		return false;
	}


	
	if(document.form1.author.value==""){
		alert("新闻作者不能为空！");
		document.form1.author.focus();
		return false;
	}

	
	return true;
}

var subcat = new Array();
var a=${num}
<c:forEach items="${rootList}" var="e" begin="0" end="${trLSize}" step="1" varStatus="x"> 
      subcat[<c:out value="${x.index}"/>] = new Array("<c:out value='${e.name}'/>","<c:out value='${e.id}'/>","<c:out value='${e.parentId}'/>");        
</c:forEach>
var tem = ${trLSize};
<c:forEach items="${special}" var="e"  step="1" varStatus="x"> 
 subcat[<c:out value="${x.index}"/>+tem] = new Array("<c:out value='${e.name}'/>","<c:out value='${e.id}'/>","-2");        
</c:forEach>

var onecount=0;

onecount=${trLSize}+${specialsize};
//第三级联动代码
var subcat1 = new Array();
//二级的parantid,二级的名字,二级的id
<c:set value="0" var="i" />
<c:forEach var="lmSec" items="${sl}">
  subcat1[${i}]=new Array("${lmSec.parentid}","${lmSec.name}","${lmSec.id}")
  <c:set value="${i+1}" var="i" />
</c:forEach>
function changeselect1(locationid) 
{ 
  document.all.small.length = 0; //初始化下拉列表 清空下拉数据 
  document.all.small.options[0] = new Option("==请选择==","-1"); //给第一个值 
  for (i=0; i<subcat1.length; i++) 
  { 
 if (subcat1[i][0] == locationid) //[0] [1] 第一列 第二列 
    {
     document.all.small.options[document.all.small.length] = new Option(subcat1[i][1], subcat1[i][2]);
    } //建立option 
  } 
}

//--3级联动完成
function changelocation(locationid)
{
if(document.getElementById("special").value=="-2")
{
	document.getElementById("hid2").style.display="";

}
else
{
	document.getElementById("hid2").style.display="none";
}

document.form1.NclassId.length = 0;
var locationid = locationid;
var i;
  document.all.NclassId.options[0] = new Option("==请选择==","-1"); //给第一个值 
for (i=0;i<onecount;i++)
{
if (subcat[i][2] == locationid)
{
document.form1.NclassId.options[document.form1.NclassId.length] = new Option(subcat[i][0], subcat[i][1]);

}
}
}

function ch()
{
var author1 = document.getElementById("author1");
if(author1.checked)
{
document.getElementById("author").value = "admin";
}
if(!author1.checked)
{
document.getElementById("author").value = '${person.name}';
}
}
</script>
<script type="text/javascript">
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
} 

function jszs()
{

	var str = getEditorTextContents("MyTextarea");
	alert("包括标点符号，您的文章一共有"+str.length+"个字");
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
              <td height="25" class="title14">　新闻添加 &gt;&gt;</td>
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
        
    <form id="form1" name="form1" action="newsAction.do?action=AddNews" method="post" enctype="multipart/form-data" onsubmit="return affice()">
 <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
	  <tr><td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>一级菜单</td>
<td bgcolor="#FFFFFF">    <select   name="special" id="special" class="form12" onChange=changelocation(document.form1.special.options[document.form1.special.selectedIndex].value) size=1>
                                <option   value="-10" >==请选择==</option>
                                <c:forEach items="${mainList}" var="n2">
                                <option value="<c:out value='${n2.id}'/>" <c:if test="${n2.name==checked.name}"> selected="selected"</c:if>>
                                <c:out value="${n2.name}"></c:out>
                                </option>
                               </c:forEach>
                                <option   value="-2" >专题报道</option>
                              </select></td>
          </tr>
            
	  <tr id="hid" >
	    <td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>二级菜单</td>
	    <td bgcolor="#FFFFFF"> <SELECT name="NclassId" id="NclassId" onchange="changeselect1(this.value);" class="form12">
                      <OPTION selected value="-10">==请选择==</OPTION><c:forEach var="lmFir" items="${special}"><option value="${lmFir.id}"> ${lmFir.name}</option></c:forEach>
                             </SELECT> </td>
	    </tr>
	  <tr id="hid2" style="display:none">
	    <td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>专题小类</td>
	    <td bgcolor="#FFFFFF"><select name="small" id="small"  class="form12"><OPTION selected value="-1">==请选择==</OPTION></select></td>
	    </tr>
         
         
                           
	  <tr>
	    <td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>&nbsp;大标题</td>
	      <td width="650"  bgcolor="#FFFFFF" class="text12w"><input type="text" maxlength="64" class="form12"  name="title" size="40" />
	        <input name="nameset" type="checkbox" id="nameset" value="bigup"  />
	        <font color=red >小标题在大标题上方</font></td>
	  </tr>
	  <tr>
	    <td align="center" bgcolor="#84B969" class="text12w">小标题</td>
	    <td  bgcolor="#FFFFFF"><input type="text" maxlength="64" class="form12"  name="title2" size="40" /></td>
	    </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w">新闻作者</td>
	     <td  bgcolor="#FFFFFF" class="text12w"><input type="text" class="form12" maxlength="32" size="40" value="admin"   name="author" id="author"/><input id="author1" name="author1" type="checkbox" value="" checked onclick="ch()" /> <font color=red >匿名</font></td>
	  </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w">新闻来源</td>
	       <td  bgcolor="#FFFFFF"><input type="text" class="form12" maxlength="255" size="40"   name="source"/></td>
	   </tr>
       
        <tr>
      <td align="center" bgcolor="#84B969" class="text12w" width="100" >头条新闻</td>
	    <td  bgcolor="#FFFFFF" width="650"><label><input type="checkbox" name="top" value="1"/><span class="title14">头条新闻</span></label><label><input type="checkbox" name="picture" value="1"/><span class="title14">图片新闻</span></label><label><input type="checkbox" name="en" value="1"/><span class="title14">英文新闻</span></label></td>
        </tr>
       
	   <tr><td align="center" bgcolor="#84B969" class="text12w" valign="top">新闻内容</td>
           <td  bgcolor="#FFFFFF"><textarea id="MyTextarea"  name="MyTextarea"></textarea></td>
           </tr>
        <tr><td align="center" bgcolor="#84B969" class="text12w">发布时间</td>
	       <td  bgcolor="#FFFFFF"><input type="text" class="form12" size="40"  readonly="readonly"  name="time" value="<fmt:formatDate type="both" value='<%=new java.util.Date()%>'/>"  /> <%=new util.Util().showDateSel("form1.time")%></td>
	    </tr>
      </table>
 <div id="left" >
    <table width="790" align="center" cellpadding="0" cellspacing="0"id="enclosure" name="table1">
      <tr>
        <td width="150"><a href="javascript:add(1);"><img border="0" src="image/botton/botton_tjfj.gif" /></a></td>
        <td align="left"><input name="test1" type="image" value="提交" src="image/botton/release.jpg" /> <input name="test2" type="image" value="重置" src="image/botton/redo.jpg" /><a href="javascript:jszs()"><img src="image/botton/botton_jszs.gif" border="0" /></a></td>
     </tr>
    </table>
</div>
  </form>
            
    </table></td>
  </tr>
</table>

<script language="javascript">


</script>



</body>
</html>
