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
oFCKeditor.Height="300";
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
    ss.innerHTML = "<input type=\"file\" name=\"dd"+temp+"\"><a href=\"javascript:;\" onclick=\"ss"+temp+".removeNode(true)\"><font size='2'>删除</font></a>"; 
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
document.form1.NclassId.options[0]= new Option("==请选择==","-1");
for (i=0;i<onecount;i++)
{
if (subcat[i][2] == locationid)
{

document.form1.NclassId.options[document.form1.NclassId.length] = new Option(subcat[i][0], subcat[i][1]);

}
}

if(document.getElementById("special").value!="-2")
{
document.getElementById("hid1").style.display = "none";
}
if(document.getElementById("special").value=="-2")
{
document.getElementById("hid1").style.display = "";
}
}

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
  document.all.small.options[0] = new Option("==请选择==",""); //给第一个值 
  for (i=0; i<subcat1.length; i++) 
  { 
 if (subcat1[i][0] == locationid) //[0] [1] 第一列 第二列 
    {
     document.all.small.options[document.all.small.length] = new Option(subcat1[i][1], subcat1[i][2]);
    } //建立option 
  } 
}

//--3级联动完成
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
              <td height="25" class="title14">　新闻信息修改 &gt;&gt;</td>
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
        
    <form id="form1" name="form1" action="newsAction.do?action=modifyNews&id=<c:out value='${mes.id}'/>" method="post" enctype="multipart/form-data" onsubmit="return affice()">
 <table width="90%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
	  <tr><td width="100px" align="center" bgcolor="#84B969" class="text12w">一级菜单</td>
	       <td  bgcolor="#FFFFFF">    <select   name="special" id="special" class="form12" onChange=changelocation(document.form1.special.options[document.form1.special.selectedIndex].value) size=1>
                             <OPTION selected value="-10">==请选择==</OPTION>
                                <c:forEach items="${mainList}" var="n2">
                                <option value="<c:out value='${n2.id}'/>" <c:if test="${n2.id==mes.boNavigationByNewsBig.id}"><c:out value="selected" /></c:if>>
                                <c:out value="${n2.name}"></c:out>
                                </option>
                               </c:forEach>
                                <option   value="-2" <c:if test="${mes.boNavigationByNewsBig.id==null||mes.boNavigationByNewsBig.id==''}"> <c:out value="selected" /> </c:if>>专题报道</option>
                              </select></td></tr>
          
          <tr ><td align="center" bgcolor="#84B969" class="text12w">二级菜单</td>
	       <td  bgcolor="#FFFFFF" >    

                               <SELECT name="NclassId" id="NclassId" class="form12" onchange="changeselect1(this.value);">
                               
                               <OPTION selected value="-10">==请选择==</OPTION>
                               <c:if test="${mes.boNavigationByNewsBig==null}">
                               <c:forEach var="lmFir" items="${special}"><option value="${lmFir.id}" <c:if test="${smallid==lmFir.id}">selected="selected" </c:if>> ${lmFir.name}</option></c:forEach>
                               </c:if>
                               <c:if test="${mes.boNavigationByNewsBig!=null}">
                               <option value="${smallid}" selected="selected" > ${smallname}</option>
                               </c:if>
                             </SELECT> 
                            
                             </td></tr>
                             
                             
                             	  <tr id="hid1" 
                             	  <c:if test="${mes.specialSmall==null}"> style="display:none"</c:if>    >
	    <td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>专题小类</td>
	    <td bgcolor="#FFFFFF"><select name="small" id="small"  class="form12">
        <OPTION  value="-10">==请选择==</OPTION>
        <OPTION selected value="${mes.specialSmall.id}">${mes.specialSmall.name}</OPTION></td>
	    </tr>	 
	   	  
	   	  <tr>
	    <td align="center" bgcolor="#84B969" class="text12w"><font color="#FF0000">*</font>&nbsp;大标题</td>
	      <td width="650"  bgcolor="#FFFFFF" class="text12w">
	      <input type="text" class="form12"  name="title" maxlength="64" size="40" value="<c:out value='${mes.newsName}'/>"/>
	       
	        <input name="nameset" type="checkbox" id="nameset" <c:if test="${mes.newsNameSet=='bigup'}"> checked="true" </c:if> value="bigup"/>
	       
	        <font color=red >小标题在大标题上方</font></td>
	  </tr>
	  <tr>
	    <td align="center" bgcolor="#84B969" class="text12w">小标题</td>
	    <td  bgcolor="#FFFFFF">
	    <input type="text" maxlength="64" class="form12"  name="title2" size="40" value="<c:out value='${mes.newsName2}'/>"/></td>
	    </tr>
	   
	   <tr><td align="center" bgcolor="#84B969" class="text12w"  >新闻作者</td>
	      <td  bgcolor="#FFFFFF" >
	      <input type="text" class="form12" size="40"  maxlength="32"  name="author" value="<c:out value='${mes.newsAuthor}'/>"/></td>
	  </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w"  >新闻来源</td>
	       <td  bgcolor="#FFFFFF" >
	       <input type="text" class="form12" size="40" maxlength="255"   name="source" value="<c:out value='${mes.newsSource}'/>"/></td>
	   </tr>
	              <tr><td align="center" bgcolor="#84B969" class="text12w" >新闻类型</td>
	    <td  bgcolor="#FFFFFF"  >
	    <c:if test="${mes.newsTop=='1'}"><label><input type="checkbox" name="top" value="1" checked/><font size="3" color="#FF0000">头条新闻</font></label></c:if>
	    <c:if test="${mes.newsTop=='0'}"><label><input type="checkbox" name="top" value="1"/><font size="3" color="#FF0000">头条新闻</font></label></c:if>
	    <c:if test="${mes.newsPicture=='1'}"><label><input type="checkbox" name="picture" value="1" checked/><font size="3" color="#FF0000">图片新闻</font></label></c:if>
	    <c:if test="${mes.newsPicture=='0'}"><label><input type="checkbox" name="picture" value="1"/><font size="3" color="#FF0000">图片新闻</font></label></c:if>
       <c:if test="${mes.en=='1'}"><label><input type="checkbox" name="en" value="1" checked/><font size="3" color="#FF0000">英文新闻</font></label></c:if>
	    <c:if test="${mes.en=='0'}"><label><input type="checkbox" name="en" value="1"/><font size="3" color="#FF0000">英文新闻</font></label></c:if>
	    </td>
           </tr>
	   <tr><td align="center" bgcolor="#84B969" class="text12w" valign="top">新闻内容</td>
           <td  bgcolor="#FFFFFF" ><textarea id="MyTextarea"  name="MyTextarea"><c:out value='${mes.newsContent}'/></textarea></td>
           </tr>
            <tr><td align="center" bgcolor="#84B969" class="text12w">发布时间</td>
	       <td  bgcolor="#FFFFFF"><input type="text" class="form12" size="40"  readonly="readonly"  name="time" value="<fmt:formatDate type="both" value='${mes.newsTime}'/>"  /> <%=new util.Util().showDateSel("form1.time")%></td>
	    </tr>

      <tr><td align="center" bgcolor="#84B969" class="text12w">附件内容</td>
	   <td  bgcolor="#FFFFFF">
       <c:if test="${mes.newsEnclo==null||mes.newsEnclo==''}"><font size="3" color="#FF0000">没有附件！</font></c:if>
        <c:if test="${mes.newsEnclo!=null&&mes.newsEnclo!=''}">
	    <c:forEach items="${enclo}" var="name">
          <input type="checkbox" value="<c:out value='${name}'/>" name="check" checked />
             ${name}
          </c:forEach>
          <font color="#FF0000" size="2">(选择要保留的附件)</font>
        </c:if>
	   </td>
       </tr>
       
       
      </table>
 <div id="left" >
    <table width="790" align="center" cellpadding="0" cellspacing="0"id="enclosure" name="table1">
      <tr>
        <td width="150"><a href="javascript:add(1);"><img border="0" src="image/botton/botton_tjfj.gif" /></a></td>
          <td align="left"><input name="" type="image" value="提交" src="image/botton/release.jpg" /> <input name="" type="image" value="重置" src="image/botton/redo.jpg" /><a href="javascript:jszs()"><img src="image/botton/botton_jszs.gif" border="0" /></a></td>
     </tr>
    </table>
</div>
  </form>
            
    </table></td>
  </tr>
</table>



</body>
</html>
