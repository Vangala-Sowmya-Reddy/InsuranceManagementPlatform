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

import com.insurancemgmnt.dtos.InsurancePolicyDTO;
import com.insurancemgmnt.entities.InsurancePolicy;
import com.insurancemgmnt.exceptions.InsurancePolicyNotFoundException;
import com.insurancemgmnt.service.InsurancePolicyService;

import jakarta.validation.Valid;
@RestController
public class InsuranceController {
	@Autowired
	InsurancePolicyService insurancePolicyService;

	//For posting InsurancePolicy details

			@PostMapping("/policy")
			public ResponseEntity<InsurancePolicy> addInsurancePolicy(@RequestBody @Valid  InsurancePolicyDTO insurancePolicyDTO){
				try
				{
					InsurancePolicy insurancePolicy = insurancePolicyService.saveInsurancePolicy(insurancePolicyDTO);
					 if(insurancePolicy!=null) {
							return new ResponseEntity<InsurancePolicy>(insurancePolicy,HttpStatus.CREATED);
						}
				}
				catch(Exception ex)
				{
					throw new InsurancePolicyNotFoundException("InsurancePolicy data is not inserted!Please enter valid details");
				}
				return new ResponseEntity<InsurancePolicy>(HttpStatus.BAD_REQUEST);
			}
			
			//getting client details by Its id
			
			@GetMapping(path="/insurancePolicy/{id}")
			public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable("id") Integer id)
			{
				try {
					InsurancePolicy insurancePolicy = insurancePolicyService.getInsurancePolicyById(id);
					if(insurancePolicy!=null) {
						return new ResponseEntity<InsurancePolicy>(insurancePolicy,HttpStatus.FOUND);
					}
				}
				catch(Exception e)
				{
					throw new InsurancePolicyNotFoundException("No such insurance policy with id " + id + " found");
				}
				 return new ResponseEntity<InsurancePolicy>(HttpStatus.NOT_FOUND);
				
			}
			
	//Getting all insurance policies details
	
	@GetMapping(path="/allInsurancePolicies")
	public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicies()
	{
		try
		{
		 List<InsurancePolicy> insurancePoliciesList=insurancePolicyService.displayAllInsurancePolicies();
		 if(insurancePoliciesList!=null)
			return new ResponseEntity<List<InsurancePolicy>>(insurancePoliciesList,HttpStatus.FOUND);
		}
		catch(Exception e)
		{
			throw new InsurancePolicyNotFoundException("No Such insurance policy Exist");
		}
		return new ResponseEntity<List<InsurancePolicy>>(HttpStatus.NOT_FOUND);
	}
	
	//updating insurance policy details based on id
	
	@PutMapping(path="/updateInsurancePolicy/{id}")
	public ResponseEntity<String> updateInsurancePolicyById(@PathVariable("id") Integer id, @RequestBody @Valid InsurancePolicyDTO insurancePolicyDTO)
	{
		try
		{
		 String insurancePolicy=insurancePolicyService.updateInsurancePolicyById(id, insurancePolicyDTO);
		 if(insurancePolicy!=null)
			return new ResponseEntity<String>(insurancePolicy,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			throw new InsurancePolicyNotFoundException("Unable to update Insurance Policy details");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);		
	}
	
	
	//Deleting insurance policy details by its Id
	@DeleteMapping(path="/deleteInsurancePolicyById/{id}")
	public ResponseEntity<String> deleteInsurancePolicyById(@PathVariable("id") Integer id)
	{
		try 
		{
		 String insurancePolicy=insurancePolicyService.deleteInsurancePolicyById(id);
		 if(insurancePolicy!=null)
			return new ResponseEntity<String>(insurancePolicy,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			throw new InsurancePolicyNotFoundException("Unable to delete insurance policy details");
		}
		return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
	}
	
	//Deleting all insurance policies details
		@DeleteMapping(path="/deleteAllInsurancePoliciesdetails")
		public ResponseEntity<String> deleteAllInsurancePolicies()
		{
			try
			{
			 String insurancePolicy=insurancePolicyService.deleteAllInsurancePolicies();
			 if(insurancePolicy!=null)
				return new ResponseEntity<String>(insurancePolicy,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new InsurancePolicyNotFoundException("Unable to delete insurance policies details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
		}	
	
	//End Of code
}
