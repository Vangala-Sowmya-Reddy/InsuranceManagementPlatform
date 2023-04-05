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
import com.insurancemgmnt.dtos.ClaimDTO;
import com.insurancemgmnt.entities.Claim;
import com.insurancemgmnt.exceptions.ClaimNotFoundException;
import com.insurancemgmnt.service.ClaimService;
import jakarta.validation.Valid;

@RestController
public class ClaimController {
	@Autowired
	ClaimService claimService;

	//For posting claim details

			@PostMapping(path="/claim")
			public ResponseEntity<Claim> addClaim(@RequestBody @Valid  ClaimDTO claimDTO){
				try
				{
					Claim claim = claimService.saveClaim(claimDTO);
					 if(claim!=null) {
							return new ResponseEntity<Claim>(claim,HttpStatus.CREATED);
						}
				}
				catch(Exception ex)
				{
					throw new ClaimNotFoundException("Claim data is not inserted!Please enter valid client details");
				}
				return new ResponseEntity<Claim>(HttpStatus.BAD_REQUEST);
			}
			
			//getting claim details by Its id
			
			@GetMapping(path="/claim/{id}")
			public ResponseEntity<Claim> getClaimById(@PathVariable("id") Integer id)
			{
				try {
					Claim claim = claimService.getClaimById(id);
					if(claim!=null) {
						return new ResponseEntity<Claim>(claim,HttpStatus.FOUND);
					}
				}
				catch(Exception e)
				{
					throw new ClaimNotFoundException("No Such Claim with id " + id + " Found");
				}
				 return new ResponseEntity<Claim>(HttpStatus.NOT_FOUND);
				
			}
			
			//Getting all claims details
			
			@GetMapping(path="/allClaims")
			public ResponseEntity<List<Claim>> getAllClaims()
			{
				try
				{
				 List<Claim> claimList=claimService.displayAllClaims();
				 if(claimList!=null)
					return new ResponseEntity<List<Claim>>(claimList,HttpStatus.FOUND);
				}
				catch(Exception e)
				{
					throw new ClaimNotFoundException("No Such claim Exist");
				}
				return new ResponseEntity<List<Claim>>(HttpStatus.NOT_FOUND);
			}
			
			//updating claim details based on id
			
			@PutMapping(path="/updateClaim/{id}")
			public ResponseEntity<String> updateClaimById(@PathVariable("id") Integer id, @RequestBody @Valid ClaimDTO claimDTO)
			{
				try
				{
				 String claim=claimService.updateClaimById(id, claimDTO);
				 if(claim!=null)
					return new ResponseEntity<String>(claim,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new ClaimNotFoundException("Unable to update Claim details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);		
			}
			
			
			//Deleting claim details by its Id
			@DeleteMapping(path="/deleteClaimById/{id}")
			public ResponseEntity<String> deleteClaimById(@PathVariable("id") Integer id)
			{
				try 
				{
				 String claim=claimService.deleteClaimById(id);
				 if(claim!=null)
					return new ResponseEntity<String>(claim,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new ClaimNotFoundException("Unable to delete claim details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
			}
			
			//Deleting all claims details
				@DeleteMapping(path="/deleteAllClaimsdetails")
				public ResponseEntity<String> deleteAllClaims()
				{
					try
					{
					 String claim=claimService.deleteAllClaims();
					 if(claim!=null)
						return new ResponseEntity<String>(claim,HttpStatus.ACCEPTED);
					}
					catch(Exception e)
					{
						throw new ClaimNotFoundException("Unable to delete claims details");
					}
					return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
				}	
			
			//End Of code
	}


