package project.iics.tms.services;

import java.util.List;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;

public interface ProjectService {

	public void createNewProject(Project project);

	public List<Project> getProjects();

	/* public List<ProjectUser> getProjectUserByUserName(String username); */

	public Project getProject(Long id);

	public void updateProject(Project project);

	public void deleteProject(Long id);
	

	public void setProjectUser(ProjectUser projectUser, Project project);

}
