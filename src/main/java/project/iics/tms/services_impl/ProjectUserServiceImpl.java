package project.iics.tms.services_impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;
import project.iics.tms.services.ProjectUserService;

@Transactional
@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {

	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public void createNewProjectUser(ProjectUser projectUser) {

		projectUserDao.create(projectUser);
	}

	@Override
	public List<ProjectUser> getProjectUsers() {

		return projectUserDao.getAll();
	}

	@Override
	public List<ProjectUser> getProjectUserByUserName(String username) {

		System.out.println("System reaches  ProjectUserServiceImpl");
		return projectUserDao.findByUserName(username);
	}

	@Override
	public ProjectUser getProjectUser(Long id) {

		return projectUserDao.get(id);
	}

	@Override
	public void updateProjectUser(ProjectUser projectUser) {

		projectUserDao.update(projectUser);
	}

	@Override
	public void deleteProjectUser(Long id) {

		projectUserDao.deleteById(id);
	}

	@Override
	public boolean isRegisteredProjectUser(String username, String password) {

		return !projectUserDao.notARegisteredUser(username, password);
	}

	@Override
	public ProjectUser getRegisteredUserByLogin(String username, String password) {

		return projectUserDao.getRegisteredUsersByLogin(username, password)
				.get(projectUserDao.getRegisteredUsersByLogin(username,
						password).size() - 1);
	}

	@Override
	public String assignRoleToProjectUser(ProjectUser projectUser,
			UserRole userRole) {

		projectUserDao.assignRolesToProjectUser(projectUser, userRole);

		return userRole.ToString();
	}

	@Override
	public void createProtectedProjectUser(ProjectUser projectUser,
			String password, String Confirmpassword) {
		projectUserDao.create(projectUser, password, Confirmpassword);

	}

	@Override
	public Set<Project> getProjectUserProjects(ProjectUser projectUser) {
		
		return projectUserDao.getProjectUserProjects(projectUser);
	}

}
