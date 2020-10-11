package com.ITP.IFKFbackend.controller;

//import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ITP.IFKFbackend.model.RegStudent;
import com.ITP.IFKFbackend.model.unregStudent;
import com.ITP.IFKFbackend.repository.RegStudentRepository;
//import com.Service.RegStudentReportService;

import net.sf.jasperreports.engine.JRException;

@Component
@RestController
@CrossOrigin(origins = "*")
public class RegStudentController{
	
	@Autowired
	private RegStudentRepository regStudentRepository;
//	@Autowired(required=true)
//	private RegStudentReportService reportService;
	
	@GetMapping("/regStudent")
	public List<RegStudent> getAllRegisteredStudents(){
		return regStudentRepository.findAll();
	}
	
	@PostMapping("/regStudent/insert")
	public ResponseEntity<RegStudent> creatRegStudent( @RequestBody RegStudent regStudent){
		
		RegStudent result = regStudentRepository.save(regStudent);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getEnrollId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping("/regStudent/{id}")
	ResponseEntity<?> deleteRegStudent(@PathVariable Long id){
		regStudentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//unregStudent filtering and searching part start from here
	@GetMapping("/regStudent/filterKyu/{kyu}")
	public List<RegStudent> filterStudentByKyu(@PathVariable String kyu){
		return regStudentRepository.findBykyu(kyu);
	}
		
	@GetMapping("/regStudent/searchStudent/{name}")
	public List<RegStudent> searchStudentByName(@PathVariable String name){
		return regStudentRepository.searchByName(name);
	}
	
//	@GetMapping("/report/{format}")
//	public String generateReport (@PathVariable String format) throws FileNotFoundException, JRException {
//		return reportService.getRegStudentReport(format);
//	}
}