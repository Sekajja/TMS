package project.iics.tms.services_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.iics.tms.domain.ContactDetails;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.repository.ContactDetailsDao;
import project.iics.tms.services.ContactDetailsService;

public class ContactDetailsServiceImpl implements ContactDetailsService{

	@Autowired
	private ContactDetailsDao contactDetailsDao;
	
	@Override
	public void createNewContactDetails(ContactDetails contactDetails) {
		
		contactDetailsDao.create(contactDetails);
	}

	@Override
	public List<ContactDetails> getAllContactDetails() {
		
		return contactDetailsDao.getAll();
	}

	@Override
	public ContactDetails getContactDetails(Long i) {
		
		return contactDetailsDao.get(i);
	}

	@Override
	public void updateContactDetails(ContactDetails contactDetails) {
		
		contactDetailsDao.update(contactDetails);
	}

	@Override
	public void deleteContactDetails(Long id) {
		
		contactDetailsDao.deleteById(id);
	}

	@Override
	public List<ContactDetails> getContactDetailsByEmailAddress(
			String emailAddress) {
		// TODO Auto-generated method stub
		return contactDetailsDao.findContactDetailsByEmailAddress(emailAddress);
	}

	@Override
	public List<ContactDetails> getContactDetailsByTelephoneNumber(
			String telephoneNumber) {
		// TODO Auto-generated method stub
		return contactDetailsDao.findContactDetailsByTelephoneNumber(telephoneNumber);
	}

	@Override
	public void createAssignedContactDetails(ProjectUser projectUser) {
		// TODO Auto-generated method stub
		contactDetailsDao.create(projectUser);
	}

}
