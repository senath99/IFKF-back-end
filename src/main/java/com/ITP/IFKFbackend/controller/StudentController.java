package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
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

import com.ITP.IFKFbackend.model.Student;


import com.ITP.IFKFbackend.repository.StudentRepository;

import com.ITP.IFKFbackend.service.StudentDetailsReport;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDetailsReport reportservice;
	


	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
		
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	
	
	@GetMapping("/students/{studentId}")
	public Optional<Student> getStudent(@PathVariable String studentId) {
		return studentRepository.findById(studentId);
//	ResponseEntity<?> getStudents(@PathVariable String studentId){
//		Optional<Student> students = studentRepository.findById(studentId);
//		return students.map(response -> ResponseEntity.ok().body(response))
//				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/students/id")
	public Student getStudentId(){
		return studentRepository.findTopByOrderByStudentIdDesc();
	}
	
	
	
	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> updateStudent(
			@PathVariable String studentId, @RequestBody Student student){
		

		Student result = studentRepository.save(student);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{studentId}")
	ResponseEntity<?> deleteStudents(@PathVariable String studentId){
		studentRepository.deleteById(studentId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/students/search/{searchText}")
	public List<Student> searchStudent(@PathVariable  String searchText){
		return studentRepository.searchQuery(searchText);
	}
	
	@GetMapping("/report/{sessionId}")
	
	public String getReport(@PathVariable  String sessionId)  throws FileNotFoundException, JRException{
		return reportservice.getReport(sessionId);
	}
	
	
}
