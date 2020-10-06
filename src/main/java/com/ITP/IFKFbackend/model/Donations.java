package com.ITP.IFKFbackend.model;


import java.util.Date;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="donations")
public class Donations {
	
	
	@Id
	@GeneratedValue
	private Long donateID;
	private Date donateDate;
	private String quantity;
	
	
	@ManyToOne 
	private Equipment equipment;
	
	
	@ManyToOne 
	private Sessions sessions;


	

	


	
	
}



	
	


