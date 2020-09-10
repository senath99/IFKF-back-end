package com.ITP.IFKFbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITP.IFKFbackend.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{
	
}
