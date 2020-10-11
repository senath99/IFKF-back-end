package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Attendance;



public interface attendanceRepository extends JpaRepository<Attendance, Long>{
	
	
	Attendance findByStuId(String stuID);

}
