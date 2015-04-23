package project.iics.tms.repository;

import java.util.List;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;


public interface UserRoleDao extends Dao<UserRole> {

	List<UserRole> findRoleByProjectUser(ProjectUser projectUser);
	UserRole findRoleByRoleName(String roleName);
}
