package com.example.hospitalmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
public class PatientEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

