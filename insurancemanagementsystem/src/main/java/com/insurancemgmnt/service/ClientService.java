package com.insurancemgmnt.service;

import java.util.List;
import com.insurancemgmnt.dtos.ClientDTO;
import com.insurancemgmnt.entities.Client;

public interface ClientService {
    Client saveClient(ClientDTO clientDTO);    //saving client details
	
	public List<Client>displayAllClients();                 //displaying the list of all client details
	
	Client getClientById(Integer id);                      //getting the required client by id
	
	public String deleteClientById(Integer id);             //delete client details by id
	
	public String deleteAllClients();                        //delete all the client details
	
	public String updateClientById(Integer id, ClientDTO params);//updating the client details by id
	

}
