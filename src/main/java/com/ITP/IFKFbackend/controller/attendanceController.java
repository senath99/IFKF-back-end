package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.attendanceRepository;
import com.ITP.IFKFbackend.service.AttendanceReport;
import com.ITP.IFKFbackend.service.PaymentReport;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
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
	
	@GetMapping("/attendanceReports")
	public String exportReport() throws FileNotFoundException, JRException {
		return service.exportReport();
	}
	

//	@GetMapping("/attendance/search/{searchText}")
//	public List<Attendance> searchStudent(@PathVariable  String searchText){
//		return attendanceRepository.searchQuery(searchText);
//	}
	
}
