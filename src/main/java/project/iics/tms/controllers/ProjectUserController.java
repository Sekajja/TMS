package project.iics.tms.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.services.ProjectUserService;

@Controller
public class ProjectUserController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
private static String projectUserName = "";
private String welcomeView;
@Autowired
ProjectUserService projectUserService; 
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
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {

		/*
		 * Some logging info to keep track of changes
		 * */
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		
		logger.info("ProjectUserController Accessed - {}", formattedDate);
		logger.info("You should now see the Login Page");
		
		/*
		 * Controller method logic
		 * */
		
				
		return "login/login";
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String processLoginData(Model model,@RequestParam("username") String username, @RequestParam("password") String password, ProjectUser projectUser){
		
		logger.info("Accessing Project User: {}", username);	
		
		if(projectUserService.isRegisteredProjectUser(username, password)){
		projectUser = projectUserService.getRegisteredUserByLogin(username, password);
		projectUserName = projectUser.getFullName();
		
			return "redirect:welcome";
			
		}
		
	
			return "redirect:login";
	}
	
	
	
	
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
	 * Redirects to Welcome Page
	 * */
	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String showWelcome(Model model){
		logger.info("Welcome the Project User");		
		
		model.addAttribute("projectUser");
		model.addAttribute("projectUserName",projectUserName);
		
		logger.info("You should now see the Welcome Page");
		
		return "welcome";
	}
	
	/*
	 * 
	 * Processes Registration form Data
	 * */
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String processFormData(@ModelAttribute ProjectUser projectUser,Model model){
		logger.info("Processing Project User Form Entry:{}", projectUser);	
		
		projectUserService.createNewProjectUser(projectUser);
		projectUserName = projectUser.getFullName();
	
			return "redirect:welcome";
	}
	
	
	
	
}
