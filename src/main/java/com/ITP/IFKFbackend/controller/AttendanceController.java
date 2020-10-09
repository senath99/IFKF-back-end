package com.ITP.IFKFbackend.controller;

import java.net.URI;
import java.net.URISyntaxException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.repository.AttendanceRepository;

@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {

	@Autowired
	AttendanceRepository attendanceRepository;

	public AttendanceController(AttendanceRepository attendanceRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
	}
	
	@GetMapping("/attendance/{ID}")
	public Attendance getStudentbysession(@PathVariable String ID){
	
			return attendanceRepository.findBystuId(ID);
		
	}
	
	
	@GetMapping("/attendance")
	public List<Attendance> getattendance(){
	
			return attendanceRepository.findAll();
		
	}
	
	
	@PostMapping("/attendance")
	ResponseEntity<Attendance> createAttendance( @RequestBody Attendance attendance)throws URISyntaxException{
		 Attendance result=  attendanceRepository.save(attendance);
		  return ResponseEntity.created(new URI("/IFKF/Attendance" + result.getAttendanceID())).body(result); 
	
		}
	

	
	@PutMapping("/attendance/{id}")
	public ResponseEntity<Attendance> updateAttendance(
			@PathVariable Long id, @RequestBody Attendance attendance){
		

		Attendance result = attendanceRepository.save(attendance);
		
		return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteAttendance")
		ResponseEntity<?> deleteAttendance(){
		attendanceRepository.deleteAll();;
		return ResponseEntity.ok().build();
	}
	
	
	
}
