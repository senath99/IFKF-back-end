package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import com.ITP.IFKFbackend.model.unregStudent;
import com.ITP.IFKFbackend.repository.UnregStudentRepository;
//import com.Service.ReportService;

//import net.sf.jasperreports.engine.JRException;


@RestController
@CrossOrigin(origins = "*")
public class unregStudentController {

	@Autowired
	private UnregStudentRepository unregStudentRepository;
	
	@Autowired
//	private ReportService reportService;
	
	@GetMapping("/unregStudent")
	public List<unregStudent> getAllunregStudents(){
		return unregStudentRepository.findAll();
	}
	
//	@GetMapping("/report/{format}")
//	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//		return reportService.getUnregStudentReport(format);
//	}
	
	@GetMapping("/unregStudent/{id}")
	public unregStudent getUnregStudents(@PathVariable Long id){
		return unregStudentRepository.findById(id).get();
	}
	
	
	@PostMapping("/unregStudent/insert")
	public ResponseEntity<Void> creatUnregStudent( @RequestBody unregStudent unregstudent){
		
		unregStudent result = unregStudentRepository.save(unregstudent);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}

	@PutMapping("/unregStudent")
	public ResponseEntity<unregStudent> updateStudent( @RequestBody unregStudent UnregStudent){
		

		unregStudent result = unregStudentRepository.save(UnregStudent);
		
		return new ResponseEntity<unregStudent>(UnregStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/unregStudent/{id}")
	ResponseEntity<?> deleteEnrollment(@PathVariable Long id){
		unregStudentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	//unregStudent filtering and searching part start from here
	@GetMapping("/unregStudent/filterKyu/{kyu}")
	public List<unregStudent> filterStudentByKyu(@PathVariable String kyu){
		return unregStudentRepository.findBykyu(kyu);
	}
	
	@GetMapping("/unregStudent/searchStudent/{name}")
	public List<unregStudent> searchStudentByName(@PathVariable String name){
		return unregStudentRepository.searchByName(name);
	}
	
}
