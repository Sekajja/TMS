<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<c:url var="register_userUrl" value="register"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/decorator_register.css'/>" />

</head>
<body>
<!-- modelAttribute="projectUser"  -->
<form:form  modelAttribute="projectUser" method="post" action="${register_userUrl}" >

	
	<table align="center" class="formbox">
		<tr><td>First name:</td><td> <form:input path = "First_Name" placeholder="Enter First Name"/></td></tr>
		<tr><td></td><td><form:errors path="First_Name" cssClass="error"/></td></tr>
		
		<tr><td>Middle names:</td><td> <form:input path = "Middle_Name" placeholder="Middle Names(optional)"/></td>
		<tr><td></td><td><form:errors path="Middle_Name" cssClass="error"/></td></tr>
		
		<tr><td>Last Name:</td><td><form:input path = "Last_Name" placeholder="Enter Last Name"/></td>
		<tr><td></td><td><form:errors path="Last_Name" cssClass="error"/></td></tr>
		
		<tr><td>Username:</td><td> <form:input path = "User_Name" placeholder="Enter User Name" /></td>
		<tr><td></td><td><form:errors path="User_Name" cssClass="error"/></td></tr>
		
		<tr><td>Password:</td><td><form:password path = "Password" placeholder="Enter password" id="password"/></td>
		<tr><td></td><td><form:errors path="Password" cssClass="error" /></td></tr> 
		
		<tr><td>Confirm password:</td><td><form:password path = "Confirmpassword" placeholder="Confirm password"/></td>
		<tr><td></td><td><form:errors path="Confirmpassword" cssClass="error"/></td></tr>
		
		<tr><td>Date of Birth:</td><td><form:input path = "DOB" placeholder="dd/MM/yy"/></td>
		<tr><td></td><td><form:errors path="DOB" cssClass="error"/></td></tr>
		
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="center"><input type="submit" value="register" class="rectround"/></td></tr>	
	</table>
<%-- <div align="center" style="margin-top:15px;"><form:errors path="Password" cssClass="error" id="passwordVerbose" />
</div> --%>
</form:form>


</body>
</html>