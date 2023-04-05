package com.insurancemgmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemgmnt.entities.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Integer> {

}
