<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<c:url var="contactUrl" value="contacts"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/contacts.css'/>" />
</head>

<body>

<script type="text/javascript">

   // str - the value of the current textbox control,
   // textbox - the actual textbox object, (so that the value can be set)
   // loc - a string of multiple locations to place the specified character,
   // delim - the character (delimiter) that you want to use a separator. 
function phoneMask(str,textbox){ 
	
if(str.length == 10 && str[0]!="" ){
	
		var code = str.substring(0,3);
		var extra = str.charAt(3);
		var firstThree = str.substring(4,7);
		var lastThree = str.substring(7,10);
		str	= "("+code+")"+"-"+extra+"-"+firstThree+" "+lastThree;
		
	}

	textbox.value = str
	
	if(str[0]=="(" &&(str[2]!="7" || str[2]!="4") ){
		
		textbox.style.color = "#D02A2A";
		
	}
	if(str[0]=="0" && str.length < 10){
		
		textbox.style.color = "#D02A2A";
		
	}
	
	if(str[0]=="(" &&(str[2]=="7" || (str[2]=="4" && str[3]=="1")) ){
		
		textbox.style.color = "black";
	}
	
	if(str[0]=="(" && str.length < 15){
		
		textbox.style.color = "#D02A2A";
		
	}
	
	
}

function faxMask(str,textbox){ 
	
	if(str.length == 10 && str[0]!="" ){
		
		var code = str.substring(0,3);
		var extra = str.charAt(3);
		var firstThree = str.substring(4,7);
		var lastThree = str.substring(7,str.length);
		str	= "("+code+")"+"-"+extra+"-"+firstThree+" "+lastThree;
	}

	textbox.value = str
	}  
   
</script>


<section class="contactsection">

			<div>
				<h1>Contact Details</h1>

			</div>
<div>
<form:form  modelAttribute="contactDetails" method="post" action="${contactUrl}">

	
	<table align="center" class="contactform" style="background-color:#ffffff;">
		<tr><td>Telephone number:</td><td> <form:input path = "TelephoneNumber" placeholder="Enter Telephone number" onKeyUp="phoneMask(this.value,this);" onBlur="phoneMask(this.value,this);"/></td></tr>
		<tr><td></td><td><form:errors path="TelephoneNumber" cssClass="error"/></td></tr>
		
		<tr><td>Mobilephone number:</td><td> <form:input path = "MobilePhoneNumber" placeholder="Mobilephone number" onKeyUp="phoneMask(this.value,this);" onBlur="phoneMask(this.value,this);"/></td>
		<tr><td></td><td><form:errors path="MobilePhoneNumber" cssClass="error"/></td></tr>
		
		<tr><td>Fax number:</td><td><form:input path = "faxNumber" placeholder="Enter fax number" onKeyUp="faxMask(this.value,this);" onBlur="faxMask(this.value,this);"/></td>
		<tr><td></td><td><form:errors path="faxNumber" cssClass="error"/></td></tr>
		
		<tr><td>Email address:</td><td> <form:input path = "EmailAddress" placeholder="Enter Email address" /></td>
		<tr><td></td><td><form:errors path="EmailAddress" cssClass="error"/></td></tr>
		
		<tr><td>Physical address:</td><td><form:select path = "PhysicalAddress" placeholder="Enter Physical address" cssClass="inputkind" items="${list}" /></td>
		<tr><td></td><td><form:errors path="PhysicalAddress" cssClass="error" /></td></tr> 
		
		<tr><td>Box Number:</td><td><form:input path = "BoxNumber" placeholder="Enter Box Number"/></td>
		<tr><td></td><td><form:errors path="BoxNumber" cssClass="error"/></td></tr>
		
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="center"><input type="submit" value="submit" class="rectround"/></td></tr>	
	</table>

</form:form>
</div>
</section>
</body>
</html>