package in.railworld.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.railworld.app.Services.Implemetation.ContactService;
import in.railworld.app.model.Contact;

@RestController
@RequestMapping("/api/contact")

public class ContactController {
	
	private final ContactService contactservice;
	
	@Autowired
	public ContactController(ContactService contactservice) {
		this.contactservice=contactservice;
	}
	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
		Contact saveMessage = contactservice.SaveMessage(contact);
		return new ResponseEntity<>(contact,HttpStatus.OK);
		
	}

}
