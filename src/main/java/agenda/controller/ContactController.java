package agenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import agenda.dto.ServiceResponse;
import agenda.model.Contact;
import agenda.recursos.ContactsResource;
import agenda.service.ContactService;

@RestController
@RequestMapping(value = "/api/contactos")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="")
	public ServiceResponse<ContactsResource> getContacts(@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size) {
		PageRequest request = PageRequest.of(page, size);
		Page<Contact> pageData = contactService.getAllContacts(request);
		ContactsResource contactsResponse = new ContactsResource(pageData);
		return new ServiceResponse<>(contactsResponse);
	}
	

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ServiceResponse<Void> deleteContact(@PathVariable(name="id") int id) {
		contactService.deleteContact(id);
		return new ServiceResponse<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="", method= RequestMethod.DELETE)
	public ServiceResponse<Void> deleteContacts(@RequestParam(value="contactsId") String contactsId){
		String[] ids = contactsId.split(",");
		for(String strId : ids) {
			contactService.deleteContact(Integer.parseInt(strId));
		}
		return new ServiceResponse<>(HttpStatus.OK);
	}
}
