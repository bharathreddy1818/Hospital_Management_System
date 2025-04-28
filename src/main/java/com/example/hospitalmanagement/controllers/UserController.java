package com.example.hospitalmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospitalmanagement.entities.UserEntity;
import com.example.hospitalmanagement.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	private boolean checkCredentials(String username, String password) {
        UserEntity admin = userRepository.findByEmail(username);

        return admin != null && admin.getPassword().equals(password);
    }

    @RequestMapping("/userCheck")
    public String login(@RequestParam("useremail") String username,
                        @RequestParam("password") String password,
                        Model model) {

        if (checkCredentials(username, password)) {
            return "userhome"; 
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "userlogin";
        }
    }
}
