package agenda.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import agenda.dto.ClientDto;
import agenda.dto.ContactDto;
import agenda.dto.ProductDto;
import agenda.model.Client;
import agenda.model.Contact;
import agenda.model.Product;




@Component
public class ManagementMapper {
    private static final List<String> MAPPER_FILE = Arrays.asList("dozerMapping.xml");

    public ClientDto convertClientToClientDto(Client client) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(client, ClientDto.class, "clientToClientDTO");
    }
    
    public Client convertClientDtoToClient(ClientDto clientDto) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(clientDto, Client.class, "clientDTOToClient");
    }
    
    public List<ClientDto> convertClientListToClientDtoList(List<Client> clientList) {
        List<ClientDto> clientDtoList = new ArrayList<>();
            Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
            for (Client client : clientList) {
                clientDtoList.add(mapper.map(client, ClientDto.class, "clientToClientDTO"));
            }
        return clientDtoList;
    }
    
    public ContactDto convertContactToContactDto(Contact contact) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(contact, ContactDto.class, "contactToContactDTO");
    }
    
    public Contact convertContactDtoToContact(ContactDto contactDto) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(contactDto, Contact.class, "contactDTOToContac");
    }
    
    public List<ContactDto> convertContactListToContactDtoList(List<Contact> contactList) {
        List<ContactDto> contactDtoList = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        for (Contact contact : contactList) {
            contactDtoList.add(mapper.map(contact, ContactDto.class, "contactToContactDTO"));
        }
        return contactDtoList;
    }
    
    public ProductDto convertProductToProductDto(Product product) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(product, ProductDto.class, "productToProductDTO");
    }
    public Product convertProductDtoToProduct(ProductDto productDto) {
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        return mapper.map(productDto, Product.class, "productDtoToProduct");
    }

    public List<ProductDto> convertProductListToProductDTOList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper(MAPPER_FILE);
        for (Product product : productList) {
            productDtoList.add(mapper.map(product, ProductDto.class, "productToProductDTO"));
        }
        return productDtoList;
    }

}
