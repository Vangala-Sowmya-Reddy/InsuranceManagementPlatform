package com.insurancemgmnt.dtos;
import com.insurancemgmnt.entities.Client;

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
public class InsurancePolicyDTO {
	@NotNull(message="Policy number should not be Null")
	int policyNum;
	
	@NotNull(message="Policy type should not be Null")
	String type;
	
	@NotNull(message="Coverage Amount should not be Null")
	double coverageAmount;
	
	@NotNull(message="Premium is required,it should not be Null")
	String premium;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	String startDate;

	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	String endDate;
	
	public  Client client;
	
}
