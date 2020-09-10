package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,Long>{

	 
}
