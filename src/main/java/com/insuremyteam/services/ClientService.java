package com.insuremyteam.services;

import java.util.List;

import com.insuremyteam.entities.Client;

public interface ClientService {
	
	Client createNewClient(Client client);
	
	List<Client> getAllClient();
	
	Client getClientById(int clientId);
	
	Client updateClient(int id,Client client);
	
	void deleteClient(int clientId);

}
