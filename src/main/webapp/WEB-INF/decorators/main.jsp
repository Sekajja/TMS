<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<c:url var="adminUrl" value="/admin"/>
<c:url var="postLoginUrl" value="/welcome"/>
<c:url var="logintUrl" value="/login" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/decorator_main.css'/>" />
</head>
<body>

	<header>
	<table width="100%">
		<tr>
			<td align="left"><img src="<c:url value='/resources/images/logo/wierd6.png'/>" height="30px" width="30px"  alt="logo" /></td>
			<td align="center">Task Management System</td>
			
			
			<security:authorize access="isAnonymous()">
			<td align="right" class="pageheader">
			Hi, Guest <a href="${loginUrl}">Log in</a>
			</td>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">
			<td align="right">
			Hi, <security:authentication property="principal.username" />.
			</td>
			<td align="right">
			<c:url var="logoutUrl" value="/logout"/>
			<form action="${logoutUrl}" method="post">
		  	<input type="submit" value="Log out" />
		  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			</td>
			</security:authorize>
	
			
			
		</tr>
	</table>
	</header>
	
    <nav></nav>
    
    <hr />
    <decorator:body />
    <hr />
    
    <footer>
    <div align="center" class="pageheader"> Copyright &copy; 2015. IICS Project, All rights reserved. </div>
    
    </footer>

</body>
</html>