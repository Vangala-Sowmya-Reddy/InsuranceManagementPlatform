package com.insurancemgmnt.service;

import java.util.List;
import com.insurancemgmnt.dtos.InsurancePolicyDTO;
import com.insurancemgmnt.entities.InsurancePolicy;

public interface InsurancePolicyService {
	InsurancePolicy saveInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO);    //saving insurancePolicy details
	
	public List<InsurancePolicy>displayAllInsurancePolicies();                 //displaying the list of all insurancePolicies details
	
	 InsurancePolicy getInsurancePolicyById(Integer id);                      //getting the required insurancePolicy by id
	
	public String deleteInsurancePolicyById(Integer id);             //delete insurancePolicy details by id
	
	public String deleteAllInsurancePolicies();                        //delete all the insurancePolicies details
	
	public String updateInsurancePolicyById(Integer id, InsurancePolicyDTO params);//updating the insurancePolicy details by id
	
}
