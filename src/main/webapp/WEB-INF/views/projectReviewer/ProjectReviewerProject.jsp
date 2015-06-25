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
				<thead>
					<tr>
						<th width="10%"></th>
						<th width="30%">Project</th>
						<th width="20%">Duration</th>
						<th width="40%">Brief</th>
					</tr>
				</thead>
				<tbody id="projectBody">
				      <c:forEach items="${reviewerprojects}" var="projects">
				       <tr>
				        <td><a href="#" id='projectlinks'> ${projects.projectAcronym} </a></td>
				        <td> ${projects.projectName}</td>
				        <td> ${projects.endDate}</td>
				        <td> ${projects.projectDescription}</td>
				      </tr>
				      </c:forEach>
				     
				      
				</tbody>	
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
		function getRemainingTime(milliseconds){
			
			var days = Math.floor(milliseconds / 1000 / 60 / 60 / 24);
			milliseconds -= days * 1000 * 60 * 60 * 24;
			var hours = Math.floor(milliseconds / 1000 / 60 / 60);
			milliseconds -= hours * 1000 * 60 * 60;
			var minutes = Math.floor(milliseconds / 1000 / 60);
			milliseconds -= minutes * 1000 * 60;
			var seconds = Math.floor(milliseconds / 1000);
			milliseconds -= seconds * 1000;
			
			return ""+days+"d "+hours+"h "+minutes+"m "+seconds+"s ";
		}
		
		
		function addProject(){
			
			var $form = $("#projectForm");
			var ProjectName = $( "#ProjectName" );
			var ProjectAcronym = $( "#ProjectAcronym" );
			var ProjectDescription = $( "#ProjectDescription" );
			var StartDate = $( "#startdatepicker" );
			var EndDate = $('#enddatepicker');
			
			 $('#projectBody tr:last').after("<tr>" +
				      "<td><a href='#' id='projectlinks'>" + ProjectAcronym.val() + "</a></td>" +
				      "<td>" + ProjectName.val() + "</td>" +
				      "<td>" + EndDate.val() + "</td>" +
				      "<td>" + ProjectDescription.val() + "</td>" +
				      "</tr>");
			
		}
		
		
				
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
			  
			  
			  $(function() {
				  
				  	var $form = $("#projectForm");
					var ProjectName = $( "#ProjectName" );
					var ProjectAcronym = $( "#ProjectAcronym" );
					var ProjectDescription = $( "#ProjectDescription" );
					var StartDate = $( "#startdatepicker" );
					var EndDate = $('#enddatepicker');
				  
				    $( "#NewProjectDialog" ).on( "submit", function( event ) {
				    	/*event.preventDefault();*/
				    	event.preventDefault();			    	
				        var request = $.ajax({ 
				        	url:"reviewerproject.json",
				        	type:"POST",
				        	data:$form.serialize(),	
				        	success: function(response){
								if(response.status == "SUCCESS"){
									
									addProject();
									/* $( "#NewProjectDialog" ).unbind('submit').submit(); */
									
									 $.ajax({
										url:"reviewerproject",
							        	type:"POST",
							        	data:$form.serialize(),	
								         success: function () {
								            
								          }    
									});    	  
									
									
									$("#NewProjectDialog").dialog("close");
									
								} else{	
									$( "#ProjectNameError").html("");
									$( "#ProjectAcronymError").html("");
									$( "#ProjectDescriptionError").html("");
									$( "#StartDateError").html("");
									$( "#EndDateError").html("");
									
					                for(i =0 ; i < response.result.length ; i++){
						                if(response.result[i].field == "projectName"){
						                	$( "#ProjectNameError").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                }
						                if(response.result[i].field == "projectAcronym"){
						                	$( "#ProjectAcronymError").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "projectDescription"){
						                	$( "#ProjectDescriptionError").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "startDate"){
						                	$( "#StartDateError").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "endDate"){
						                	$( "#EndDateError").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						               
					                }
										
								}     
				       		},
				        });        
				        
				        
				        
						
				   });
			 });
		});
		
		
	</script>
	<div id="NewProjectDialog" title="Create New Project">
	
	<form:form  modelAttribute="project" method="post" action="${newProjectUrl}" id="projectForm">

	
	<table align="center" style="padding-top:15px;padding-left:15px;">
		<tr><td><label>Project Name</label></td><td> <form:input path ="ProjectName" id="ProjectName"/></td></tr>
		<tr><td></td><td><div id="ProjectNameError"></div></td></tr>
		
		<tr><td><label>Project Acronym</label></td><td> <form:input path ="ProjectAcronym" id="ProjectAcronym" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
		<tr><td></td><td><div id="ProjectAcronymError"></div></td></tr>
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="50" path="ProjectDescription" id="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><div id="ProjectDescriptionError"></div></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy" />
						<div id="StartDateError"></div>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<form:input path ="EndDate" class="timepiece" id="enddatepicker" placeholder="dd/mm/yyyy"/>
						<div id="EndDateError"></div>
						</div>
		</div>
		
		
		</td></tr>
				
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="Create New Project" class="submitNewProject"/></td></tr>	
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