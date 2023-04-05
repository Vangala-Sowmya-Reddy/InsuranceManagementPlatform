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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Insurance_Policy")
public class InsurancePolicy {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Policy_Id")
int id;
@Column(name="Policy_Number")
int policyNum;
@Column(name="Policy_Type")
String type;
@Column(name="Coverage_Amount")
double coverageAmount;
@Column(name="Premium")
String premium;
@Column(name="Start_date")
String startDate;
@Column(name="End_date")
String endDate;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="Client_Id")
public Client client;
}
