package project.iics.tms.repository_impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;

@Repository("projectUserDao")
public class ProjectUserDaoImpl extends AbstractHbnDao<ProjectUser> implements ProjectUserDao{

	private static final Logger logger = LoggerFactory.getLogger(ProjectUserDaoImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@SuppressWarnings("unchecked")
	public List<ProjectUser> findByUserName(String userName) {
		// TODO Auto-generated method stub
	    logger.info("System reaches find by username");
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

		projectUser.setUserRole(userRole);
		
		getSession().saveOrUpdate(projectUser);

	}

	@Override
	public void create(ProjectUser projectUser, String password, String confirmpassword) {
		// TODO Auto-generated method stub
		create(projectUser);
		
		if(password.equals(confirmpassword)){
		String encPassword = passwordEncoder.encode(password);
		projectUser.setPassword(encPassword);
		projectUser.setConfirmpassword(encPassword);
		getSession().saveOrUpdate(projectUser);
		}

	}
	
	

}
