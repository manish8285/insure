package com.insuremyteam.services.imples;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.entities.Client;
import com.insuremyteam.exceptions.ResourceNotFoundException;
import com.insuremyteam.repositries.ClientRepo;
import com.insuremyteam.services.ClientService;

@Service
public class ClientServiceImple implements ClientService {
	
	@Autowired
	private ClientRepo clientRepo;

	@Override
	public Client createNewClient(Client client) {
		// TODO Auto-generated method stub
		return this.clientRepo.save(client);
		}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return this.clientRepo.findAll();
	}

	@Override
	public Client getClientById(int clientId) {
		// TODO Auto-generated method stub
		return this.clientRepo.findById(clientId).orElseThrow(()->new ResourceNotFoundException("Client", "id", clientId));
	}

	@Override
	public Client updateClient(int id,Client client) {
		Client client2 = this.getClientById(id);
		client2.setAddress(client.getAddress());
		client2.setContact(client.getContact());
		client2.setDob(client.getDob());
		client2.setName(client.getName());
		// TODO Auto-generated method stub
		return this.clientRepo.save(client2);
	}

	@Override
	public void deleteClient(int clientId) {
		Client client2 = this.getClientById(clientId);
		this.clientRepo.delete(client2);

	}

}
