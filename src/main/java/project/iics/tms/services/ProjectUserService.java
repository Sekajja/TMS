package project.iics.tms.services;

import java.util.List;

import project.iics.tms.domain.ProjectUser;


public interface ProjectUserService{
	
	public void createNewProjectUser(ProjectUser projectUser);
	
	public List<ProjectUser> getProjectUsers() ;
	
	public List<ProjectUser> getProjectUserByUserName(String username);
	
	public boolean isRegisteredProjectUser(String username,String password);
	
	public ProjectUser getRegisteredUserByLogin(String username,String password);
	
	public ProjectUser getProjectUser(Long i);
	
	public void updateProjectUser(ProjectUser projectUser);
	
	public void deleteProjectUser(Long id);
	
}
