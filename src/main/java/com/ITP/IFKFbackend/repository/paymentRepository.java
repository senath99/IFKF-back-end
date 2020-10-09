package com.ITP.IFKFbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Payment;

@Repository
public interface paymentRepository extends JpaRepository<Payment, Long>{
	
	List<Payment> findBystudentID(String studentID);
	
	@Query("From Payment p WHERE p.studentID= :searchText ORDER BY p.studentID DESC")
	List<Payment> searchQuery(@Param("searchText") String studentID);


}
