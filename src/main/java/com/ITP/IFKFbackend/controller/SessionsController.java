package com.ITP.IFKFbackend.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.model.Sessions;
import com.ITP.IFKFbackend.repository.DonationsRepository;
import com.ITP.IFKFbackend.repository.EquipmentRepository;
import com.ITP.IFKFbackend.repository.SessionsRepository;

@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")

	
public class SessionsController {
	

	@Autowired
	private SessionsRepository sessionsRepository;
	

	
	@GetMapping("/sessions")
	Collection<Sessions> sessions()
	{
		return sessionsRepository.findAll();
		
		 
		
	}

}
