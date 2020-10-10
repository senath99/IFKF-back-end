package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ITP.IFKFbackend.model.GradingExaminations;
import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.paymentRepository;
import com.ITP.IFKFbackend.service.PaymentReport;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class paymentController {
	
	@Autowired
	private paymentRepository PaymentRepository;
	
	@Autowired
	private PaymentReport service;
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return PaymentRepository.findAll();
	}
	
	@GetMapping("/payments/{studentId}")
	public List<Payment> getPayments(@PathVariable String studentId){
		return PaymentRepository.findBystudentID(studentId);
	}

	@GetMapping("/payment/{Id}")
	public Optional<Payment> getPayment(@PathVariable long Id){
		return PaymentRepository.findById(Id);
	}
	
	
	@PostMapping("/payments/insert")
	public ResponseEntity<Void> insertPayment(@RequestBody Payment payment){
		Payment created = PaymentRepository.save(payment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getPaymentID()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	
	@DeleteMapping("/payments/{paymentID}")
	public ResponseEntity<?> deletePayment(@PathVariable Long paymentID){
		
		PaymentRepository.deleteById(paymentID);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@PutMapping("/payments")
	public ResponseEntity<Payment> updatePayments( @RequestBody Payment payment){
		
			Payment result = PaymentRepository.save(payment);
			return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
	
	@GetMapping("/payments/search/{searchText}")
	public List<Payment> searchPayment(@PathVariable String searchText){
		return PaymentRepository.searchQuery(searchText);
	}
	
	
	@GetMapping("/reports/{studentID}")
	public String exportReport(@PathVariable String studentID) throws FileNotFoundException, JRException {
		return service.exportReport(studentID);
	}

}
