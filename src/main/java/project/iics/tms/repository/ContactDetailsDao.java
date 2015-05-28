package project.iics.tms.repository;

import java.util.List;

import project.iics.tms.domain.ContactDetails;
import project.iics.tms.domain.ProjectUser;


public interface ContactDetailsDao extends Dao<ContactDetails> {
	
	void create(ProjectUser projectUser); 
	List<ContactDetails> findContactDetailsByEmailAddress(String emailAddress);
	List<ContactDetails> findContactDetailsByTelephoneNumber(String telephoneNumber);
}
