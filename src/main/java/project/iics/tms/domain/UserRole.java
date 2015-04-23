package project.iics.tms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "findRoleByProjectUser",
			query = "from UserRole where projectUsersUnderRole like :projectUsersUnderRole"
					),
	@NamedQuery(
			name = "findRoleByRoleName",
			query = "from UserRole where role like :role"
					)
})
public class UserRole {
	
	
	/*
	 * This class/Entity specifies roles of the user in the system
	 * roles: project reviewer, project delegate...system admin??
	 * 
	 * */
	
	private Long UserRoleID;
	String role;
	private Set<ProjectUser> projectUsersUnderRole = new HashSet<ProjectUser>(0);
	
	public UserRole() {
		
		
	}
	
	public UserRole(String role) {
		
		setRole(role);
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
	
	@ManyToMany(mappedBy="userRoles")	
	public Set<ProjectUser> getProjectUsersUnderRole() {
		return projectUsersUnderRole;
	}

	public void setProjectUsersUnderRole(Set<ProjectUser> projectUsersUnderRole) {
		this.projectUsersUnderRole = projectUsersUnderRole;
	}
	
	public void setProjectUserUnderRole(ProjectUser projectUser) {
		if(!projectUsersUnderRole.contains(projectUser)){
			projectUsersUnderRole.add(projectUser);
		}
	}
	
	@Transient
	public String ToString(){
		
		return role;
	}

}
