package com.example.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	private int id;
	
	private String name;
	private String username;
	private String password;
	private int age;
	private String ssn;
	private String address;
	private String email;
	private String phone;
	private float balance;
	private boolean isadmin;

}
