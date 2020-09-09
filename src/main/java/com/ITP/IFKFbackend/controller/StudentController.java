package com.ITP.IFKFbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.GradingExaminations;
import com.ITP.IFKFbackend.model.Student;
import com.ITP.IFKFbackend.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students/all")
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	//find exams by search query
	@GetMapping("/students/search/{searchText}")
	public List<Student> searchExams(@PathVariable String searchText){
		return studentRepository.searchQuery(searchText);
	}

}
