package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Rankings;

@Repository
public interface RankingsRepository extends JpaRepository<Rankings, Long>{
	
	List<Rankings> findBystudentId(String studentId);

}
