package agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import agenda.model.Client;
import agenda.service.ClientService;

@RestController
@RequestMapping(value = "/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("clientes")
	public List<Client> getClients() {
		return clientService.getAllClients();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/clientes")
	public void addClient(@RequestBody Client client) {
		clientService.updateClient(client);
	}
	
}
