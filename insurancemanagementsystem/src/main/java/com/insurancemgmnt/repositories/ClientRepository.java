package com.insurancemgmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemgmnt.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
