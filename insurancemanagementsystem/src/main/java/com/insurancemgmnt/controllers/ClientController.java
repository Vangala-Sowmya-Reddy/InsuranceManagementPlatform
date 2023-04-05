package com.insurancemgmnt.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.insurancemgmnt.dtos.ClientDTO;
import com.insurancemgmnt.entities.Client;
import com.insurancemgmnt.exceptions.ClientNotFoundException;
import com.insurancemgmnt.service.ClientService;

import jakarta.validation.Valid;

@RestController
public class ClientController {
@Autowired
ClientService clientService;

//For posting client details

		@PostMapping(path="/client")
		public ResponseEntity<Client> addClient(@RequestBody @Valid  ClientDTO clientDTO){
			try
			{
				Client client = clientService.saveClient(clientDTO);
				 if(client!=null) {
						return new ResponseEntity<Client>(client,HttpStatus.CREATED);
					}
			}
			catch(Exception ex)
			{
				throw new ClientNotFoundException("Client data is not inserted!Please enter valid client details");
			}
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}
		
		//getting client details by Its id
		
		@GetMapping(path="/client/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id)
		{
			try {
				Client client = clientService.getClientById(id);
				if(client!=null) {
					return new ResponseEntity<Client>(client,HttpStatus.FOUND);
				}
			}
			catch(Exception e)
			{
				throw new ClientNotFoundException("No such client with id " + id + " found");
			}
			 return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
			
		}
		
		//Getting all clients details
		
		@GetMapping(path="/allClients")
		public ResponseEntity<List<Client>> getAllClients()
		{
			try
			{
			 List<Client> clientList=clientService.displayAllClients();
			 if(clientList!=null)
				return new ResponseEntity<List<Client>>(clientList,HttpStatus.FOUND);
			}
			catch(Exception e)
			{
				throw new ClientNotFoundException("No such client Exist");
			}
			return new ResponseEntity<List<Client>>(HttpStatus.NOT_FOUND);
		}
		
		//updating client details based on id
		
		@PutMapping(path="/updateClient/{id}")
		public ResponseEntity<String> updateClientById(@PathVariable("id") Integer id, @RequestBody @Valid ClientDTO clientDTO)
		{
			try
			{
			 String client=clientService.updateClientById(id, clientDTO);
			 if(client!=null)
				return new ResponseEntity<String>(client,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new ClientNotFoundException("Unable to update client details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);		
		}
		
		
		//Deleting client details by its Id
		@DeleteMapping(path="/deleteClientById/{id}")
		public ResponseEntity<String> deleteClientById(@PathVariable("id") Integer id)
		{
			try 
			{
			 String client=clientService.deleteClientById(id);
			 if(client!=null)
				return new ResponseEntity<String>(client,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new ClientNotFoundException("Unable to delete client details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
		}
		
		//Deleting all clients details
			@DeleteMapping(path="/deleteAllClientsdetails")
			public ResponseEntity<String> deleteAllClients()
			{
				try
				{
				 String client=clientService.deleteAllClients();
				 if(client!=null)
					return new ResponseEntity<String>(client,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new ClientNotFoundException("Unable to delete clients details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
			}	
		
		//End Of code
}
