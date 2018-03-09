package agenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import agenda.dto.ClientDto;
import agenda.dto.ContactDto;
import agenda.dto.ProductDto;
import agenda.dto.ServiceResponse;
import agenda.model.Client;
import agenda.model.Contact;
import agenda.model.Product;
import agenda.recursos.ClientsResource;
import agenda.service.ClientService;
import agenda.service.ContactService;
import agenda.service.ProductService;
import agenda.util.BeanCopyUtils;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ServiceResponse<ClientsResource> getClients(@RequestParam(name = "page",
			defaultValue= "0") int page, @RequestParam(name = "size", defaultValue = "5") int size){
		PageRequest request = PageRequest.of(page, size);
		Page<Client> pageData = clientService.getAllClients(request);
		ClientsResource clientsResponse = new ClientsResource(pageData);		
		ServiceResponse<ClientsResource> resp = new ServiceResponse<>(clientsResponse);
		return resp;
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ServiceResponse<ClientDto> getClient(@PathVariable int id) {
		Client client = clientService.getClient(id);
		return new ServiceResponse<ClientDto>(BeanCopyUtils.toClientDTO(client));
		
	}
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ServiceResponse<ClientDto> addClient(@RequestBody ClientDto clientDto) {
		Client client = BeanCopyUtils.toClientEntity(clientDto);
		Client createClient = this.clientService.addClient(client);
		return new ServiceResponse<ClientDto>(BeanCopyUtils.toClientDTO(createClient));
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ServiceResponse<Void> deleteClient(@PathVariable(value="id") int id) {
		clientService.deleteClient(id);
		return new ServiceResponse<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{clientId}/contactos",method = RequestMethod.POST)
	public ServiceResponse<ContactDto> addContact(@PathVariable(value="clientId") int clientId,
			@RequestBody ContactDto contactDto){
		Contact contact = BeanCopyUtils.toContactEntity(contactDto);
		contact.setClient(new Client(clientId));
		Contact createContact = contactService.addContact(contact);
		return new ServiceResponse<>(BeanCopyUtils.toContactDTO(createContact));
			
	}
	
	@RequestMapping(value="/{clientId}/productos", method = RequestMethod.POST)
	public ServiceResponse<ProductDto> addProduct(@PathVariable(value="clientId") int clientId,
			@RequestBody ProductDto productDto){
		Product product = BeanCopyUtils.toProductEntity(productDto);
		product.setClient(new Client(clientId));
		Product createProduct = productService.addProduct(product);
		return new ServiceResponse<>(BeanCopyUtils.toProductDTO(createProduct));
	}
	
}
