package project.iics.tms.services;

import java.util.List;
import java.util.Set;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;


public interface ProjectUserService{
	
	public void createProtectedProjectUser(ProjectUser projectUser, String password, String Confirmpassword);
	
	public void createNewProjectUser(ProjectUser projectUser);
	
	public List<ProjectUser> getProjectUsers() ;
	
	public List<ProjectUser> getProjectUserByUserName(String username);
	
	public boolean isRegisteredProjectUser(String username,String password);
	
	public String assignRoleToProjectUser(ProjectUser projectUser, UserRole userRole);
	
	public String assignProjectToProjectUser(ProjectUser projectUser, Project project);
	
	public ProjectUser getRegisteredUserByLogin(String username,String password);
	
	public ProjectUser getProjectUser(Long i);
	
	public void updateProjectUser(ProjectUser projectUser);
	
	public void deleteProjectUser(Long id);
	
	public Set<Project> getProjectUserProjects(ProjectUser projectUser) ;

	
}
