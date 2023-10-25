package in.railworld.app.Services.Implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.model.Contact;
import in.railworld.app.repository.ContactRepository;

@Service
public class ContactService {
	
	private final ContactRepository contactRepository;
	
	@Autowired
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository=contactRepository;
	}
	
	
	public Contact SaveMessage(Contact contact) {
		return contactRepository.save(contact);
		
	}

}
