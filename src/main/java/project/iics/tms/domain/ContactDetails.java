package project.iics.tms.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;

import project.iics.tms.controllers.validation.ValidPhone;

public class ContactDetails {

	/**
	 * The ContactDetails entity represents contact details that belong to the
	 * user of the task management system
	 */

	private Long id;
	private String TelephoneNumber;
	private String MobilePhoneNumber;
	private String faxNumber;
	private String EmailAddress;
	private String HomeAddress;
	private String PostCode;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@ValidPhone
	@Column
	public String getTelephoneNumber() {
		return TelephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}
	
	@ValidPhone
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
	@Email
	@Column
	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	
	@Column
	public String getHomeAddress() {
		return HomeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	
	
	@Column
	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public String toString() {
		return "[ContactDetails: id =" + id + ",Telephone Number ="
				+ TelephoneNumber + ",Mobilephone Number =" + MobilePhoneNumber
				+ ",Fax number =" + faxNumber + ",Email Address ="
				+ EmailAddress + ",Home Address =" + HomeAddress
				+ ",Post Code =" + PostCode + "]";
	}
}
