package com.example.hospitalmanagement.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.entities.AdminEntity;
import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.repositories.AdminRepository;
import com.example.hospitalmanagement.repositories.AppointmentRepository;
import com.example.hospitalmanagement.repositories.DoctorRepository;
import com.example.hospitalmanagement.repositories.PatientRepository;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private DoctorRepository doctorRepository;
   
    public void addAdmin(AdminEntity adminEntity) {
        adminRepository.save(adminEntity);
    }

    public AdminEntity getAdminByUsername(String username) {
        return adminRepository.findById(username).orElse(null);
    }

    public void updateAdminPassword(String username, String newPassword) {
        AdminEntity admin = adminRepository.findById(username).orElse(null);
        if (admin != null) {
            admin.setPassword(newPassword);
            adminRepository.save(admin);
        }
    }

    public void deleteAdmin(String username) {
        if (adminRepository.existsById(username)) {
            adminRepository.deleteById(username);
        }
    }
    
    public Map<String, Long> getCounts() {
        Map<String, Long> counts = new HashMap<>();

        // Fetch counts using JPA queries
        counts.put("doctors", adminRepository.getDoctorsCount());
        counts.put("patients", adminRepository.getPatientsCount());
        counts.put("appointments", adminRepository.getAppointmentsCount());
        counts.put("specialists", adminRepository.getSpecialistsCount());

        return counts;
    }

	public void register(DoctorEntity doctorEntity) {
		 
		doctorRepository.save(doctorEntity);
		
	}

	public List<DoctorEntity> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	public void deleteDoctor(int doctor_id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(doctor_id);
	}

	public List<DoctorEntity> editDoctorDetails(int doctor_id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctor_id)
	            .map(Collections::singletonList) // Wrap in a list if found
	            .orElse(Collections.emptyList());	}

	public void updateDoctor(DoctorEntity doctorEntity) {
		
		Optional<DoctorEntity> existingDoctorOptional = doctorRepository.findById(doctorEntity.getDoctor_id());
        
        if (existingDoctorOptional.isPresent()) {
            DoctorEntity existingDoctor = existingDoctorOptional.get();
		if (doctorEntity.getPassword() == null) {
			doctorEntity.setPassword(existingDoctor.getPassword());
		}
		}
    	 doctorRepository.save(doctorEntity);

	}
}
