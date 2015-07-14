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
<c:url var="editProjectUrl" value="reviewerproject/edit">
	
</c:url>
<c:url var="deleteProjectUrl" value="reviewerproject/delete">
	
</c:url>
<c:url var="processProjectUrl" value="reviewerproject.json" />
<c:url var="loginUrl" value="login"/>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Project</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300|Roboto:300|Ubuntu:300' rel='stylesheet' type='text/css'>
</head>

<body>

	
	<div id="alertmsg" class="successmsg" align="center" style="margin-top: 70px;">
	</div>

	<table class="formbox" width="100%" style="margin-top: 10px;">
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
											alt="logo" height="70" width="70"/>
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
						<th width="25%" style="padding:5px;">Time Left</th>
						<th width="35%">Brief</th>
					</tr>
				</thead>
				<tbody id="projectBody">
					  <c:set var="start" scope="session" value="${0}"/>
				      <c:forEach items="${TimeRemaining}" var="projects">
				       <tr id="${projects.key.id}">					       	   
				        <td class="ac"><a href="#" id='projectlinks'> ${projects.key.projectAcronym} </a> </td>
						
				        <td class="pn"> ${projects.key.projectName}</td>
				        <td class="pe"><input type="hidden" value="${projects.key.endDate}" class="end"/><input type="hidden" value="${projects.key.startDate}" class="start"/><input type="hidden" name="projectID" value="${projects.key.id}"/><div class="txt"></div></td>
				        
				        <td class="pd" style="text-align: left; padding-left: 10px; padding-right: 10px;">
				        <c:if test="${projects.key.projectDescription != ''}">
				  		<font color="#FF8E8E">#</font>
				        </c:if>
				         <i class="ds">${projects.key.projectDescription}</i>				        
				        </td>
				        
				        <td><a href="<c:url value='${editProjectUrl}/${projects.key.id}'/>">
				        
				        	<img src="<c:url value='/resources/images/icons/edit_icon.png'/>" class="EditProjectDialogOpener" alt="logo" height="19px" width="19px"/>
				        
				        </a></td>
            			<td>
            				<form:form  action="${deleteProjectUrl}/${projects.key.id}" method="post" modelAttribute="project" id="deleteform">
            				<input type="button" value="" class="deleteSubmit">
            				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>            					
            				</form:form>
            				
            			
            			</td>
				      </tr>
				      <c:set var="start" scope="session" value="${start+=1}"/>
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
				      "<td style='color: #333333;font-size: 90%;-webkit-font-smoothing: antialiased;'><label style='font-weight: bold;'>End Date: </label>" + EndDate.val() + "</td>" +
				      "<td>" + ProjectDescription.val() + "</td>" +
				      "</tr>");
			
		}
		
		
		
			
		$(function() {
			
			
			var timer;
			
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
			
			
			$("#EditProjectDialog").dialog({
				autoOpen : false,
				height: 440,
			    width: 650,
				modal : true,
				dialogClass: 'modal-dialog'
			});
			
			$(".EditProjectDialogOpener").on("click", function() {
				event.preventDefault();
				$( "#ProjectNameError2").html("");
				$( "#ProjectAcronymError2").html("");
				$( "#ProjectDescriptionError2").html("");
				$( "#StartDateError2").html("");
				$( "#EndDateError2").html("");
				
				$("#EditProjectDialog").dialog("open");
				
				
				var row =$(this).closest('tr').attr('id');
				
				$("#projectid").val(row);
				
				var projectName = $("#"+row).find(".pn").html();
				$( "#ProjectName2" ).val(projectName.trim());
				var projetAcronym = $("#"+row).find(".ac #projectlinks").html();
				$( "#ProjectAcronym2" ).val(projetAcronym.trim());
				
				var desc = $("#"+row).find(".pd .ds").html();
				$( "#ProjectDescription2" ).val(desc.trim());
				
				var startDate = $("#"+row).find(".pe .start").val().substring(0,10);
			    var startDateformat = startDate.replace(/-/g, "/");
			    var startsplit = startDateformat.split('/');
			   	var newStartFormat = ""+startsplit[2]+"/"+startsplit[1]+"/"+startsplit[0];
			    
				$( "#startdatepicker2" ).val(newStartFormat);
				
				var endDate = $("#"+row).find(".pe .end").val().substring(0,10);
			    var endDateformat = endDate.replace(/-/g, "/");
			    var endsplit = endDateformat.split('/');
			   	var newendFormat = ""+endsplit[2]+"/"+endsplit[1]+"/"+endsplit[0];
				$('#enddatepicker2').val(newendFormat);
			
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
				    $( "#startdatepicker2" ).datepicker({
				    	
				    	dateFormat: "dd/mm/yy",
				    	showAnim:"slide",
				    	
				    	
				    	onSelect: function(selected) {
				    	      $("#enddatepicker2").datepicker("option","minDate", selected)
				    	       }
				    });
				  });
			  $(function() {
				  
				    $( "#enddatepicker2" ).datepicker({
				    	

				    	dateFormat: "dd/mm/yy",
				    	showAnim:"slide",
				    	onSelect: function(selected) {
				    	$("#startdatepicker2").datepicker("option","maxDate", selected)
				    	
				    	}
				    });
			 });
			  
			  
			  	function deleteProject(row){
			  		
			  		$("#"+row).find(".deleteSubmit")
			  		.on( "submit", function( event ) {
				    	var id = $(this).attr("id");
				    	
				    	event.preventDefault();	  
				    	
				        var request = $.ajax({ 
				        	url:"reviewerproject/delete/"+id,
				        	type:"POST",
				        	data:$form.serialize(),	
				        	success: function(){
				        		
				        		
				        		$(this).hide();
				        	}
				        	});
								
						});  
			  		
			  		
			  		
			  	}
			  
			  
				function addEditedProject(row){
					
					var $form = $("#projectForm2");
					var ProjectName = $( "#ProjectName2" );
					var ProjectAcronym = $( "#ProjectAcronym2" );
					var ProjectDescription = $( "#ProjectDescription2" );
					var StartDate = $( "#startdatepicker2" );
					var EndDate = $('#enddatepicker2');
					 
					 $("#"+row).find(".ac #projectlinks").html(""+ProjectAcronym.val());
					 $("#"+row).find(".pn").html(""+ProjectName.val());			 
					 $("#"+row).find(".pd .ds").html(""+ProjectDescription.val());
					 
					 
					var splitdate = EndDate.val().split("/");
					var reversedate = ""+splitdate[2]+"-"+splitdate[1]+"-"+splitdate[0];
					
					var omega = new Date();
					var alpha = new Date("1980/01/01");
					var ide = omega-alpha;
					
					
					$("#"+row).find(".pe").html("");
					$("#"+row).find(".pe").html("<div id='"+ide+"' style='font-size: 90%;'> </div>");
					
					editTime(reversedate,$("#"+row),ide)
					
					function editTime(end,rowelement,id){
							
						var today=new Date();							  
					    
					    var endDate = end.substring(0,10);
					    var endDateformat = endDate.replace(/-/g, "/");
					   
					    var completion = new Date(endDateformat);
								   
					    
					    	 var durationleft = new Date((completion - today));
					    	 
					    	 var secondsleft = durationleft/1000;
					    	 
					    	 var days = parseInt(secondsleft/86400); 
					    	 secondsleft = secondsleft % 86400;
					    	 
					    	 var hours = parseInt(secondsleft / 3600);
					    	 secondsleft = secondsleft % 3600;
					    	   
					    	 var minutes = parseInt(secondsleft / 60);
					    	 seconds = parseInt(secondsleft % 60);
					    	 
					    	 minutes = checkTime(minutes);
					    	 seconds = checkTime(seconds);
					    	 
					    	 if(secondsleft < 0){
					    		 
					    		 rowelement.find(".pe #"+id).html("<b>Out of time</b>");
					    		 
					    	 }else{
					    		
					    		 rowelement.find(".pe #"+id).html(""+days+"<b>:days</b> &nbsp"+hours+"<b>:hrs</b> &nbsp"+minutes+"<b>:min</b> &nbsp"+seconds+"<b>:s</b>");  
					    	 }
					    	 
					    	 var timer2 = setTimeout(function(){editTime(end,rowelement,id)},500);
					}
					
					$("#alertmsg").addClass("successmsgbg").text("Project Successfully Updated");

					setTimeout(function(){
						$("#alertmsg").addClass("successmsgbgvanish");
				    },2000);
					
					$("#alertmsg").removeClass("successmsgbgvanish");
				}
			  
			  
				
				
			  $('#projectBody tr ').each(function(){		
					   
					  showTime($(this).find(" td .end").val(), $(this));
					  
					  var id = $(this).attr("id");
					  var row = $(this);
					  var $form = $(this).find("#deleteform");
					  
					  
					  
					  
					  
					  
					  $(this).find(".deleteSubmit")
				  		.on( "click", function( event ) {
				  			event.preventDefault();		
				  			$("#dialog-confirm").html(" Are you sure you want this project removed?");
				  			$(function() {
							    $( "#dialog-confirm" ).dialog({
							      resizable: false,
							      height:200,
							      width:400,
							      modal: true,
							    
							      buttons: {
							        "Remove Project": function() {
							        	
							        	var request = $.ajax({ 
								        	
								        	url:"reviewerproject/delete/"+id,
								        	type:"POST",
								        	data:$form.serialize(),	
								        	success: function(){
								        		row.hide();
								        		$("#alertmsg").addClass("successmsgbg").text("Project Successfully Removed");

												setTimeout(function(){
													$("#alertmsg").addClass("successmsgbgvanish");
											    },2000);
												
												$("#alertmsg").removeClass("successmsgbgvanish");
								        	}
								        	});
							        	
							        	
							          $( this ).dialog( "close" );
							        },
							        Cancel: function() {
							          $( this ).dialog( "close" );
							        }
							      }
							    });
							  });
				  			
							   
							 
				  			
				  		
				  			
				  			
				  			
				  			
					    
									
							});  
					  
	  
			  }
					  
			  );
			 
	
			   function showTime(end, element) {
				    var today=new Date();	
				  
				    
				    var endDate = end.substring(0,10);
				    var endDateformat = endDate.replace(/-/g, "/");
				   
				    var completion = new Date(endDateformat);
							   
				    
				    	 var durationleft = new Date((completion - today));
				    	 
				    	 var secondsleft = durationleft/1000;
				    	 
				    	 var days = parseInt(secondsleft/86400); 
				    	 secondsleft = secondsleft % 86400;
				    	 
				    	 var hours = parseInt(secondsleft / 3600);
				    	 secondsleft = secondsleft % 3600;
				    	   
				    	 var minutes = parseInt(secondsleft / 60);
				    	 seconds = parseInt(secondsleft % 60);
				    	 
				    	 minutes = checkTime(minutes);
				    	 seconds = checkTime(seconds);
				    	 
				    	 if(secondsleft < 0){
				    		 
				    		 element.find("td .txt").html("<b>Out of time</b>");
				    		 
				    	 }else{
				    		
					    	element.find("td .txt").html(""+days+"<b>:days</b> &nbsp"+hours+"<b>:hrs</b> &nbsp"+minutes+"<b>:min</b> &nbsp"+seconds+"<b>:s</b>");  
				    	 }
				    	 
				    	
				    	 timer = setTimeout(function(){showTime(end, element)},500);
						 
						
	    
				 } 
			   
			  
			  
			function checkTime(i) {
						    if (i<10) {i = "0" + i};  // add zero in front of numbers < 10
						    return i;
						}
			
			  
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
									//showTime(response.result.endDate);
									 $.ajax({
										url:"reviewerproject",
							        	type:"POST",
							        	data:$form.serialize(),	
								         success: function () {
								        	 
								          }    
									});    	  

									$("#NewProjectDialog").dialog("close");
									
									$("#alertmsg").addClass("successmsgbg").html("Project Successfully Created");
					

									setTimeout(function(){
										$("#alertmsg").addClass("successmsgbgvanish");
								    },2000);
									
									$("#alertmsg").removeClass("successmsgbgvanish");

									
									
									
																		
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
			
			///////////////////////////////////////////Edit/////////////////////////////////////////////////
			$(function() {
				  
			  	var $form = $("#projectForm2");
				var ProjectName = $( "#ProjectName2" );
				var ProjectAcronym = $( "#ProjectAcronym2" );
				var ProjectDescription = $( "#ProjectDescription2" );
				var StartDate = $( "#startdatepicker2" );
				var EndDate = $('#enddatepicker2');
			  
			    $( "#EditProjectDialog" ).on( "submit", function( event ) {
			    	/*event.preventDefault();*/
			    	event.preventDefault();	    
			    	var id = $("#projectid").val();
			        var request = $.ajax({ 
			        	url:"reviewerproject.json",
			        	type:"POST",
			        	data:$form.serialize(),	
			        	success: function(response){
							if(response.status == "SUCCESS"){
								
								addEditedProject(id)
								 $.ajax({
										url:"reviewerproject/edit/"+id,
							        	type:"POST",
							        	data:$form.serialize(),	
								         success: function () {
								        	 
								          }    
									});    	
								$("#EditProjectDialog").dialog("close");
																	
							} else{
								
								$("#alertmsg").html("");
								$( "#ProjectNameError2").html("");
								$( "#ProjectAcronymError2").html("");
								$( "#ProjectDescriptionError2").html("");
								$( "#StartDateError2").html("");
								$( "#EndDateError2").html("");
								
								
									for(i =0 ; i < response.result.length ; i++){
										
						                if(response.result[i].field == "projectName"){
						                	$( "#ProjectNameError2").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                }
						                if(response.result[i].field == "projectAcronym"){
						                	$( "#ProjectAcronymError2").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "projectDescription"){
						                	$( "#ProjectDescriptionError2").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "startDate"){
						                	$( "#StartDateError2").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
						                } 
						                if(response.result[i].field == "endDate"){
						                	$( "#EndDateError2").html("<div class='error' style='float:left'>"+response.result[i].defaultMessage+"</div>");
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
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="60" path="ProjectDescription" id="ProjectDescription" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><div id="ProjectDescriptionError"></div></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker" placeholder="dd/mm/yyyy"/>
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
	
</div>	





	
<!-- //////////////////////////////////////Project Edit/////////////////////////////////////////////////////////// -->



<div id="EditProjectDialog" title="Adjust Project Details">
	
	<form:form  modelAttribute="project" method="post" action="${editProjectUrl}" id="projectForm2">
	
	
	<table align="center" style="padding-top:15px;padding-left:15px;">
		<tr><td><label>Project Name</label></td><td> <form:input path ="ProjectName" id="ProjectName2"/>		
		<tr><td></td><td><div id="ProjectNameError2"></div></td></tr>
				
		<tr><td><label>Project Acronym</label></td><td> <form:input path ="ProjectAcronym" id="ProjectAcronym2" maxlength="5" class="acronym" style="text-transform: uppercase;"/></td>
		<tr><td></td><td><div id="ProjectAcronymError2"></div></td></tr>
		
		<tr><td><label>Project Description</label></td><td><form:textarea  rows="4" cols="60" path="ProjectDescription" id="ProjectDescription2" style="width: 95%;color:#666666;margin-bottom:8px;padding:3px;" placeholder="  A brief description of your project (optional)"/></td>
		<tr><td></td><td><div id="ProjectDescriptionError2"></div></td></tr>
		
		<tr><td><label>Duration</label></td><td> 
		
		<div>
						<div style="width:50%;float:left;">
						<label>Start Date</label>
						<form:input path ="StartDate" class="timepiece" id="startdatepicker2" placeholder="dd/mm/yyyy"/>
						<div id="StartDateError2"></div>
						</div>
						<div style="width:50%;float:left;">
						<label>End Date</label>
						<form:input path ="EndDate" class="timepiece" id="enddatepicker2" placeholder="dd/mm/yyyy"/>
						<div id="EndDateError2"></div>
						</div>
		</div>
		
		
		</td></tr>
		<tr><td><br></td><td><input type="hidden" name="id" id="projectid"/></td></tr>
		<tr><td><br></td><td><input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/></td></tr>
		<tr><td></td><td align="right"><input type="submit" value="Adjust Project Details" class="submitNewProject"/></td></tr>	
	</table>

</form:form>
	
</div>	


<div id="dialog-confirm" title="Remove Project?"style="	font: 200 18px/28px 'Ubuntu',Arial,'libra sans',sans-serif,'HelveticaNeue-Light','HelveticaNeue','Roboto','Open Sans';
"></div>



		
	



</body>
</html>