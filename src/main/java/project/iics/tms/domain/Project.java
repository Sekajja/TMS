package project.iics.tms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

@Entity

@NamedQueries({
	@NamedQuery(name = "findProjectByProjectName", query = "from Project where projectname like :projectname"

	) })
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6874020486132283557L;
	private Long id;
	private String ProjectName;
	private String ProjectAcronym;
	private Date StartDate;
	private Date EndDate;
	private String ProjectDescription;
	private ProjectUser projectUser;

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
	@NotBlank
	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	
	
	@Column
	@NotBlank
	public String getProjectAcronym() {
		return ProjectAcronym;
	}

	public void setProjectAcronym(String projectAcronym) {
		ProjectAcronym = projectAcronym;
	}
	
	@Column
	@NotBlank
	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	@Column
	@NotBlank
	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	@Column
	public String getProjectDescription() {
		return ProjectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public ProjectUser getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(ProjectUser projectUser) {
		this.projectUser = projectUser;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", ProjectName=" + ProjectName
				+ ", projectUser=" + projectUser + "]";
	}
	
	
	
}
