package com.ITP.IFKFbackend.model;

import javax.persistence.Entity;
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
@Table(name= "equipment")
public class Equipment {
	
	@Id
	private Long id;
	
	private String Type;
	
	private String Brand;
	
	private String supplier;
	
	private int quantity;
	
//	 @ManyToOne
//	 private SessionTest session;

}
