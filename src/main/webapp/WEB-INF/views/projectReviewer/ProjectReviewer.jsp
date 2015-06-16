<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
	
<c:url var="projectUrl" value="reviewerproject" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager</title>
</head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reviewer.css'/>" />
<body>
	
	<table class="formbox2" width="100%" style="margin-top:100px;">
	<tr><td>
	
	<div >
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/clipBoard.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Manage Tasks</div>
	</div>
	
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/compo2.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Manage Components</div>
	</div>
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/clipBoard.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Manage Team</div>
	</div>
	
	
	</div>
	
	</td></tr>
	<tr><td>
	
	<div>
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/clipBoard.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Manage Resources</div>
	</div>
	
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/clipBoard.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Collaboration</div>
	</div>
	
	<div style="float:left;width:33%;">	
	<div align="center">
	<img class="formbox" style="height:108px;width:75px;" src="<c:url value='/resources/images/delegate/clipBoard.png'/>" alt="TaskManager Logo"></img>
	</div>
	<div align="center" class="mainmenucomponents">Review</div>
	</div>
	
	
	</div>
	
	</td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	</table>
	
</body>
</html>