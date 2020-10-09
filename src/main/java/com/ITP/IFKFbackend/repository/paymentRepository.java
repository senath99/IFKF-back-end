package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITP.IFKFbackend.model.Payment;

@Repository
public interface paymentRepository extends JpaRepository<Payment, Long>{
	
	Payment findBystudentID(String studentID);

}
