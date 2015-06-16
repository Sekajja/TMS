package project.iics.tms.repository_impl;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.Task;
import project.iics.tms.repository.TaskDao;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractHbnDao<Task> implements TaskDao {

}