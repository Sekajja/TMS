<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<c:url var="adminUrl" value="/admin"/>
<c:url var="postLoginUrl" value="/welcome"/>
<c:url var="logintUrl" value="login"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/delegate.css'/>" />
</head>
<body background="<c:url value='/resources/images/background/dotCircleRed.png'/>">

<header>
		<div>
			<div style="float:left;width:70px;overflow:hidden;">
				<img src="<c:url value='/resources/images/logo/Calendar.png'/>" alt="logo" height="70" width="70"/>
			</div>

			<div style="float:left;overflow:hidden;padding-left: 70px;">
				<nav style="line-height: 70px">
					<label>Manager</label> . 
					<label>Projects</label> . 
					<label>Tasks</label> . 
					<label>Work Plan</label> 
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
			<td align="right">
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
	
  <table width="100%">
	  <tr>
		  <td width="20%">
		  <div style="margin-top:70px;" class="dash">
		  
		  <div class="dashheader"> DASH </div>
		  <div class="dashcomponents">Tasks</div>
		  <div class="dashcomponents">Components</div>
		  <div class="dashcomponents">Team</div>
		  <div class="dashcomponents">Dependencies</div>
		  <div class="dashcomponents">Collaboration</div>
		  <div class="dashcomponents">Resources</div>
		  <div class="dashcomponents">Obstacles</div>
		  <div class="dashcomponents" style="margin-bottom:20px">Review</div>
		  </div>
		  
		  </td>
		  <td width="80%"> <decorator:body /> </td>
	  </tr>
  </table>
    
 
    
    
    
<div class="delegatefooter">

	<table align="center" style="padding-top: 30px;padding-bottom: 30px;" width="100%">
	
	<tr>
	<td align="left" width="33%">
	<h4>Get Started</h4>
	<ul >
	<li>Project Delegate</li>
	<li>Project Reviewer</li>
	<li>Administrator</li>
	</ul>
	</td>
	
	<td align="center" width="33%">
	<h4>About Us</h4>
	 Cisco Networking Academy,<br> a Cisco Corporate Social Responsibility program, <br>is an IT skills and career building program available.
	</td>
	
	<td align="right" width="33%">
	<img alt="logo" src="<c:url value='/resources/images/background/iicslogoonly2.png'/>" style="margin-right:100px">
	<br>Copyright &copy; 2015. IICS Project, All rights reserved.
	</td>
	
	</tr>
	<tr>
	<td align="left">
	<a href="#" class="delegatefooterlinks">About</a>|
	<a href="#" class="delegatefooterlinks">Help</a>
	
	</td>
	<td></td>
	<td align="right">
	<a href="#" class="delegatefooterlinks">Terms Of Use</a>|
	<a href="#" class="delegatefooterlinks">Privacy Policy</a>
	</td>
	</tr>
	</table>
</div>
    
    
<footer class="loginlastfooter">

Copyright &copy; 2015. IICS Project, All rights reserved.
</footer>	

</body>
</html>

</body>
</html>