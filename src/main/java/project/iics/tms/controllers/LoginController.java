package project.iics.tms.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.services.ProjectUserService;
import project.iics.tms.services.UserRoleService;
@Controller
public class LoginController {

	@Autowired
	ProjectUserService projectUserService; 

	@Autowired
	UserRoleService userRoleService;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/*@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			   ModelMap model, Locale locale) {
		logger.debug("Received request to show login page");

	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		
		logger.info("ProjectUserController Accessed - {}", formattedDate);
		logger.info("You should now see the Login Page");

		
		return "login/login";
		}
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String processLoginData(Model model,@RequestParam("username") String username, @RequestParam("password") String password, ProjectUser projectUser){
		
		logger.info("Accessing Project User: {}", username);	
		
		if(projectUserService.isRegisteredProjectUser(username, password)){
		projectUser = projectUserService.getRegisteredUserByLogin(username, password);
		//String role = projectUserService.assignRoleToProjectUser(projectUser, userRoleService.getUserRole("Project Delegate"));
		//userRoleService.getUserRole("Project Delegate").ToString();
	

			return "redirect:welcome";
			
		}
	
	
			return "redirect:login";
	}
	
		*/
	
	/*
	 * 
	 * Redirects to Welcome Page
	 * */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcome(Model model){
		logger.info("Welcome the Project User");				
		logger.info("You should now see the Welcome Page");
		
		
		return "welcome";
	}
	
}
