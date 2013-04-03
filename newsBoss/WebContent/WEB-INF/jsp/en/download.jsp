<%@ page contentType="text/html;charset=gb2312" import="util.Download" %><%
Download dl = new Download();
String filepath = request.getAttribute("filepath").toString();
dl.download(pageContext,filepath);
%>