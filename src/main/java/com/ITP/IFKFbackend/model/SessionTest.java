package com.ITP.IFKFbackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name= "session")
public class SessionTest {
	
	@Id
	private Long Sessionid;
	
	@JsonIgnore
	@OneToMany(mappedBy="session",targetEntity = Equipment.class, cascade = CascadeType.ALL)
	
	private List<Equipment> equipment;
	
	
	

}
