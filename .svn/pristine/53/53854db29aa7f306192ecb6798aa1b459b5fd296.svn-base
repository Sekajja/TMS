<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<c:url var="adminUrl" value="/admin"/>
<c:url var="postLoginUrl" value="/welcome"/>
<c:url var="newProjectUrl" value="reviewerproject"/>
<c:url var="loginUrl" value="login"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300|Roboto:300|Ubuntu:300' rel='stylesheet' type='text/css'>
<!-- JQuery UI Magic -->
<link rel="stylesheet" href="<c:url value='/resources/js/jquery-ui-1.11.4/jquery-ui.css'/>">
  <script src="<c:url value='/resources/js/jquery-1.11.2.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-ui-1.11.4/jquery-ui.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reviewer.css'/>" />


</head>
<body background="<c:url value='/resources/images/background/dotCircleRed.png'/>">

<header>
		<div>
			<div style="float:left;width:70px;overflow:hidden;">
				<img src="<c:url value='/resources/images/logo/Calendar.png'/>" alt="logo" height="70" width="70"/>
			</div>

		
			<nav style="float:left;padding-left: 70px;">
				<ul>
					<li><label>Manager</label>
						
					</li>  
					<li><label>Project</label>

						<ul>
						<li><a href="#" id="create-project">Create New Project</a></li>
						<li><a href="reviewerproject">Open Project</a></li>
						<li><a href="#">End Project</a></li>
						</ul>						
						
						
					</li> 
					<li><label>Tasks</label>
						<div class="navdiv"></div>
					</li> 
					<li><label>Work Plan</label>
						<div class="navdiv"></div>
					</li>
				</ul>
				</nav>
			
			

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
    
 
    
    <script type="text/javascript">
	$(function(){
		   dialog = $( "#dialog-form" ).dialog({
	        autoOpen: false,
	        height: 300,
	        width: 400,
	        modal: true
	        
		   });
	$( "#create-project" ).on( "click", function() {
		        dialog.dialog( "open" );
	});
		
	});
	
</script>

	<div id="dialog-form" title="Create New Project" >
		<form method="post" action="${newProjectUrl}">
			<table align = "center">
				<tr>
				<td><label>Project Name</label></td><td><input type="text" name="ProjectName"/></td>
				</tr>
				<tr>
				<td><td/><td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><td/>
				<tr/>
				<tr>			
				<td></td><td><input type="submit" value="Create New Project"></td>
				</tr>
				
				
			</table>
		</form>
	</div>
    
    
    
    
    
    
    
    
    
    
    
    
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

