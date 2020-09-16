package com.ITP.IFKFbackend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="donations")
public class Donations {
	
	
	@Id
	@GeneratedValue
	private Long Donate_ID;
	private Date Donate_Date;
	private String quantity;
	
	
	@ManyToOne 
	private Equipment equipment;
	
	
	@ManyToOne 
	private Sessions sessions;
  
	
	

	


	
	
}



	
	


