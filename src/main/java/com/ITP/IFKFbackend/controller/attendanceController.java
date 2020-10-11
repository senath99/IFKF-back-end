package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.model.Student;
import com.ITP.IFKFbackend.repository.attendanceRepository;
import com.ITP.IFKFbackend.service.AttendanceReport;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class attendanceController {

	@Autowired
	private attendanceRepository AttendanceRepository;
	
	@Autowired
	private AttendanceReport service;
	
	@GetMapping("/monthlyAttendance")
	 public List<Attendance> getAttendance(){
		return AttendanceRepository.findAll();
	}
//	
//	@GetMapping("/monthlyAttendance/{studentId}")
//	public List<Attendance> getAttendance(@PathVariable String studentId){
//		return AttendanceRepository.findByattendanceID(studentId);
//	}
	
	@PutMapping("/attendance/{Id}")
	public ResponseEntity<Attendance> updateAttendance(
			@PathVariable Long Id, @RequestBody Attendance att){
		

		Attendance result = AttendanceRepository.save(att);
		
		return new ResponseEntity<Attendance>(att, HttpStatus.OK);
	}
	
	@PostMapping("/attendance")
	public Attendance createStudent(@RequestBody Attendance att) {
		
		return AttendanceRepository.save(att);
	}
	
	
	@GetMapping("/attendanceBystu/{Id}")
	 public Attendance getAttendanceByStu(@PathVariable String Id){
		return AttendanceRepository.findByStuId(Id);
	}

	@GetMapping("/attendance/report")
	public String getReport() throws FileNotFoundException, JRException {
		return service.exportReport();
	}
	
}

}

