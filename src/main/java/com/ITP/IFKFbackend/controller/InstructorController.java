package com.ITP.IFKFbackend.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Instructor;
import com.ITP.IFKFbackend.repository.InstructorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class InstructorController {
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors(){
		return instructorRepository.findAll();
	}
	
	@PostMapping("/instructors")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	
	
	@GetMapping("/instructors/{instructorId}")

	ResponseEntity<?> getInstructors(@PathVariable String instructorId){
	
		Optional<Instructor> instructors = instructorRepository.findById(instructorId);
		
		return instructors.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
	
	@PutMapping("/instructors/{instructorId}")
	public ResponseEntity<Instructor> updateInstructor(
			@PathVariable Long instructorId, @RequestBody Instructor instructor){
		

		Instructor result = instructorRepository.save(instructor);
		
		return new ResponseEntity<Instructor>(instructor, HttpStatus.OK);
	}
	
	@DeleteMapping("/instructors/{instructorId}")
	ResponseEntity<?> deleteInstructors(@PathVariable String instructorId){
		instructorRepository.deleteById(instructorId);
		return ResponseEntity.noContent().build();
	}
	
}
