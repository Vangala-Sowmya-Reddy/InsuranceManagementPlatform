package com.insurancemgmnt.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="Claim")
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Claim_Id")
	int id;
	@Column(name="Claim_Number")
	int claimNum;
	@Column(name="Description")
	String description;
	@Column(name="Claim_date")
	String claimDate;
	@Column(name="Claim_Status")
	String claimStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="InsurancePolicy_Id")
	public InsurancePolicy insurancePolicy;
	
}
