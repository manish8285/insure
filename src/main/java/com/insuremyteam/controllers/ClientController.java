package com.insuremyteam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuremyteam.entities.Client;
import com.insuremyteam.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/")
	ResponseEntity<List<Client>> getAllClients(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.clientService.getAllClient());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Client> getClient(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(this.clientService.getClientById(id));
	}
	
	@PostMapping("/")
	ResponseEntity<Client> createNewClient(@Valid @RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.createNewClient(client));
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Client> updateClient(@RequestBody Client client,
										@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.clientService.updateClient(id,client));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteClient(@PathVariable Integer id){
		this.clientService.deleteClient(id);
		return ResponseEntity.status(HttpStatus.OK).body("Client Deleted Successfully");
	}
	

}
