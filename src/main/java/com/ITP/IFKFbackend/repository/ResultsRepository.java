package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
	
	List<Results> findBystudentId(String studentId);
	List<Results> findByexamCode(String examCode);

}
