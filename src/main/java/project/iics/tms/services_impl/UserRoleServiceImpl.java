package project.iics.tms.services_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.UserRoleDao;
import project.iics.tms.services.UserRoleService;

@Transactional
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public void createNewUserRole(UserRole userRole) {

		userRoleDao.create(userRole);
	}

	@Override
	public List<UserRole> getUserRoles() {
		
		return userRoleDao.getAll();
	}

	@Override
	public List<UserRole> getUserRoleByProjectUser(ProjectUser projectUser) {
	
		return userRoleDao.findRoleByProjectUser(projectUser);
	}

	@Override
	public UserRole getUserRole(Long id) {
		return userRoleDao.get(id);
	}

	@Override
	public void updateUserRole(UserRole UserRole) {

		userRoleDao.update(UserRole);
		
	}

	@Override
	public void deleteUserRole(Long id) {

		userRoleDao.deleteById(id);
	}

	@Override
	public UserRole getUserRole(String userRole) {
		
		return userRoleDao.findRoleByRoleName(userRole);
	}

	

}
