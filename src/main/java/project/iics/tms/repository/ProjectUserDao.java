package project.iics.tms.repository;

import java.util.List;

import project.iics.tms.domain.ProjectUser;


public interface ProjectUserDao extends Dao<ProjectUser> {

	List<ProjectUser> findByUserName(String userName);

	
}
