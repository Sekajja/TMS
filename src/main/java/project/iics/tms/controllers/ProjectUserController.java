package project.iics.tms.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.services.ProjectUserService;
import project.iics.tms.services.UserRoleService;

@Controller
public class ProjectUserController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
private String welcomeView;
@Autowired
ProjectUserService projectUserService; 

@Autowired
UserRoleService userRoleService;


	/*
	 * Welcome View Setters and Getters 
	 * */

	public String getWelcomeView() {
		return welcomeView;
	}
	
	public void setWelcomeView(String welcomeView) {
		this.welcomeView = welcomeView;
	}

	/**
	 * Simply selects the Registration view to render by returning its name.
	 */
	
	
	
	
	
	
	
	/*
	 * 
	 * Registration Redirect
	 * */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerProjectUser(ProjectUser projectUser){
		logger.info("Registering new Project User");
		logger.info("You should now see the Registration Page");
		
		
		return "login/register";
	}
	
	
	/*
	 * 
	 * Processes Registration form Data
	 * */

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processFormData(@Valid ProjectUser projectUser,BindingResult result, Model model){

				if (result.hasErrors()) {
					logger.info("Errors found Processing Project User Form");
					
					return "login/register";
				}
				
		//The creation hierarchy	
		projectUserService.createProtectedProjectUser(projectUser, projectUser.getPassword(),projectUser.getConfirmpassword());
		projectUserService.assignRoleToProjectUser(projectUser, userRoleService.getUserRole("ROLE_Project_Delegate"));
		//The creation
		
		model.addAttribute("projectUser", projectUser);

		logger.info("Processing Project User Form Entry:{}", projectUser);	
			
		return "redirect:welcome";
	}
	
	
		
	/*
	 * 
	 * Redirects to Admin Page
	 * */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showAdmin(Model model){
		logger.info("Welcome System Administrator");		
		logger.info("You should now see the Admin Page");
		
		return "admin";
	}
	
	
	/*
	 * 
	 * Redirects to 403 Page
	 * */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String show403(Model model){
		logger.info("Welcome System Administrator");		
		logger.info("You should now see the Admin Page");
		
		return "sorry";
	}
	
	
	
	
	
}
