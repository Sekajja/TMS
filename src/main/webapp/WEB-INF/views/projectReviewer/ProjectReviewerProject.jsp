<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<c:url var="adminUrl" value="/admin" />
<c:url var="newProjectUrl" value="reviewerproject" />
<c:url var="loginUrl" value="login" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Project</title>

</head>

<body>

	<script type="text/javascript">
		$(function() {
			dialog = $("#dialog-form2").dialog({
				autoOpen : false,
				height : 300,
				width : 400,
				modal : true,
				dialogClass: 'modal-dialog'
			}).dialog("widget").find(".ui-dialog-title").hide();
			
			$("#create-project2").on("click", function() {
				dialog.dialog("open");
			});

		});
	</script>

	<div id="dialog-form2" title="Create New Project">
		
			<form method="post" action="${newProjectUrl}">
				<table align="center">
					<tr>
						<td><label>Project Name</label></td>
						<td><input type="text" name="ProjectName" /></td>
					</tr>
					<tr>
						<td><label>Project Acronym</label></td>
						<td><input type="text" name="ProjectAcronym" /></td>
					</tr>
					<tr>
						<td><label>Start Date</label></td>
						<td><input type="date" name="ProjectAcronym" /></td>
					</tr>
					<tr>
						<td>
						<td />
						<td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<td />
					<tr />
					<tr>
						<td></td>
						<td><input type="submit" value="Create New Project"></td>
					</tr>


				</table>
			</form>
		
	</div>

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
							<td valign="bottom"><a href="#" id="create-project2"
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





</body>
</html>