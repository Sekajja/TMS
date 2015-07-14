package project.iics.tms.repository_impl;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.repository.ProjectDao;

@Repository("projectDao")
public class ProjectDaoImpl extends AbstractHbnDao<Project> implements ProjectDao{

	@Override
	public void setProjectUser(ProjectUser projectUser, Project project) {

		project.setProjectUser(projectUser);
		getSession().saveOrUpdate(project);
	}

	
}
