package com.example.hospitalmanagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.hospitalmanagement.entities.UserEntity;
import com.example.hospitalmanagement.models.UserDto;
import com.example.hospitalmanagement.services.AdminService;
import com.example.hospitalmanagement.services.UserService;


@Controller
public class NavControllers {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    public String home() {
		System.out.println("hi");
        return "index";
    }
	
	@GetMapping("/adminlogin")
    public String adminLogin() {
        return "adminlogin"; 
    }
	
	@GetMapping("/adminlogout")
    public String adminLogout() {
    	return "index";
    }
	
	@GetMapping("/addDoctor")
    public String addDoctor() {
		return "addDoctor";
	}
	
	@GetMapping("/viewDoctors")
    public String viewDoctors() {
		return "viewDoctors";
	}
	
	@GetMapping("/home")
	public String adminHome() {
		return "adminhome";
	}
	
	@GetMapping("/eDoctor")
	public String editDoctor() {
		return "editDoctor";
	}
	
	
	@GetMapping("/doctorlogin")
	public String doctorLogin() {
		return "doctorlogin";
	}
	
	@GetMapping("/doctorlogout")
    public String doctorLogout() {
    	return "index";
    }
	
	@GetMapping("/userlogin")
	public String userLogin() {
		return "userlogin";
	}
	
	@GetMapping("/userlogout")
	public String userLogout() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signUp() {
		System.out.print("in signUp method");
		return "signUp";
	}
	
	
	@PostMapping(path="/usersignup", consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String userSignUp(UserDto userDto) {
		System.out.print("in userSignUp method");
	    UserEntity userEntity=new UserEntity();  
	    userEntity.setEmail(userDto.getEmail());
	    userEntity.setName(userDto.getName());
	    userEntity.setPassword(userDto.getPassword());
	    userService.addUser(userEntity);
		return "userlogin";
	}
}
