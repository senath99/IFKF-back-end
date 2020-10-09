package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
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

import com.ITP.IFKFbackend.model.Results;
import com.ITP.IFKFbackend.repository.ResultsRepository;
import com.ITP.IFKFbackend.service.PerfomanceReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResultsController {
	
	@Autowired
	private ResultsRepository resultsRepository;
	
	@Autowired
	private PerfomanceReportService reportService;
	
		//get all results data related to a particular student
		@GetMapping("/results/all/{studentId}")
		public List<Results> getAllResults(@PathVariable String studentId){
			return resultsRepository.findBystudentId(studentId);
			//return rankingsService.findAll();
		}
		
		//get all results data related to a particular exam
		@GetMapping("/results/exam/{examCode}")
		public List<Results> getAllResultsOfExam(@PathVariable String examCode){
			return resultsRepository.findByexamCode(examCode);
			//return rankingsService.findAll();
		}
		
		//find result by id
		@GetMapping("/results/{id}")
		public Results getResult(@PathVariable long id){
			return resultsRepository.findById(id).get();
		}
		
		//delete a result record
		@DeleteMapping("/results/{resultsId}")
		public ResponseEntity<Void> deleteResult(@PathVariable long resultsId){
			
			resultsRepository.deleteById(resultsId);
			return ResponseEntity.noContent().build();
			
		}
		
		
		@PutMapping("/results")
		public ResponseEntity<Results> updateResult(@RequestBody Results result){
			
			Results resultUpdated = resultsRepository.save(result);
			return new ResponseEntity<Results>(result, HttpStatus.OK);
		}
		
		
		@PostMapping("/results")
		public ResponseEntity<Void> createResult(@RequestBody Results result){
			Results createdResult = resultsRepository.save(result);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{resultId}").buildAndExpand(createdResult.getResultsId()).toUri();
			
			return ResponseEntity.created(uri).build(); 
		}
		
		
		@GetMapping("/results/report/{studentId}")
		public String getResultsReport(@PathVariable String studentId) throws FileNotFoundException, JRException {
			return reportService.getResultsReport(studentId);
		}
		
		
		@GetMapping("/results/examreport/{examCode}")
		public String getExamReport(@PathVariable String examCode) throws FileNotFoundException, JRException {
			return reportService.getExamReport(examCode);
		}
		


}
