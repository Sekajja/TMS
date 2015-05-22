<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/decorator_register.css'/>" />

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
	</header>

	<article style="padding-top: 75px;">

		<section class="spiralbg" >
			<div>
				<h1>Registration</h1>
			</div>
			<div>

				<div> <font  style="color:#808080;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased; font-size:16px;">
						
						<decorator:body/>
							
					  </font> 

				</div>

				<div></div>

				<div></div>

			</div>

		</section>

	</article>

	<footer class="pageheader">
		Copyright &copy; 2015. IICS Project, All rights reserved.
	</footer>
</body>
</html>