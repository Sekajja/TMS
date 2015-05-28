package project.iics.tms.services;

import java.util.List;

import project.iics.tms.domain.ContactDetails;
import project.iics.tms.domain.ProjectUser;

public interface ContactDetailsService {

	public void createNewContactDetails(ContactDetails contactDetails);
	
	public void createAssignedContactDetails(ProjectUser projectUser);
	
	public List<ContactDetails> getAllContactDetails() ;	
	
	public ContactDetails getContactDetails(Long i);
	
	public void updateContactDetails(ContactDetails contactDetails);
	
	public void deleteContactDetails(Long id);
	
	public List<ContactDetails> getContactDetailsByEmailAddress(String emailAddress);
	
	public List<ContactDetails> getContactDetailsByTelephoneNumber(String telephoneNumber);
}
