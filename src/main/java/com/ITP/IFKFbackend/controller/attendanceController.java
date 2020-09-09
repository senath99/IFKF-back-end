package com.ITP.IFKFbackend.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.repository.attendanceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class attendanceController {

	@Autowired
	private attendanceRepository AttendanceRepository;
	
	@GetMapping("/monthlyAttendance")
	 Collection<Attendance> getAttendance(){
		return AttendanceRepository.findAll();
	}
}
