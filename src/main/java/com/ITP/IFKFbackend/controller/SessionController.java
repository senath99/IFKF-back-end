package com.ITP.IFKFbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ITP.IFKFbackend.model.Session;
import com.ITP.IFKFbackend.repository.SessionRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;

	//get all sessions
	@GetMapping("/sessions")
	public List<Session> getAllSessions(){
		return sessionRepository.findAll();
	}
	
	//get session by id
	@GetMapping("/sessions/{sessionId}")
	public Optional<Session> getSession(@PathVariable Long sessionId){
		return sessionRepository.findById(sessionId);
	}
	
	
	@PostMapping("/sessions")
	public ResponseEntity<Void> createSession(@RequestBody Session session){
		Session created = sessionRepository.save(session);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sessionId}").buildAndExpand(created.getSessionId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	
	@PutMapping("/sessions")
	public ResponseEntity<Session> updateRank(@RequestBody Session session){
		
		Session sessionUpdated = sessionRepository.save(session);
		return new ResponseEntity<Session>(session, HttpStatus.OK);
	}
	
	@DeleteMapping("/sessions/{sessionId}")
	public ResponseEntity<Void> deleteSession(@PathVariable Long sessionId){
		
		sessionRepository.deleteById(sessionId);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
