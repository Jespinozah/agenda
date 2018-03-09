package agenda.util;

import org.modelmapper.ModelMapper;

import agenda.dto.ClientDto;
import agenda.dto.ContactDto;
import agenda.dto.ProductDto;
import agenda.model.Client;
import agenda.model.Contact;
import agenda.model.Product;

public final class BeanCopyUtils {

	public BeanCopyUtils() {

	}
	
	public static Client toClientEntity(ClientDto dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Client.class);
	}
	
	public static ClientDto toClientDTO(Client client) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(client, ClientDto.class);
	}
	
	public static Contact toContactEntity(ContactDto dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Contact.class);
	}
	
	public static ContactDto toContactDTO(Contact contact) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(contact, ContactDto.class);
	}
	
	public static Product toProductEntity(ProductDto dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Product.class);
	}
	
	public static ProductDto toProductDTO(Product product) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(product, ProductDto.class);
	}
}
