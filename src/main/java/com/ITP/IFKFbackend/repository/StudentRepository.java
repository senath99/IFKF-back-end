package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Rankings;
import com.ITP.IFKFbackend.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,String>{

	 
	List<Student> findBysession(String sesssionID);

	Student findTopByOrderByStudentIdDesc();
}
