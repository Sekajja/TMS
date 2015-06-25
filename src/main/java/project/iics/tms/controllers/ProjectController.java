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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.iics.tms.domain.JsonResponse;
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
					  logger.info("List projects for:{}", username);
				
					  projectUser = projectUserService.getProjectUserByUserName(username).get(0);
				} 
				else {
					  String username = principal.toString();
					  logger.info("[Else Case]List projects for:{}", username);
					  projectUser = projectUserService.getProjectUserByUserName(username).get(0);
				}
				
				
				
				if(projectUserService.getProjectUserProjects(projectUser).isEmpty()){
					//NoProjectsMessage = "You do not have any projects Currently, Create a new project to get started.";
					NoProjectsMessage = true;
				}	
				
				model.addAttribute("reviewerprojects", projectUserService.getProjectUserProjects(projectUser));
				model.addAttribute("NoProjectsMessage", NoProjectsMessage);

		return "projectReviewer/ProjectReviewerProject";
	}
	
	@RequestMapping(value = "reviewerproject", method = RequestMethod.POST)
 	public String processFormData(@Valid Project project, BindingResult result, Model model, ProjectUser reviewer){

			if (result.hasErrors()) {
				logger.info("Errors creating new Project");
				
				
				return "redirect:reviewerproject";
			}
			else{
			
	//The creation hierarchy	
	projectService.createNewProject(project);
	model.addAttribute("project", project);
	
	//The Session
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username = "";
	if (principal instanceof UserDetails) {
	  username = ((UserDetails)principal).getUsername();
	  logger.info("New Project Created For:{}", username);
	} else {
	  username = principal.toString();
	  logger.info("[Else Case]New Project Created For logged user:{}", username);
	}
	
	
	reviewer = projectUserService.getProjectUserByUserName(username).get(0);
	
	logger.info("New Project Created For Project User:{}", reviewer.getFullName());
	
	String reviewerinfo = projectUserService.assignProjectToProjectUser(reviewer, project);
	logger.debug("Project User info:{}", reviewerinfo.toString());
	
	return "redirect:reviewerproject";
	
			}
	}
	
	@RequestMapping(value = "reviewerproject.json", method = RequestMethod.GET)
	public String getJsonPage(Project project, ProjectUser projectUser, Model model){
		
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
	
	
	@RequestMapping(value = "reviewerproject.json", method = RequestMethod.POST)
	public  @ResponseBody JsonResponse addProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model){
				
			JsonResponse res = new JsonResponse();
						//result.getErrorCount()
				if (result.hasErrors()) {
					
					logger.info("Errors creating new Project");
					res.setStatus("FAIL");
					res.setResult(result.getAllErrors());
					
				}
				else{
					//model.addAttribute("project", project);
					res.setStatus("SUCCESS");
					res.setResult(project);	
				}

				
		return res;
	}
	
	
	
	 
	 	
	 	
	 
}
