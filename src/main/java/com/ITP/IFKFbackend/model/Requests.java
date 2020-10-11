package com.ITP.IFKFbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="Requests")
public class Requests {
	

	@Id
	@GeneratedValue
	private Long id;
	
	private String type;
	
	private int quantity;
	
	private Date requestDate;
	
	private String Description;
	
	private String status;
	
	@ManyToOne 
	private Instructor instructor;

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@ManyToOne 
	private Session sessions;
	
}
