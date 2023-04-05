package com.insurancemgmnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurancemgmnt.dtos.ClientDTO;
import com.insurancemgmnt.entities.Client;
import com.insurancemgmnt.repositories.ClientRepository;
import com.insurancemgmnt.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
 @Autowired
 ClientRepository clientRepository;
	@Override
	public Client saveClient(ClientDTO clientDTO) {
		Client client=Client.builder()
				.name(clientDTO.getName())
				.dateOfBirth(clientDTO.getDateOfBirth())
				.address(clientDTO.getAddress())
				.mobileNum(clientDTO.getMobileNum())
				.build();
		return clientRepository.save(client);
				
	}
	@Override
	public String updateClientById(Integer id, ClientDTO params) {
	    Client client=clientRepository.findById(id).get();
		client.setName(params.getName());
		client.setDateOfBirth(params.getDateOfBirth());
		client.setAddress(params.getAddress());
		client.setMobileNum(params.getMobileNum());
		clientRepository.save(client);
		return "company record is updated successfully";
	
	}

	@Override
	public List<Client> displayAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public String deleteClientById(Integer id) {
		clientRepository.deleteById(id);
		return "The client details of id: "+ id+" are deleted";	
	}

	@Override
	public String deleteAllClients() {
		clientRepository.deleteAll();
		return "All client records are deleted successfully";
	}
	}

	


