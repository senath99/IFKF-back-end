package com.ITP.IFKFbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

@Entity

@Table(name = "operator")
@EqualsAndHashCode(callSuper=true)

public class Operator extends User {
	
	@Column(name = "name")
	 private String name;
	
	@Column(name = "email")
	 private String email;
	
	public Operator() {}

	public Operator(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
