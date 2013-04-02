<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="../style.css" rel="stylesheet" type="text/css" />
		<title>人员列表</title>
	</head>
	<f:view>
		<body>
			<h2>JSF1.2+EJB3的一个CRUD实例</h2>
				<h3>--人员列表</h3>
			<h:form>
				<h:commandButton action="insert" value="新增人员" type="submit" />
				
				<h:dataTable value="#{personFace.allPersons}" var="person" 
						styleClass="dt"
						headerClass="dt-head"
						rowClasses="dt-r1,dt-r2"
						cellpadding="4"
						border="1"
						binding="#{personFace.table}">
					<h:column>
						<f:facet name="header">
							<h:outputText value="序号" />
						</f:facet>   
     					<h:outputText value="#{personFace.table.rowIndex + 1}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="姓名" />
						</f:facet>  
						<h:outputText value="#{person.name}"/>
  					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="年龄" />
						</f:facet> 
						<h:outputText value="#{person.age}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="性别" />
						</f:facet>
						<h:outputText value="#{person.sex}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="生日" />
						</f:facet>
						<h:outputText value="#{person.birthday}">
							<f:convertDateTime pattern="yyyy-MM-dd EEE" timeZone="GMT+8"/>
						</h:outputText>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<h:outputText value="操作" />
						</f:facet>
						<h:panelGroup>
							<h:outputLink value="personUpdate.faces?personId=#{person.id}">
								<h:outputText value="编辑"/>
							</h:outputLink>
							<h:outputText value=" "/>
							<h:commandLink action="#{personFace.deleteAction}"
								onclick="if(!confirm('你确定删除?')){return false;}">
								<h:outputText value="删除"/>
								<f:param name="personId" value="#{person.id}"/>
							</h:commandLink>
						</h:panelGroup>
					</h:column>
				</h:dataTable>
			</h:form>
		</body>
	</f:view>
</html>