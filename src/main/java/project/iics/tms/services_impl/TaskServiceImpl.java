package project.iics.tms.services_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.Task;
import project.iics.tms.repository.TaskDao;
import project.iics.tms.services.TaskService;

@Transactional
@Service("taskService")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public void createNewTask(Task task) {
		
		taskDao.create(task);
	}

	@Override
	public List<Task> getTask() {
		
		return taskDao.getAll();
	}

	@Override
	public Task getTask(Long id) {
	
		return taskDao.get(id);
	}

	@Override
	public void updateTask(Task task) {
		taskDao.update(task);
		
	}

	@Override
	public void deleteTask(Long id) {
		taskDao.deleteById(id);		
	}

}
