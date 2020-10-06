package com.ITP.IFKFbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "operator")


public class Operator  {
	
	@Id
	private Long  operatortId;
    private String name;
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
