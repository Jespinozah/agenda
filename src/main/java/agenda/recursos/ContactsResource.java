package agenda.recursos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import agenda.dto.ContactDto;
import agenda.model.Contact;
import agenda.util.BeanCopyUtils;

public class ContactsResource extends AbstractCollectionResource<Contact, ContactDto> implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public ContactsResource(Page<Contact> pageData ) {
		super(pageData);
	}
	
	@Override
	protected List<ContactDto> populateDTOs(List<Contact> content)
	{
		List<ContactDto> dtos = new ArrayList<>();
		for (Contact contact : content)
		{
			//dtos.add(new ClientDto(post));
			dtos.add(BeanCopyUtils.toContactDTO(contact));

		}
		return dtos;
	}
}
