package com.ITP.IFKFbackend.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ITP.IFKFbackend.model.Requests;
import com.ITP.IFKFbackend.repository.RequestRepository;


@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestController {
	
	
	@Autowired
	private RequestRepository requestRepository;
	

	
	@GetMapping("/requests")
	Collection<Requests> getRequests()
	{
		return requestRepository.findAll();
		
	}

	

	@GetMapping("/requests/{id}")
	ResponseEntity<?> getRequests(@PathVariable Long id){
	
		Optional<Requests> request = requestRepository.findById(id);
		
		return request.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
//	@PostMapping("/requests")
//	ResponseEntity<Requests> createEquipment( @RequestBody Requests requests)throws URISyntaxException{
//		  Requests result=  requestRepository.save(requests);
//		  return ResponseEntity.created(new URI("/IFKF/requests" + result.getId())).body(result); 
//		
//		}
	
//
//	
//	@GetMapping("/Myrequests/${userID}")
//	List<Requests> findByinstructor_user_id(Long userID)
//	{
//		return requestRepository.findByinstructorId(userID);
//		
//	}
//	
	@DeleteMapping("/requests/{id}")
	ResponseEntity<?> deleteRequests(@PathVariable Long id){
	requestRepository.deleteById(id);
	return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/requests/{id}")
	public ResponseEntity<Requests> updateDonations(
			@PathVariable Long id, @RequestBody Requests request){
		

		Requests result = requestRepository.save(request);
		
		return new ResponseEntity<Requests>(request, HttpStatus.OK);
	}
	

	@GetMapping("/Myrequests/{id}")
	public List<Requests> getRequestsByID(@PathVariable String id)
	{
		return requestRepository.getRequestsByID(id);
		
	}
	
	
	@GetMapping("/searchReq/{searchText}")
	public List<Requests> searchDonations(@PathVariable String searchText){
		return requestRepository.searchQuery(searchText);
	}

}
