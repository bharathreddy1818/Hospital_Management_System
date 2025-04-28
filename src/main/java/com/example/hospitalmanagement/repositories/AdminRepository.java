package com.example.hospitalmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hospitalmanagement.entities.AdminEntity;
import com.example.hospitalmanagement.models.AdminModel;


public interface AdminRepository extends JpaRepository<AdminEntity, String>{

	AdminModel findByUsername(String username);
	@Query("SELECT COUNT(*) FROM DoctorEntity")
    Long getDoctorsCount();
	
   @Query("SELECT COUNT(d) FROM DoctorEntity d WHERE d.specialist != 'general'")
   Long getSpecialistsCount();
   
   @Query("SELECT COUNT(a) FROM AppointmentEntity a WHERE a.status = 'pending'")
   Long getAppointmentsCount();
   
   @Query("SELECT COUNT(p) FROM PatientEntity p WHERE p.status = 'pending'")
   Long getPatientsCount();
}