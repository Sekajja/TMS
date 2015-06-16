package project.iics.tms.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.services.ProjectUserService;

@Controller
public class ProjectReviewerController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProjectUserService projectUserService;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/reviewer", method = RequestMethod.GET)
	public String home(Locale locale, Model model, ProjectUser projectUser) {
		
		logger.info("Project Reviewer! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		logger.info("Project Reviewer Accesed Task Management System  on {}", formattedDate);
		
		
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
	
			
			return "redirect:reviewerproject";
		}	
		
		return "projectReviewer/ProjectReviewer";
	}
	
	
}
