package com.insurancemgmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemgmnt.entities.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
