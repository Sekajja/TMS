<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<c:url var="adminUrl" value="/admin" />
<c:url var="newProjectUrl" value="reviewerproject" />
<c:url var="loginUrl" value="login" />

<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Test Page  
</h1>

	<form:form  modelAttribute="project" method="post" action="${newProjectUrl}" >

	
	<table align="center" style="padding-top:15px;padding-left:15px;">
		<tr><td><label>Project Name</label></td><td> <form:input path ="ProjectName"/></td></tr>
		<tr><td></td><td><form:errors path ="ProjectName" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Acronym</label></td><td> <form:input path ="ProjectAcronym" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
		<tr><td></td><td><form:errors path ="ProjectAcronym" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="50" path="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><form:errors path="ProjectDescription" cssClass="error"/></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy" />
						<form:errors path ="StartDate" cssClass="error"/>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<form:input path ="EndDate" class="timepiece" id="enddatepicker" placeholder="dd/mm/yyyy"/>
						<form:errors path ="EndDate" cssClass="error"/>
						</div>
		</div>
		
		
		</td></tr>
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="Create New Project" class="submitNewProject"/></td></tr>	
	</table>

</form:form>




</body>
</html>
