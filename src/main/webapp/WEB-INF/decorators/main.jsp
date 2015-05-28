<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<c:url var="adminUrl" value="/admin"/>
<c:url var="postLoginUrl" value="/welcome"/>
<c:url var="loginUrl" value="login" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/welcome.css'/>" />
</head>
<body>

<header>
		<div>
			<div style="float:left;width:70px;overflow:hidden;">
				<img src="<c:url value='/resources/images/logo/Calendar.png'/>" alt="logo" height="70" width="70"/>
			</div>

			<div style="float:left;overflow:hidden;padding-left: 70px;">
				<nav style="line-height: 70px">
					<label>Plan</label> . 
					<label>Project</label> . 
					<label>Prosper</label> 
				</nav>
			</div>

		</div>
		
		
	<table align= "right"  style="padding-top: 10px;">	
		<tr>
			
			<security:authorize access="isAnonymous()">
			<td align="right" class="hitext" valign="middle">
			Hi, Guest.&nbsp;&nbsp;  <a href="${loginUrl}" class="getstartedlinks" style="padding-top:5px;	padding-bottom:5px;padding-left:10px;padding-right:10px;">Log in</a>
			</td>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">
			<td align="right" class="hitext" valign="middle">
			Hi, <security:authentication property="principal.username" />.&nbsp;&nbsp;
			</td>
			<td align="right" valign="middle">
			<c:url var="logoutUrl" value="/logout"/>
			<form action="${logoutUrl}" method="post">
		  	<input type="submit" value="Log out" class="logoutbutton"/>
		  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			</td>
			</security:authorize>
			
		</tr>
	</table>
	</header>
	
    <nav></nav>
    
 
    <decorator:body />
    
    
<footer class="loginlastfooter">
Copyright &copy; 2015. IICS Project, All rights reserved.
</footer>	

</body>
</html>