package com.ITP.IFKFbackend.controller;

import java.net.URI;
import java.util.List;

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

import com.ITP.IFKFbackend.model.Rankings;
import com.ITP.IFKFbackend.repository.RankingsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RankingsController {
	
//	@Autowired
//	private RankingsHardCodedService rankingsService;
	
	@Autowired
	private RankingsRepository rankingsRepository;
	
	//get all ranking data related to a particular student
	@GetMapping("/rankings/all/{studentId}")
	public List<Rankings> getAllRankings(@PathVariable String studentId){
		return rankingsRepository.findBystudentId(studentId);
		//return rankingsService.findAll();
	}
	
	//find rank by id
	@GetMapping("/rankings/{id}")
	public Rankings getRank(@PathVariable long id){
		return rankingsRepository.findById(id).get();
	}
	
	//delete a ranking recode 
	@DeleteMapping("/rankings/{rankingsId}")
	public ResponseEntity<Void> deleteRank(@PathVariable long rankingsId){
		
		rankingsRepository.deleteById(rankingsId);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@PutMapping("/rankings")
	public ResponseEntity<Rankings> updateRank(@RequestBody Rankings rank){
		
		Rankings rankUpdated = rankingsRepository.save(rank);
		return new ResponseEntity<Rankings>(rank, HttpStatus.OK);
	}
	
	
	@PostMapping("/rankings")
	public ResponseEntity<Void> createRank(@RequestBody Rankings rank){
		Rankings createdRank = rankingsRepository.save(rank);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdRank.getRankingsId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}

}
