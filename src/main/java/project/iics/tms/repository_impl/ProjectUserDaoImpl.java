package project.iics.tms.repository_impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.repository.ProjectUserDao;

@Repository
public class ProjectUserDaoImpl extends AbstractHbnDao<ProjectUser> implements ProjectUserDao{

	
	@SuppressWarnings("unchecked")
	public List<ProjectUser> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return getSession().getNamedQuery("findUserByUserName").setString("user_name", "%" + userName + "%").list();
	}

}
