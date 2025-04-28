package com.example.hospitalmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.repositories.DoctorRepository;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	 @RequestMapping("/doctorCheck")
	    public String login(@RequestParam("email") String username,
	                        @RequestParam("password") String password,
	                        Model model) {

	        if (checkCredentials(username, password)) {
	            return "doctorhome"; 
	        } else {
	            // Add error message if credentials are invalid
	            model.addAttribute("message", "Invalid username or password.");
	            return "doctorlogin";
	        }
	    }

	private boolean checkCredentials(String username, String password) {
		DoctorEntity doctor = doctorRepository.findByEmail(username);

        return  doctor != null && doctor.getPassword().equals(password);
	}
}
