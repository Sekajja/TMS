package project.iics.tms.services;

import java.util.List;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;

public interface UserRoleService {

	public void createNewUserRole(UserRole userRole);
	
	public List<UserRole> getUserRoles() ;
	
	public UserRole getUserRole(String userRole) ;
	
	public List<UserRole> getUserRoleByProjectUser(ProjectUser projectUser);
		
	public UserRole getUserRole(Long i);
	
	public void updateUserRole(UserRole UserRole);
	
	public void deleteUserRole(Long id);
}
