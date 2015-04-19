package project.iics.tms.services_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.repository.ProjectUserDao;
import project.iics.tms.services.ProjectUserService;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	@Autowired 
	private ProjectUserDao projectUserDao;
	
	@Override
	public void createNewProjectUser(ProjectUser projectUser) {
		// TODO Auto-generated method stub
	
		projectUserDao.create(projectUser);
	}

	@Override
	public List<ProjectUser> getProjectUsers() {
		// TODO Auto-generated method stub
		return projectUserDao.getAll();
	}

	@Override
	public List<ProjectUser> getProjectUserByUserName(String username) {
		// TODO Auto-generated method stub
		return projectUserDao.findByUserName(username);
	}

	@Override
	public ProjectUser getProjectUser(Long id) {
		// TODO Auto-generated method stub
		return projectUserDao.get(id);
	}

	@Override
	public void updateProjectUser(ProjectUser projectUser) {
		// TODO Auto-generated method stub
		projectUserDao.update(projectUser);
	}

	@Override
	public void deleteProjectUser(Long id) {
		// TODO Auto-generated method stub
		projectUserDao.deleteById(id);
	}

}
