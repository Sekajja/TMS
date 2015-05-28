package project.iics.tms.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.iics.tms.HomeController;
import project.iics.tms.domain.ContactDetails;

@Controller
public class ContactDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "contacts", method = RequestMethod.GET)
	public String registerProjectUser(ContactDetails contactDetails, Model model){
		logger.info("Registering new Contact Details");
		logger.info("You should now see the Contact Registration Page");
		
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("NONE", "--Choose Region--");
		country.put("CENTRAL", "Central");
		country.put("WEST", "Western");
		country.put("EAST", "Eastern");
		country.put("NORTH", "Northern");
		
		
		
		model.addAttribute("list", country);
		
		
		
		return "login/contacts";
	}
	
	
	/*
	 * 
	 * Processes Registration form Data
	 * */

	@RequestMapping(value = "contacts", method = RequestMethod.POST)
	public String processFormData(@Valid ContactDetails contactDetails,BindingResult result, Model model){

				if (result.hasErrors()) {
					logger.info("Errors found Processing Contact Details Form");
					
					Map<String,String> country = new LinkedHashMap<String,String>();
					country.put("NONE", "--Choose your Region--");
					country.put("CENTRAL", "Central");
					country.put("WEST", "Western");
					country.put("EAST", "Eastern");
					country.put("NORTH", "Northern");
					
					
					
					model.addAttribute("list", country);
					
					
					return "login/contacts";
				}
			model.addAttribute("contactDetails", contactDetails);
			
				
			return "redirect:welcome";
}
	
	//SimpleFormController
	protected Map<String, String> referenceData(HttpServletRequest request) throws Exception {
		Map<String, Map<String, String>> referenceData = new HashMap<String, Map<String, String>>();
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("CENTRAL", "Central");
		country.put("WEST", "Western");
		country.put("EAST", "Eastern");
		country.put("NORTH", "Northern");
		
		referenceData.put("countryList", country);
		
		return country;
	}
}
