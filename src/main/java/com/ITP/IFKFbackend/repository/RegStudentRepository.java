package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.RegStudent;
//import com.ITP.IFKFbackend.model.unregStudent;

@Repository
public interface RegStudentRepository extends JpaRepository<RegStudent, Long>{
	
	List<RegStudent> findBykyu(String kyu);
	
	@Query("From RegStudent rs Where rs.name LIKE %:name%")
	List<RegStudent> searchByName(@Param("name") String name);
}