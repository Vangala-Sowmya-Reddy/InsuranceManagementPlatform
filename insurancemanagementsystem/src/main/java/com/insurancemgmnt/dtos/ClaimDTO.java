package com.insurancemgmnt.dtos;
import com.insurancemgmnt.entities.InsurancePolicy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaimDTO {

	@NotNull(message="Claim number should not be Null")
	int claimNum;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	String description;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	String claimDate;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	String claimStatus;
	
	public InsurancePolicy insurancePolicy;
	}
	
	

