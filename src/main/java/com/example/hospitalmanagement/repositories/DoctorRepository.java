package com.example.hospitalmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.models.DoctorModel;
import java.util.List;



public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer>{
	
	DoctorEntity findByEmail(String email);
}