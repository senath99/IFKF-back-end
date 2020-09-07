package com.ITP.IFKFbackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.model.User;
import com.ITP.IFKFbackend.repository.LoginRepository;

@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;
	

	public LoginController(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}
	
	@GetMapping("/login/{id}")
	ResponseEntity<?> getDonations(@PathVariable Long id){
	
		Optional<User> user = loginRepository.findById(id);
		
		return user.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
}
