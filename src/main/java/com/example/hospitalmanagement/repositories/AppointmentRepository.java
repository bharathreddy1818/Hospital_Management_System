package com.example.hospitalmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hospitalmanagement.entities.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{
	
    

}
