package com.ITP.IFKFbackend.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data


@Table(name = "Instructor") 
public class Instructor  {

	
	 @Id
	 private Long ID; 
	
	 private String fname;
	 
	 private String lname;
	 


	


	
}
