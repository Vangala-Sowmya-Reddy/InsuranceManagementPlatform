package com.insurancemgmnt.service;

import java.util.List;

import com.insurancemgmnt.dtos.ClaimDTO;
import com.insurancemgmnt.entities.Claim;

public interface ClaimService {
    Claim saveClaim(ClaimDTO claimDTO);    //saving claim details
	
	public List<Claim>displayAllClaims();                 //displaying the list of all claim details
	
	Claim getClaimById(Integer id);                      //getting the required claim  by id
	
	public String deleteClaimById(Integer id);             //delete claim details by id
	
	public String deleteAllClaims();                        //delete all the claim details
	
	public String updateClaimById(Integer id, ClaimDTO params);            //updating the claim details by id
	
	
}
