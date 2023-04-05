package com.insurancemgmnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancemgmnt.dtos.InsurancePolicyDTO;
import com.insurancemgmnt.entities.InsurancePolicy;
import com.insurancemgmnt.repositories.InsurancePolicyRepository;
import com.insurancemgmnt.service.InsurancePolicyService;
@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	@Autowired
    InsurancePolicyRepository insurancePolicyRepository ;
	
	@Override
	public InsurancePolicy saveInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO) {
		InsurancePolicy insurancePolicy=InsurancePolicy.builder()
				.policyNum(insurancePolicyDTO.getPolicyNum())
				.type(insurancePolicyDTO.getType())
				.coverageAmount(insurancePolicyDTO.getCoverageAmount())
				.premium(insurancePolicyDTO.getPremium())
				.startDate(insurancePolicyDTO.getStartDate())
				.endDate(insurancePolicyDTO.getEndDate())
				.client(insurancePolicyDTO.getClient())
				.build();
		return  insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public List<InsurancePolicy> displayAllInsurancePolicies() {
		return insurancePolicyRepository.findAll();
	}
	
	@Override
	public String updateInsurancePolicyById(Integer id, InsurancePolicyDTO params) {
		InsurancePolicy insurancePolicy=insurancePolicyRepository.findById(id).get();
		insurancePolicy.setPolicyNum(params.getPolicyNum());
		insurancePolicy.setType(params.getType());
		insurancePolicy.setCoverageAmount(params.getCoverageAmount());
		insurancePolicy.setStartDate(params.getStartDate());
		insurancePolicy.setEndDate(params.getEndDate());
		insurancePolicyRepository.save(insurancePolicy);
		
		return null;
	}
	
	@Override
	public InsurancePolicy getInsurancePolicyById(Integer id) {
		return insurancePolicyRepository.findById(id).get();
	}

	@Override
	public String deleteInsurancePolicyById(Integer id) {
		insurancePolicyRepository.deleteById(id);
		return "The insurance policy details of id: "+ id+" are deleted";	
	}
	
	@Override
	public String deleteAllInsurancePolicies() {
		insurancePolicyRepository.deleteAll();
		return "All insurance policies records are deleted successfully";
	}

	

}
