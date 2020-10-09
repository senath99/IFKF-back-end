package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.model.Student;


public interface AttendanceRepository extends JpaRepository<Attendance,Long>{
	
	Attendance findBystuId(String stuId);
	

}
