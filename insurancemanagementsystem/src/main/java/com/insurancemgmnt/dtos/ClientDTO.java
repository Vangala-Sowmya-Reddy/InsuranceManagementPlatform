package com.insurancemgmnt.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	@Size(min=4,max=30,message="Name must be in the range 4-30 characters")
	String name;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	@Size(min=5,max=20,message="Date of Birth must be in the range 4-20 characters")
	String dateOfBirth;
	
	@NotBlank(message="Emptiness is not allowed")
	@NotNull(message="Null is not allowed")
	@Size(min=2,max=20,message="Address must be in the range 2-40 characters")
	String address;
	
	@Pattern(regexp="\\d{10}",message="Invalid MobileNumber")
	String mobileNum;

	
}
