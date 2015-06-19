<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:url var="adminUrl" value="/admin" />
<c:url var="newProjectUrl" value="reviewerproject" />
<c:url var="processProjectUrl" value="reviewerproject.json" />
<c:url var="loginUrl" value="login" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Project</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300|Roboto:300|Ubuntu:300' rel='stylesheet' type='text/css'>
</head>

<body>

	

	<table class="formbox" width="100%" style="margin-top: 100px;">
		<tr>
			<td>
				<div id="projects_header">
					<div style="float: left; width: 50%;">

						<table align="left">
							<tr>
								<td>
									<div style="float: left; width: 70px; overflow: hidden;">
										<img
											src="<c:url value='/resources/images/logo/Calendar.png'/>"
											alt="logo" height="70" width="70" />
									</div>
								</td>
								<td valign="middle"><label class="header_intro">Projects</label>
								</td>
							</tr>
						</table>
					</div>


					<!-- Projects Table -->

					<div style="float: left; width: 50%;"></div>

					<table align="right">
						<tr>
							<td valign="bottom"><a href="#" id="NewProjectDialogOpener"
								style="padding-right: 15px; cursor: pointer;">+ Create New
									Project</a></td>
							<td><a href="#" id="projectlinks"
								style="padding-right: 15px; cursor: pointer;">+ Edit Project</a>
							</td>
							<td><a href="#" id="projectlinks"
								style="padding-right: 15px; cursor: pointer;">+ End Project</a>
							</td>
						</tr>

					</table>

				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table id="project_table_header" width="100%">
					<tr>
						<th>Projects</th>
						<th>Components</th>
						<th>Tasks</th>
						<th>Completed</th>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	

<c:if test="${NoProjectsMessage}">
 	<div class="msgNoProject" align="center">
 		You do not have any projects Currently, Create a new project to get started.
	</div>
</c:if>

<script type="text/javascript">

		$(function() {
			
			$("#NewProjectDialog").dialog({
				autoOpen : false,
				height: 420,
			    width: 650,
				modal : true,
				dialogClass: 'modal-dialog'
			});
			
			$("#NewProjectDialogOpener").on("click", function() {
				$("#NewProjectDialog").dialog("open");
			});
			
			  $(function() {
				    $( "#startdatepicker" ).datepicker({
				    	
				    	dateFormat: "dd/mm/yy",
				    	showAnim:"slide",
				    	
				    	
				    	onSelect: function(selected) {
				    	      $("#enddatepicker").datepicker("option","minDate", selected)
				    	       }
				    });
				  });
			  $(function() {
				  
				    $( "#enddatepicker" ).datepicker({
				    	

				    	dateFormat: "dd/mm/yy",
				    	showAnim:"slide",
				    	onSelect: function(selected) {
				    	$("#startdatepicker").datepicker("option","maxDate", selected)
				    	
				    	}
				    });
			 });
		});
		
		
				
		function doAjaxSubmit() {
			var $form = $("#projectForm");
			
				$.ajax({
				type:"post",
				data:$form.serialize(),				
				url:'reviewerproject.json',				 
				success: function(response){
					if(response.status == "SUCCESS"){
						$("#NewProjectDialog").dialog("close");	
												
					}else{
						$("#NewProjectDialog").dialog("open");
					}
					
				},
				
				error: function(e){
					e.preventDefault();
				}
			});
			
		}
	</script>
	<div id="NewProjectDialog" title="Create New Project">
	
	<form:form  modelAttribute="project" method="post" action="${processProjectUrl}" id="projectForm">

	
	<table align="center" style="padding-top:15px;padding-left:15px;">
		<tr><td><label>Project Name</label></td><td> <form:input path ="ProjectName"/></td></tr>
		<tr><td></td><td><form:errors path ="ProjectName" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Acronym</label></td><td> <form:input path ="ProjectAcronym" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
		<tr><td></td><td><form:errors path ="ProjectAcronym" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="50" path="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><form:errors path="ProjectDescription" cssClass="error"/></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy" />
						<form:errors path ="StartDate" cssClass="error"/>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<form:input path ="EndDate" class="timepiece" id="enddatepicker" placeholder="dd/mm/yyyy"/>
						<form:errors path ="EndDate" cssClass="error"/>
						</div>
		</div>
		
		
		</td></tr>
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="Create New Project" class="submitNewProject" onclick="doAjaxSubmit()"/></td></tr>	
	</table>

</form:form>
	
	
	
	
	
		
			<%-- <form method="post" action="${newProjectUrl}">
				<table align="center" style="padding-top:15px;padding-left:15px;">
					<tr>
						<td><label>Project Name</label></td>
						<td><input type="text" name="ProjectName"/></td>
					</tr>
					<tr>
						<td><label>Project Acronym</label></td>
						<td><input type="text" name="ProjectAcronym" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
					</tr>
					<tr>
						<td><label>Project Description</label></td>
						<!-- <td><input type="text" name="ProjectDescription" maxlength="3" class="acronym"/></td> -->
						<td> <textarea rows="4" cols="50" name="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"></textarea> </td>
					</tr>
					<tr>
						<td><label>Duration</label></td>
						<td>
						<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<input type="text" name="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy"/>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<input type="text" name="StartDate" class="timepiece" id="enddatepicker" placeholder="dd/mm/yyyy"/>
						</div>
						</div>
						
						
						</td>
					</tr>
					<tr>
					<td>
						<td/>
						<td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<td/>
					<tr/>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="Create New Project" class="submitNewProject"></td>
					</tr>
				</table>
			</form> --%>
			
<%-- <form:form  modelAttribute="project" method="post" action="${newProjectUrl}" >

	
	<table align="center" style="padding-top:15px;padding-left:15px;">
		<tr><td><label>Project Name</label></td><td> <form:input path ="ProjectName"/></td></tr>
		<tr><td></td><td><form:errors path ="ProjectName" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Acronym</label></td><td> <form:input path ="ProjectAcronym" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
		<tr><td></td><td><form:errors path ="ProjectAcronym" cssClass="error"/></td></tr>
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="50" path="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><form:errors path="ProjectDescription" cssClass="error"/></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy" />
						<form:errors path ="StartDate" cssClass="error"/>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<form:input path ="EndDate" class="timepiece" id="enddatepicker" placeholder="dd/mm/yyyy"/>
						<form:errors path ="EndDate" cssClass="error"/>
						</div>
		</div>
		
		
		</td></tr>
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="Create New Project" class="submitNewProject"/></td></tr>	
	</table>

</form:form> --%>
		
	</div>



</body>
</html>