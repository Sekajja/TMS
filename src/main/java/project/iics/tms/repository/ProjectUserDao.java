package project.iics.tms.repository;

import java.util.List;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;


public interface ProjectUserDao extends Dao<ProjectUser> {

	List<ProjectUser> findByUserName(String userName);
	Boolean notARegisteredUser(String userName, String password);
	List<ProjectUser> getRegisteredUsersByLogin(String userName, String password);
	void assignRolesToProjectUser(ProjectUser projectUser, UserRole userRole);
	
}
