package project.iics.tms.repository_impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import project.iics.tms.domain.ContactDetails;
import project.iics.tms.domain.ProjectUser;
import project.iics.tms.repository.ContactDetailsDao;

@Repository("contactDetailsDao")
public class ContactDetailsDaoImpl extends AbstractHbnDao<ContactDetails> implements ContactDetailsDao{

	@SuppressWarnings("unchecked")//Java doesnt guarantee type safety at runtime
	@Override
	public List<ContactDetails> findContactDetailsByEmailAddress(
			String emailAddress) {
		
		return getSession().getNamedQuery("findContactDetailsByEmailAddress").setString("EmailAddress", "%" + emailAddress + "%").list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactDetails> findContactDetailsByTelephoneNumber(
			String telephoneNumber) {
		
		return getSession().getNamedQuery("findContactDetailsByTelephoneNumber").setString("TelephoneNumber", "%" + telephoneNumber + "%").list();
	}

	@Override
	public void create(ProjectUser projectUser) {
		// TODO Auto-generated method stub
		create(new ContactDetails(projectUser));
	}
/*
	@Override
	public ContactDetails load(Serializable id) {
		
		   Query query = (Query) getSession().createQuery("from ContactDetails r where r.id=:id").setLong("id", ((Long)id).longValue());
	       ContactDetails ContactDetails = (ContactDetails)((org.hibernate.Query) query).uniqueResult();
	       Hibernate.initialize(ContactDetails.getProjectUser());
	   
	        --OR --
	       if(ContactDetails.getTags() != null) {
	          ContactDetails.getTags().size();
	       }
	                  
	       return ContactDetails;
		
		//return super.load(id);
	}*/

	
}
