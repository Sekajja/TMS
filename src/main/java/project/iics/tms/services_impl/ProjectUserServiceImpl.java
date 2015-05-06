package project.iics.tms.services_impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;
import project.iics.tms.services.ProjectUserService;

@Transactional
@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {

	private static final Logger logger = LoggerFactory.getLogger(ProjectUserServiceImpl.class);
	 
	@Autowired 
	private ProjectUserDao projectUserDao;
	
//	@Autowired
//    private Assembler assembler;
	
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
		System.out.println("System reaches  ProjectUserServiceImpl");
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

	@Override
	public boolean isRegisteredProjectUser(String username, String password) {
		// TODO Auto-generated method stub
		return !projectUserDao.notARegisteredUser(username, password);
	}

	@Override
	public ProjectUser getRegisteredUserByLogin(String username, String password) {
		// TODO Auto-generated method stub
		return projectUserDao.getRegisteredUsersByLogin(username, password).
				get(projectUserDao.getRegisteredUsersByLogin(username, password).size()-1);
	}

	@Override
	public String assignRoleToProjectUser(ProjectUser projectUser, UserRole userRole) {
		// TODO Auto-generated method stub
		projectUserDao.assignRolesToProjectUser(projectUser, userRole);
		
		return userRole.ToString();
	}


}
