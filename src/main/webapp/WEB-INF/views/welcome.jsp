<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<c:url var="adminUrl" value="/admin" />
<c:url var="postLoginUrl" value="/welcome" />
<c:url var="logoutUrl" value="/login" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
</head>
<body background="<c:url value='/resources/images/background/hexgrid.png'/>">
<div class="box">

	<div class="inner-box">
	
	<h1>Task Management System</h1>
	
	</div>

</div>


<div class="box">

	<div class="inner-box">
	
	<h1>
	
	<security:authorize access="isAnonymous()">
	Hi, Guest <a href="${loginUrl}">Log in</a>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
	Hi, <security:authentication property="principal.username" />.
	<a href="${logoutUrl}">Log out</a>
	</security:authorize>
	
	<security:authorize access="hasAuthority('ROLE_System_Administrator')">
	Apparently you are a System administrator!!
	</security:authorize>
	
	<security:authorize access="hasAuthority('ROLE_Project_Delegate')">
	You are a Delegate!!
	</security:authorize>
	
	<a href="${adminUrl}">Admin</a>
	
	</h1>
	
</div>

</div>


</body>
</html>