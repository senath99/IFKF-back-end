package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Rankings;
import com.ITP.IFKFbackend.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,String>{

	 
	List<Student> findBySession(String sesssionID);


	 public Student findTopByOrderByStudentIdDesc();

	 @Query("from Student s WHERE s.studentId LIKE %:searchText% OR s.name LIKE %:searchText%")
	 List<Student> searchQuery(@Param("searchText") String searchText);
  
}
