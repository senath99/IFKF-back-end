package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Instructor;
import com.ITP.IFKFbackend.model.Student;


@Repository 
public interface InstructorRepository extends JpaRepository<Instructor,String> {
	
	public Instructor findTopByOrderByInstructorIdDesc();


}
