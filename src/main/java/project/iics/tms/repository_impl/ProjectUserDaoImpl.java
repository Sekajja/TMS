package project.iics.tms.repository_impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;

@Repository("ProjectUserDao")
public class ProjectUserDaoImpl extends AbstractHbnDao<ProjectUser> implements ProjectUserDao{

	
	
	@SuppressWarnings("unchecked")
	public List<ProjectUser> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return getSession().getNamedQuery("findUserByUserName").setString("user_name", "%" + userName + "%").list();
	}

	@Override
	public Boolean notARegisteredUser(String userName, String password) {
		// TODO Auto-generated method stub
		
		return getSession().getNamedQuery("findRegisteredUser")
			.setString("user_name", userName)
			.setString("password", password).list().isEmpty();
	
	}

	@SuppressWarnings("unchecked")
	public List<ProjectUser> getRegisteredUsersByLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return getSession().getNamedQuery("findRegisteredUser").setString("user_name", userName)
		.setString("password", password).list();
	}

	@Override
	public void assignRolesToProjectUser(ProjectUser projectUser,UserRole userRole) {
		// TODO Auto-generated method stub
		
		
		
		projectUser.setUserRole(userRole);
		
		getSession().saveOrUpdate(projectUser);
		
		
		
		
	}

}
