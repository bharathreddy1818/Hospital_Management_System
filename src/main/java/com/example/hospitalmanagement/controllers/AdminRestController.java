package com.example.hospitalmanagement.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagement.entities.AdminEntity;
import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.repositories.AdminRepository;
import com.example.hospitalmanagement.services.AdminService;

@RestController
@RequestMapping("/admin")
class AdminRestController{
	
		@Autowired
	    private AdminService adminService;
	    @Autowired
	    private AdminRepository adminRepo;
	
	  @GetMapping("/{username}")
    public AdminEntity getAdminByUsername(@PathVariable String username) {
        return adminService.getAdminByUsername(username);
    }
	  
	  @GetMapping("/count")
	    public Map<String, Long> getCounts() {
	        return adminService.getCounts();
	    }
	  
	  @GetMapping("/displayDoctors")
	    public List<DoctorEntity> getAllDoctors() {
	        return adminService.getAllDoctors();
	    }
	  
	  @GetMapping("/editDoctor/{doctor_id}")
	    public List<DoctorEntity> editDoctor(@PathVariable int doctor_id){
			return adminService.editDoctorDetails(doctor_id);
		  
	  }
	    
}