package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
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
