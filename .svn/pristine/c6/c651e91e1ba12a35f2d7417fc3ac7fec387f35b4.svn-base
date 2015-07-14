package project.iics.tms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7824965427444333237L;
	private Long id;
	private String taskName;
	private String taskDescription;
	private Date startDate;
	private Date endDate;
	private int progress;
	private int priority;
	private Task parent;
	private boolean completed;

	// private Set<Task> dependency = new HashSet<Task>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Column
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	@Column
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column
	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	@Column
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName
				+ ", taskDescription=" + taskDescription + ", startDate="
				+ startDate + ", endDate=" + endDate + ", progress=" + progress
				+ ", priority=" + priority + ", parent=" + parent
				+ ", completed=" + completed + "]";
	}

}
