package com.ITP.IFKFbackend.controller;

import java.net.URI;
import java.util.List;

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

import com.ITP.IFKFbackend.model.GradingExaminations;
import com.ITP.IFKFbackend.repository.GradingExaminationsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GradingExaminationsController {
	
	@Autowired
	private GradingExaminationsRepository gradingExaminationRepository;
	
	//get all examinatons data related to a particular student
		@GetMapping("/exams/all")
		public List<GradingExaminations> getAllExams(){
			return gradingExaminationRepository.findAll();
			//return rankingsService.findAll();
		}
		
		//find exam by id
		@GetMapping("/exams/{examCode}")
		public GradingExaminations getExam(@PathVariable String examCode){
			return gradingExaminationRepository.findById(examCode).get();
		}
		
		//delete a exam recode 
		@DeleteMapping("/exams/{examCode}")
		public ResponseEntity<Void> deleteExam(@PathVariable String examCode){
			
			gradingExaminationRepository.deleteById(examCode);
			return ResponseEntity.noContent().build();
			
		}
		
		
		@PutMapping("/exams")
		public ResponseEntity<GradingExaminations> updateExam(@RequestBody GradingExaminations exam){
			
			GradingExaminations examUpdated = gradingExaminationRepository.save(exam);
			return new ResponseEntity<GradingExaminations>(exam, HttpStatus.OK);
		}
		
		
		@PostMapping("/exams")
		public ResponseEntity<Void> createExam(@RequestBody GradingExaminations exam){
			GradingExaminations createdExam = gradingExaminationRepository.save(exam);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{examCode}").buildAndExpand(createdExam.getExamCode()).toUri();
			
			return ResponseEntity.created(uri).build(); 
		}

}
