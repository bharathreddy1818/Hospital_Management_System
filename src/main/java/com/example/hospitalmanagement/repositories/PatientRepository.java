package com.example.hospitalmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hospitalmanagement.entities.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
	
	
	
}
