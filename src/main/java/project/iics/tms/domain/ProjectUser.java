package project.iics.tms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import project.iics.tms.controllers.validation.PasswordMatches;
import project.iics.tms.controllers.validation.ValidName;
import project.iics.tms.controllers.validation.ValidPassword;

/*@PasswordMatches.List({
 @PasswordMatches(first = "Password", second = "Confirmpassword", message = "The password fields must match")
 })*/

@Entity
@NamedQueries({
		@NamedQuery(name = "findUserByUserName", query = "from ProjectUser where user_name like :user_name"),
		@NamedQuery(name = "findRegisteredUser", query = "from ProjectUser where user_name like :user_name AND password like :password"

		) })
@PasswordMatches(first = "Password", second = "Confirmpassword", message = "Must match a non-empty password field")
public class ProjectUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Project User entity defines a user of the task management system
	 */

	private Long id;

	@ValidName(message = "No rockstar names, letters only")
	@Size(min = 1, max = 60)
	private String First_Name;

	@ValidName(message = "No rockstar names, letters only")
	private String Middle_Name;

	@ValidName(message = "No rockstar names, letters only")
	@Size(min = 1, max = 60)
	private String Last_Name;

	@Size(min = 1, max = 60)
	private String User_Name;

	@NotNull
	@ValidPassword(message = "Password must contain Uppercase letters & Digits")
	private String Password;

	// Because it really works
	// @NotBlank(message="Please confirm password")
	private String Confirmpassword;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Please provide a birth date")
	@Past(message = "Are you really from the future?")
	private Date DOB;

	private Set<ContactDetails> contactDetails;

	public ProjectUser() {
		// TODO Auto-generated constructor stub
	}

	private Boolean Enabled = true;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

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
	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Column(name = "first_name")
	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	@Column(name = "last_name")
	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	@Column(name = "middle_names")
	public String getMiddle_Name() {
		return Middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		Middle_Name = middle_Name;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 45)
	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Column(name = "confirm_password")
	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	// @Column(name = "enabled",nullable = false,columnDefinition =
	// "BOOLEAN NOT NULL DEFAULT TRUE")
	@Column(name = "Enabled", columnDefinition = "BOOLEAN DEFAULT TRUE")
	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setUserRole(UserRole userRole) {
		if (!userRoles.contains(userRole)) {
			userRoles.add(userRole);
		}
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectUser")
	public Set<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(Set<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public void setSingleContactDetailsRecord(
			ContactDetails contactDetailsRecord) {
		if (this.contactDetails.contains(contactDetailsRecord)) {
			contactDetails.add(contactDetailsRecord);

		}
	}

	@Transient
	public String getFullName() {
		String fullName = Last_Name + ", " + First_Name;
		if (!(Middle_Name == null || "".equals(Middle_Name.trim()))) {
			fullName += " " + Middle_Name + ".";
		}
		return fullName;
	}

	public String toString() {
		return "[ProjectUser: id=" + id + ", firstName=" + First_Name
				+ ", middleNames=" + Middle_Name + ", lastName=" + Last_Name
				+ ", userName=" + User_Name + ", password=" + Password
				+ ", date of birth=" + DOB + "]";
	}

}