package com.insurancemgmnt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Client")
public class Client {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Client_Id")
int id;
@Column(name="Client_Name")
String name;
@Column(name="Date_of_Birth")
String dateOfBirth;
@Column(name="Address")
String address;
@Column(name="Mobile_Number")
String mobileNum;



}
