package project.iics.tms.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ProjectUser;

@Controller
public class ProjectUserController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
private String welcomeView;

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
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {

		/*
		 * Some logging info to keep track of changes
		 * */
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		
		logger.info("ProjectUserController Accessed - {}", formattedDate);
		logger.info("You should now see the Registration Page");
		
		/*
		 * Controller method logic
		 * */
		
				
		return "login/registration";
	}
	
	
	
	/*
	 * 
	 * Processes Registration form Data
	 * */
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String processFormData(ProjectUser projectUser){
		logger.info("Processing new Project User");
		
		
		logger.info("You should now see the Welcome Page");
		
		
		return "welcome";
	}
	
	
	
	
}
