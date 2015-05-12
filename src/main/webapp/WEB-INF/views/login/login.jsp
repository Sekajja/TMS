<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<c:url var="homeUrl" value="/" />
<c:url var="postLoginUrl" value="/j_spring_security_check" />
<c:url var="loginUrl" value="../tms/login" />
<c:url var="logoutUrl" value="/login" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
	
</head>
<body background="<c:url value='/resources/images/background/hexgrid.png'/>">

<div class="box">

	<div class="inner-box">
	
	<h1>Task Management System</h1>
	
	</div>

</div>

<div align="center">
<div align="center" style="border:1px solid #333333; width:30%; padding:10px">


<form  action="${postLoginUrl}" method="post">
<font  style="color:#333333;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;">
<table align="center">

<tr><td>Username:</td><td> <input type="text" name = "j_username" placeholder="Enter username"/></td></tr>
<tr><td>Password:</td><td><input type="password"  name = "j_password" placeholder="Enter password"/></td></tr>
<tr><td></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>

<tr><td></td><td><input type="submit" value="login"/></td></tr>

<tr><td></td><td>
<font  style="color:#333333;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;font-size:80%;">
New to TMS? <a href="register">SignUp</a>   
</font>
</td></tr>

<tr><td></td><td>
<c:if test="${param.failed == true}">
<div>Your login attempt failed. Please try again.</div>
</c:if>
</td></tr>

</table>
</font>
</form>


</div>
</div>
</body>
</html>