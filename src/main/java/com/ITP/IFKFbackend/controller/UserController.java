package com.ITP.IFKFbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ITP.IFKFbackend.model.User;
import com.ITP.IFKFbackend.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/IFKF") //  <-
//NOTE!!! URLS HAVE BEEN CHANGED ,REMEMBER TO CHANGE TO MAKE THE FRONTEND WORK....

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/addusers")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	@PostMapping("/addusers")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	
	@GetMapping("/login/{userId}")

	ResponseEntity<?> getUsers(@PathVariable Long userId){
	
		Optional<User> users = userRepository.findById(userId);
		
		return users.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
	
	@PutMapping("/addusers/{userId}")
	public ResponseEntity<User> updateEquipment(
			@PathVariable Long userId, @RequestBody User user){
		

		User result = userRepository.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
	@GetMapping("/findmax")
	public User getUserID() {
		
		return userRepository.findTopByOrderByUserIdDesc();
	}
}
