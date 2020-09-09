package com.ITP.IFKFbackend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.paymentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class paymentController {
	
	@Autowired
	private paymentRepository PaymentRepository;
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return PaymentRepository.findAll();
	}
	
	
	
	@PostMapping("/payments/insert")
	public ResponseEntity<Void> insertPayment(@RequestBody Payment payment){
		Payment created = PaymentRepository.save(payment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getPaymentID()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	

}
