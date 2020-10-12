package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Instructor;
import com.ITP.IFKFbackend.model.Student;


@Repository 
public interface InstructorRepository extends JpaRepository<Instructor,String> {
	
	public Instructor findTopByOrderByInstructorIdDesc();
	
	List<Student> findByname(String searchText);
	 
	 @Query("from Instructor i WHERE i.name = :searchText ORDER BY i.instructorId")
	 List <Instructor> searchQuery (@Param("searchText") String name); 

}
