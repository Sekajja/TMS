package project.iics.tms.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.services.ProjectService;
import project.iics.tms.services.ProjectUserService;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	ProjectService projectService; 
	@Autowired
	ProjectUserService projectUserService;
	
	
	@RequestMapping(value = "reviewerproject", method = RequestMethod.GET)
	public String getProjectPage(Project project, ProjectUser projectUser, Model model){
		
		logger.info("Welcome to the Projects Page");
		
		Boolean NoProjectsMessage = false;
		
		//The Session
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				if (principal instanceof UserDetails) {
					  String username = ((UserDetails)principal).getUsername();
					  logger.info("New Project to be Created For:{}", username);
				
					  projectUser = projectUserService.getProjectUserByUserName(username).get(0);
				} 
				else {
					  String username = principal.toString();
					  logger.info("[Else Case]New Project Created For:{}", username);
				}
				
				
				
				if(projectUserService.getProjectUserProjects(projectUser).isEmpty()){
					//NoProjectsMessage = "You do not have any projects Currently, Create a new project to get started.";
					NoProjectsMessage = true;
				}	
				
				model.addAttribute("NoProjectsMessage", NoProjectsMessage);

		return "projectReviewer/ProjectReviewerProject";
	}
	
	
	@RequestMapping(value = "reviewerproject", method = RequestMethod.POST)
	public String processFormData(@Valid Project project, BindingResult result, Model model){

				if (result.hasErrors()) {
					logger.info("Errors creating new Project");
					
					return "projectReviewer/ProjectReviewer";
				}
				
		//The creation hierarchy	
		projectService.createNewProject(project);
		
		//The Session
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  logger.info("New Project Created For:{}", username);
		} else {
		  String username = principal.toString();
		  logger.info("[Else Case]New Project Created For:{}", username);
		}
		
		model.addAttribute("project", project);

		logger.info("Processing New Project Form Entry:{}", project);	
		
		return "redirect:reviewerproject";
	}

	
}
