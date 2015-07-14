package project.iics.tms.repository_impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.UserRoleDao;

@Repository("UserRoleDao")
public class UserRoleDaoImpl extends AbstractHbnDao<UserRole> implements UserRoleDao {

	

	@SuppressWarnings("unchecked")
	public List<UserRole> findRoleByProjectUser(ProjectUser projectUser) {
	
		return getSession().getNamedQuery("findRoleByProjectUser").setString("projectUsersUnderRole", "%" + projectUser + "%").list();
	}

	@SuppressWarnings("unchecked")
	public UserRole findRoleByRoleName(String roleName) {
	
		List<UserRole> list = getSession().getNamedQuery("findRoleByRoleName").setString("role", "%" + roleName + "%").list();
		
		return list.get((list.size())-1);
	}

}
