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

@Controller
public class ProjectDelegateController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/delegate", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Project Delegate! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		logger.info("Project Delegate Accesed Task Management System  on {}", formattedDate);
		
		return "projectDelegate/ProjectDelegate";
	}
	
	
}
