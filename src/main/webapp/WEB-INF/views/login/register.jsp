<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />

</head>
<body background="<c:url value='/resources/images/background/hexgrid.png'/>">
<div class="box">

	<div class="inner-box">
	
	<h1>Task Management System</h1>
	
	</div>

</div>
<font  style="color:#333333;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;">


<%-- <form:form modelAttribute="projectUser" action="register.do"> --%>
<form:form modelAttribute="projectUser" method="POST">
	<table align="center">
		<tr><td>First name:</td><td> <form:input path = "First_Name" placeholder="Enter First Name"/></td></tr>
		<form:errors path="First_Name" element="div"/>
		
		<tr><td>Middle names:</td><td> <form:input path = "Middle_Name" placeholder="Enter Middle Names" /></td></tr>
		<form:errors path="Middle_Name" element="div"/>
		
		<tr><td>Last Name:</td><td><form:input path = "Last_Name" placeholder="Enter Last Name"/></td></tr>
		<form:errors path="Last_Name" element="div"/>
		
		<tr><td>Username:</td><td> <form:input path = "User_Name" placeholder="Enter User Name" /></td></tr>
		<form:errors path="User_Name" element="div"/>
		
		<tr><td>Password:</td><td><form:password path = "Password" placeholder="Enter password"/></td></tr>
		<form:errors path="Password" element="div"/>
		
		<tr><td>Confirm password:</td><td><form:password path = "confirmpassword" placeholder="Confirm password"/></td></tr>
		<form:errors path="confirmpassword" element="div"/>
		
		<tr><td>Date of Birth:</td><td><form:input path = "DOB" placeholder="DD/MM/YY"/></td></tr>
		<form:errors path="DOB" element="div"/>
		
		<tr><td></td><td><input type="submit" value="register"/></td></tr>	
	</table>
</form:form>

	
</font>
</body>
</html>