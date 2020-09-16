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
import com.ITP.IFKFbackend.model.Equipment;
import com.ITP.IFKFbackend.repository.EquipmentRepository;



@RestController
@RequestMapping("/IFKF")
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {
	
	@Autowired
	private EquipmentRepository equipmentRepository;

	public EquipmentController(EquipmentRepository equipmentRepository) {
		super();
		this.equipmentRepository = equipmentRepository;
	}
	
	
	
	@GetMapping("/equipment")
	Collection<Equipment> equipment()
	{
		return equipmentRepository.findAll();
		
	}
	
	@GetMapping("/equipment/{id}")
	ResponseEntity<?> getEquipment(@PathVariable Long id){
	
		Optional<Equipment> equipment = equipmentRepository.findById(id);
		
		return equipment.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
	@PostMapping("/equipment")
	ResponseEntity<Equipment> createEquipment( @RequestBody Equipment equipment)throws URISyntaxException{
		  Equipment result=  equipmentRepository.save(equipment);
		  return ResponseEntity.created(new URI("/IFKF/equipment" + result.getId())).body(result); 
		
		}
	

	
	@PutMapping("/equipment/{id}")
	public ResponseEntity<Equipment> updateEquipment(
			@PathVariable Long id, @RequestBody Equipment equipment){
		

		Equipment result = equipmentRepository.save(equipment);
		
		return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
	}
	

	@DeleteMapping("/equipment/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable Long id){
	equipmentRepository.deleteById(id);
	return ResponseEntity.ok().build();
	}
	
	
	
	@GetMapping("/searchs/{searchText}")
	public List<Equipment> searchEquip(@PathVariable String searchText){
		
		return equipmentRepository.searchEquip(searchText);
	}


}
