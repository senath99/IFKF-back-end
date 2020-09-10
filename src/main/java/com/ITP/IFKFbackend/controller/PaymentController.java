package com.ITP.IFKFbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.PaymentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class PaymentController {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@GetMapping("/payments")
	public List<Payment> getAllStudents(){
		return paymentRepository.findAll();
	}
	
	@PostMapping("/payments")
	public Payment createStudent(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	
	@GetMapping("/payments/{paymentId}")

	ResponseEntity<?> getPayments(@PathVariable Long paymentId){
	
		Optional<Payment> payments = paymentRepository.findById(paymentId);
		
		return payments.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
	
	@PutMapping("/payments/{paymentId}")
	public ResponseEntity<Payment> updateEquipment(
			@PathVariable Long paymentId, @RequestBody Payment payment){
		

		Payment result = paymentRepository.save(payment);
		
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}

}
