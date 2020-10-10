package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long>{

//	List<Session> findByinstructorId(Long searchText);
	
	@Query("from Session s WHERE s.instructorId= :searchText OR s.instructorName= :searchText ORDER BY s.day")
	List <Session> searchQuery (@Param("searchText") String instructorId);
	
	@Query("from Session s ORDER BY s.day")
	List <Session> findAll ();
	
}
