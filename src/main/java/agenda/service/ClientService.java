package agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import agenda.model.Client;
import agenda.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Page<Client> getAllClients(PageRequest clientsRequest) {
		Sort sort = new Sort(Direction.DESC, "fechaCreacion");
		int pageNo = clientsRequest.getPageNumber();
		int pageSize = clientsRequest.getPageSize();
		if(pageNo < 0) {
			pageNo = 0;
		}
		if(pageSize < 1) {
			pageSize = 0;
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Client> pageData = clientRepository.findAll(pageable);
		return pageData;
	}
	
	public Client addClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}
	
	public Client getClient(int id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}
	
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
	
}
