package com.example.hospitalmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {
	
	 private Long patientId;
	    private String name;
	    private int age;
	    private String gender;
	    private String email;
	    private String phone;
	    private String address;
	    private String user;
	    private String status;

	    
	    
}
