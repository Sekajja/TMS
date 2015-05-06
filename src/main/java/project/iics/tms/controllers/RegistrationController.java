package project.iics.tms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.services.ProjectUserService;

@Controller
public class RegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	ProjectUserService projectUserService; 	
	
	
	/*WebRequest - Generic interface for a web request. Mainly intended for generic web request interceptors, 
	  giving them access to general request metadata, 
	  not for actual handling of the request.
	  */
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		    ProjectUser user = new ProjectUser();
		    logger.info("");
		    model.addAttribute("user", user);
		     return "login/register";
		}
		
		
		
	@RequestMapping(value = "/user/register.do", method = RequestMethod.POST)
	public String registerUserAccount(
				  @ModelAttribute("user") @Validated ProjectUser projectUser,
				  BindingResult result, WebRequest request, Errors errors, Model model) {
		
		 if(result.hasErrors()) {
	            return "login/register";
	        }
		 projectUserService.createNewProjectUser(projectUser);
		
		/*if(registeredUserAccount(projectUser, result)){			
			
		}else{			
			
		}*/
		
		return null;
				   
	}
	
	private Boolean registeredUserAccount(ProjectUser projectUser) {

		if(projectUserService.getProjectUsers().contains(projectUser)){
			
			return true;
		}
		
		return false;
	}
		
		
}


