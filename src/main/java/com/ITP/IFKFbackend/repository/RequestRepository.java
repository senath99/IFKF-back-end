package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.model.Requests;


public interface RequestRepository extends JpaRepository<Requests, Long> {

	
	

	
	@Query(" from Requests r JOIN r.instructor i where  i.instructorId = :inID" )
	public List<Requests> getRequestsByID(@Param("inID") String id);
		
	@Query("from Requests r  JOIN r.instructor i where  r.status LIKE %:searchText% OR r.Description LIKE  %:searchText% OR i.name LIKE  %:searchText% OR r.type LIKE  %:searchText%" )
	List<Requests> searchQuery(@Param("searchText") String searchText);
	
//	@Query("SELECT r.id,r.type,r.quantity,r.requestDate,r.Description,r.status"
//			+ "From Requests r JOIN r.instructor i")
//	public List getRequestsByID();
}
