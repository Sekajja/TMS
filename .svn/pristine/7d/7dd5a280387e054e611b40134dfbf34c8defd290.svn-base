package project.iics.tms.repository_impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import project.iics.tms.domain.Project;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;

@Repository("projectUserDao")
public class ProjectUserDaoImpl extends AbstractHbnDao<ProjectUser> implements ProjectUserDao{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@SuppressWarnings("unchecked")
	public List<ProjectUser> findByUserName(String userName) {
	
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
	
	@Override
	public Set<Project> getProjectUserProjects(ProjectUser projectUser) {
		Session session = sessionFactory.openSession();
		projectUser = load(new Long(projectUser.getId()));
		//session.load(ProjectUser.class,new Long(projectUser.getId()));
		Set<Project> projects = projectUser.getProjects();
		Hibernate.initialize(projects);		
		session.close();
		return projects;
		
	}

	
	
	

}
