package project.iics.tms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity

public class UserRole {
	
	
	/*
	 * This class/Entity specifies roles of the user in the system
	 * roles: project reviewer, project delegate...system admin??
	 * 
	 * */
	
	private Long UserRoleID;
	String role;
	ProjectUser projectUser;
	
	
	public UserRole() {
		
		
	}
	
	public UserRole(String role) {
		
		setRole(role);
	}

	
	
	public UserRole(String role, ProjectUser projectUser) {
		this.role = role;
		this.projectUser = projectUser;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getUserRoleID() {
		return UserRoleID;
	}

	public void setUserRoleID(Long userRoleID) {
		UserRoleID = userRoleID;
	}

	@Column(name = "role", unique = true, 
			nullable = false, length = 160)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "project_user", nullable = false )
	public ProjectUser getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(ProjectUser projectUser) {
		this.projectUser = projectUser;
	}
	
	@Transient
	public String ToString(){
		
		return role;
	}

	

}
