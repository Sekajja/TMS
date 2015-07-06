package project.iics.tms.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//@SuppressWarnings("unchecked")
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
				
				/////////////////////////////////////////////////////////////////////
				
				HashMap<Project, String> times = new HashMap<Project, String>(0);
				
				
				for(Project projects:projectUserService.getProjectUserProjects(projectUser)){
					
					times.put(projects, projects.getProjectName());	
					
					
				}
				
				
				
				//////////////////////////////////////////////////////////////////////
				model.addAttribute("TimeRemaining", sortByValue(times));
		
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
	
	projectService.setProjectUser(reviewer, project);
	
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
	
	@RequestMapping(value = "reviewerproject/edit/{id}", method = RequestMethod.GET)
 	public String editProject(@PathVariable Integer id, Model model){	
		Project editedProject = projectService.getProject(new Long(id));
		model.addAttribute("editedProject",editedProject);
		return "";
	}
	
	@RequestMapping(value = "reviewerproject/edit/{id}", method = RequestMethod.POST)
 	public String editProjectPost(@ModelAttribute @Valid Project project, @PathVariable Integer id, ProjectUser reviewer, BindingResult result, Model model){	
		
		
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
		
		projectService.setProjectUser(reviewer, project);
		
		
		projectService.updateProject(project);
		
		model.addAttribute("UpdateSuccess",""+project.getProjectName()+" was updated Successfully");
		model.addAttribute("project", project);
		return "projectReviewer/ProjectReviewerProject";
	}
	
	@RequestMapping(value = "reviewerproject/delete/{id}", method = RequestMethod.GET)
 	public String deleteProject(@PathVariable Integer id, Model model){	

		return "redirect:reviewerproject";
	}
	
	
	@RequestMapping(value = "reviewerproject/delete/{id}", method = RequestMethod.POST)
 	public String deleteProjectPost(@ModelAttribute Project project, @PathVariable Integer id, Model model, ProjectUser reviewer){	
		
	
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
				
				Project deletedProject =  projectService.getProject(new Long(id));
				String deletedProjectName = deletedProject.getProjectName();
				model.addAttribute("deletionSuccess",""+deletedProjectName+" was deleted Successfully");
				model.addAttribute("reviewer",reviewer);
				projectService.deleteProject(new Long(id));
				
				
				logger.info(""+deletedProjectName+" was deleted For Project User:{}", reviewer.getFullName());
		
				return "redirect:reviewerproject";
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map sortByValue(Map unsortMap) {	 
		
		List list = new LinkedList(unsortMap.entrySet());
	 
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
							.compareTo(((Map.Entry) (o2)).getValue());
			}
		});
	 
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	 
}
