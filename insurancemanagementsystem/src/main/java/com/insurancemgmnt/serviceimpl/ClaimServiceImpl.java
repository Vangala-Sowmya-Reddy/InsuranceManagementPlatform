package com.insurancemgmnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancemgmnt.dtos.ClaimDTO;
import com.insurancemgmnt.entities.Claim;
import com.insurancemgmnt.repositories.ClaimRepository;
import com.insurancemgmnt.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {
	@Autowired
    ClaimRepository claimRepository;
	@Override
	public Claim saveClaim(ClaimDTO claimDTO) {
		Claim claim=Claim.builder()
				.claimNum(claimDTO.getClaimNum())
				.description(claimDTO.getDescription())
				.claimDate(claimDTO.getClaimDate())
				.claimStatus(claimDTO.getClaimStatus())
				.insurancePolicy(claimDTO.getInsurancePolicy())
				.build();
		return  claimRepository.save(claim);
	}
	
	@Override
	public Claim getClaimById(Integer id) {
		return claimRepository.findById(id).get();
	}
	@Override
	public String updateClaimById(Integer id, ClaimDTO params) {
		Claim claim=claimRepository.findById(id).get();
		claim.setClaimNum(params.getClaimNum());
		claim.setDescription(params.getDescription());
		claim.setClaimDate(params.getClaimDate());
		claim.setClaimStatus(params.getClaimStatus());
		claimRepository.save(claim);
		return "claim details are updated successfully";
		
	}
	@Override
	public List<Claim> displayAllClaims() {
		return claimRepository.findAll();
	}

	@Override
	public String deleteClaimById(Integer id) {
		claimRepository.deleteById(id);
		return "The claim details of id: "+ id+" are deleted";	
	}

	@Override
	public String deleteAllClaims() {
		claimRepository.deleteAll();
		return "All claim records are deleted successfully";
	}

	

}
