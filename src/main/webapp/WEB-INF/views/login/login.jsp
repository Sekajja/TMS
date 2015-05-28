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
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/decorator_register.css'/>" />
	
</head>
<body background="<c:url value='/resources/images/background/dotCircleRed.png'/>">

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
	</header>

<article style="padding-top: 80px;">

<form  action="${postLoginUrl}" method="post">
<font  style="color:#333333;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;">

	
	<table align="center" class="formbox" style="padding: 20px;">
	
		<tr><td>Username:</td><td> <input type="text" name = "j_username" placeholder="Enter username"/></td></tr>
		<tr><td>Password:</td><td><input type="password"  name = "j_password" placeholder="Enter password"/></td></tr>
		<tr><td></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		
		<tr><td></td><td align="center"><input type="submit" value="login" class="rectround"/></td></tr>
		<tr><td></td><td><input type="hidden"/></td></tr>
		<tr><td></td><td >
		<font  style="color:#333333;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;font-size:80%;">
		New to TMS? <a href="register">SignUp</a>   
		</font>
		</td></tr>

	
	</table>
	<div align="center">
		<c:if test="${param.failed == true}">
			<div class="error" align="center">Your login attempt failed. Please try again.</div>
		</c:if>
	</div>

</font>
</form>
</article>	
<footer>
	
	<%-- <div class="welcomefooter">

	<table align="center" style="padding-top: 30px;padding-bottom: 30px;">
	
	<tr>
	<td align="left">
	<h4>Get Started</h4>
	<ul >
	<li>Project Delegate</li>
	<li>Project Reviewer</li>
	<li>Administrator</li>
	</ul>
	</td>
	
	<td>
	<h4>About Us</h4>
	 Cisco Networking Academy,<br> a Cisco Corporate Social Responsibility program, <br>is an IT skills and career building program available to learning institutions and individuals worldwide. 
	</td>
	
	<td>
	<img alt="logo" src="<c:url value='/resources/images/background/iicslogoonly2.png'/>">
	<br>Copyright &copy; 2015. IICS Project, All rights reserved.
	</td>
	
	</tr>
	<tr>
	<td>
	<a href="#" class="welcomefooterlinks">About</a>|
	<a href="#" class="welcomefooterlinks">Help</a>
	
	</td>
	<td></td>
	<td>
	<a href="#" class="welcomefooterlinks">Terms Of Use</a>|
	<a href="#" class="welcomefooterlinks">Privacy Policy</a>
	</td>
	</tr>
	</table>
</div>	 --%>
	<div class="loginlastfooter">Copyright &copy; 2015. IICS Project, All rights reserved.</div>
</footer>																				
</body>
</html>