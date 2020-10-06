package com.ITP.IFKFbackend.controller;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.repository.DonationsRepository;
import com.ITP.IFKFbackend.repository.EquipmentRepository;
import com.ITP.IFKFbackend.Service.DonationsReport;
import net.sf.jasperreports.engine.JRException;




@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationsController {
		
		@Autowired
		private DonationsRepository donationsRepository;
		@Autowired
		private DonationsReport reportservice;
		
	

		public DonationsController(DonationsRepository donationsRepository,EquipmentRepository equipmentRepository) {
			super();
			this.donationsRepository = donationsRepository;
			
			
		}
		
		
		
		@GetMapping("/donations")
		Collection<Donations> donations()
		{
			return donationsRepository.findAll();
			
			 
			
		}
		
		
		
		@GetMapping("/donations/{id}")
		ResponseEntity<?> getDonations(@PathVariable Long id){
		
			Optional<Donations> donations = donationsRepository.findById(id);
			
			return donations.map(response -> ResponseEntity.ok().body(response))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
			
			
		}
		
		
		@PostMapping("/donations")
		ResponseEntity<Donations> createDonations( @RequestBody Donations donations)throws URISyntaxException{
			  Donations result=  donationsRepository.save(donations);
			  return ResponseEntity.created(new URI("/IFKF/donations" + result.getDonateID())).body(result); 
		
			}
		

		
		@PutMapping("/donations/{id}")
		public ResponseEntity<Donations> updateDonations(
				@PathVariable Long id, @RequestBody Donations donations){
			

			Donations result = donationsRepository.save(donations);
			
			return new ResponseEntity<Donations>(donations, HttpStatus.OK);
		}
		
	
		@DeleteMapping("/donations/{id}")
		ResponseEntity<?> deleteDonations(@PathVariable Long id){
		donationsRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		
		
		@GetMapping("/search/{searchText}")
		public List<Donations> searchDonations(@PathVariable String searchText){
			return donationsRepository.searchQuery(searchText);
		}

		
//		@GetMapping("/Totalquantity")
//		public List<Donations>FindTotal(){
//			
//			
//			return donationsRepository.FindTotal();
//		}
		
		@GetMapping("/reports")
		public String getDonationsReport() throws FileNotFoundException, JRException {
			return reportservice.getReport();
		}
	}

	
	
	
	
	

