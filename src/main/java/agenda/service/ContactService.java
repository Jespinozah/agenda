package agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import agenda.dto.ContactDto;
import agenda.model.Contact;
import agenda.repository.ContactRepository;
import agenda.util.BeanCopyUtils;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Page<Contact> getAllContacts(PageRequest request){
		Sort sort = new Sort(Direction.DESC, "fechaCreacion");
		int pageNo = request.getPageNumber();
		int pageSize = request.getPageSize();
		if(pageNo < 0){
			pageNo = 0;
		}
		if(pageSize < 1) {
			pageSize = 5;
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Contact> pageData = contactRepository.findAll(pageable);
		return pageData;
	}
	
	
	public Contact addContact(Contact contact) {
		return contactRepository.saveAndFlush(contact);
	}
	
	public ContactDto getContact(int id) {
		Optional<Contact> contact = contactRepository.findById(id);
		return BeanCopyUtils.toContactDTO(contact.get());
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}
}
