package com.example.hospitalmanagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hospitalmanagement.entities.AdminEntity;
import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.models.AdminModel;
import com.example.hospitalmanagement.repositories.AdminRepository;
import com.example.hospitalmanagement.services.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepo;
    

    private boolean checkCredentials(String username, String password) {
        AdminModel admin = adminRepo.findByUsername(username);

        return admin != null && admin.getPassword().equals(password);
    }

    @RequestMapping("/AdminCheck")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        if (checkCredentials(username, password)) {
            return "adminhome"; 
        } else {
            // Add error message if credentials are invalid
            model.addAttribute("message", "Invalid username or password.");
            return "adminlogin";
        }
    }


    @PostMapping("/add")
    public void addAdmin(@RequestBody AdminEntity adminEntity) {
        adminService.addAdmin(adminEntity);
    }


    @PutMapping("/{username}")
    public void updateAdminPassword(@PathVariable String username,@RequestBody String newPassword) {
       adminService.updateAdminPassword(username, newPassword); 
    }

    @DeleteMapping("/{username}")
    public void deleteAdmin(@PathVariable String username) {
        adminService.deleteAdmin(username);
    }
    
    @PostMapping("/register")
    public String register(DoctorEntity doctorEntity) {
		 adminService.register(doctorEntity);
		 return "adminhome";
    	
    }
    
    @DeleteMapping("/deleteDoctor/{doctor_id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctor_id) {
        try {
            adminService.deleteDoctor(doctor_id);
            return ResponseEntity.ok("Doctor deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting doctor: " + e.getMessage());
        }
    }
    
    @PostMapping("/updateDoctor")
    public String updateDoctor(DoctorEntity doctorEntity) {
		 adminService.updateDoctor(doctorEntity);
		 return "viewDoctors";
    	
    }
    
    
}

