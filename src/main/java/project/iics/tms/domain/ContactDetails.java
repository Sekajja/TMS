package project.iics.tms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import project.iics.tms.controllers.validation.ValidPhone;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "findContactDetailsByEmailAddress",
			query = "from ContactDetails where EmailAddress like :EmailAddress"
					),
	@NamedQuery(
			name = "findContactDetailsByTelephoneNumber",
			query = "from ContactDetails where TelephoneNumber like :TelephoneNumber"

			)
	})
public class ContactDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2073823932653146731L;
	/**
	 * The ContactDetails entity represents contact details that belong to the
	 * user of the task management system
	 */

	private Long id;
	@ValidPhone
	private String TelephoneNumber;
	@ValidPhone
	private String MobilePhoneNumber;
	private String faxNumber;
	@Email
	@NotBlank
	private String EmailAddress;
	private String PhysicalAddress;
	private String BoxNumber;
	private ProjectUser projectUser;

	
	
	public ContactDetails() {
		
	}

	public ContactDetails(ProjectUser projectUser) {
		this.projectUser = projectUser;
	}

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
	public String getTelephoneNumber() {
		return TelephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}
	

	@Column
	public String getMobilePhoneNumber() {
		return MobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		MobilePhoneNumber = mobilePhoneNumber;
	}
	
	@Column
	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	
	@Column
	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	
	@Column
	public String getPhysicalAddress() {
		return PhysicalAddress;
	}

	public void setPhysicalAddress(String PhysicalAddress) {
		PhysicalAddress = PhysicalAddress;
	}
	
	@Column
	public String getBoxNumber() {
		return BoxNumber;
	}

	public void setBoxNumber(String BoxNumber) {
		BoxNumber = BoxNumber;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	public ProjectUser getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(ProjectUser projectUser) {
		this.projectUser = projectUser;
	}

	public String toString() {
		return "[ContactDetails: id =" + id + ",Telephone Number ="
				+ TelephoneNumber + ",Mobilephone Number =" + MobilePhoneNumber
				+ ",Fax number =" + faxNumber + ",Email Address ="
				+ EmailAddress + ",Physical Address =" + PhysicalAddress
				+ ",Box Number =" + BoxNumber + "]";
	}
}
