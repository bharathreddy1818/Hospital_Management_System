package com.example.hospitalmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagement.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	UserEntity findByEmail(String email);

}
