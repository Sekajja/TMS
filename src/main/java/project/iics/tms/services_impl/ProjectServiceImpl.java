package project.iics.tms.services_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.Project;
import project.iics.tms.repository.ProjectDao;
import project.iics.tms.services.ProjectService;

@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Override
	public void createNewProject(Project project) {
		projectDao.create(project);
	}

	@Override
	public List<Project> getProjects() {

		return projectDao.getAll();
	}

	@Override
	public Project getProject(Long id) {

		return projectDao.get(id);
	}

	@Override
	public void updateProject(Project project) {
		
		projectDao.update(project);

	}

	@Override
	public void deleteProject(Long id) {
		
		projectDao.deleteById(id);
	}

}
