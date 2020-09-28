package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.GradingExaminations;

@Repository
public interface GradingExaminationsRepository extends JpaRepository<GradingExaminations, String> {
	
	@Query("from GradingExaminations g WHERE g.examCode LIKE %:searchText% OR g.description LIKE %:searchText% ORDER BY g.date")
	List<GradingExaminations> searchQuery(@Param("searchText") String searchText);

}
 