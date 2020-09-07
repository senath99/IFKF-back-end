package com.ITP.IFKFbackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Login;
import com.ITP.IFKFbackend.repository.LoginRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	@GetMapping("/login/{userId}")
	public Optional<Login> getUser(@PathVariable String userId){
		return loginRepository.findById(userId);
	}
	

}
