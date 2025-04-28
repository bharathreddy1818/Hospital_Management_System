package com.example.hospitalmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.entities.UserEntity;
import com.example.hospitalmanagement.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(UserEntity userEntity) {
		
		userRepository.save(userEntity);
	}
	
	}
