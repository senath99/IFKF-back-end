package com.ITP.IFKFbackend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="equipment")
public class Equipment {
	
	@Id
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Donation_seq")                                                                   
//    @GenericGenerator(
//		        name = "Donation_seq", 
//		        strategy = "com.ITP.IFKFbackend.UniqueIDgenerator.StringPrefixedSequenceIdGenerator", 
//		        parameters = {
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "D"),
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	private Long id;
	
	private String type;
	
	private String brand;
	
	private String supplier;
	
	private int quantity;
	

	


	

}
