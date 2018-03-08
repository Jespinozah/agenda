package agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.model.Client;
import agenda.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
		List<Client> clientList = clientRepository.findAll();
		return clientList;
	}
	
	public void addClient(Client client) {
		clientRepository.saveAndFlush(client);
	}
	
//	public Client getClient(int id) {
//		Client client = clientRepository.findOne(id);
//		return client;
//	}
	
	public void updateClient(Client client) {
		clientRepository.save(client);
	}
	
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
	
}
