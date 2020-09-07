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
	private Long id;
	
	private String Type;
	
	private String Brand;
	
	private String supplier;
	
	private int quantity;
	
//	
//	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	    @JoinColumn(name= "equipment_id")
//	    private Set<Donations> donations;

//	
//	 @OneToMany (cascade =CascadeType.ALL,mappedBy="equipment",fetch = FetchType.EAGER)
//	
//	 private List<Donations> donations = new ArrayList<Donations>();
//	
	 
	 
//	@OneToMany(targetEntity =  Donations.class, mappedBy = "equipment", cascade = CascadeType.ALL)
//    private <Donations> donations;

//	
//	@OneToMany(mappedBy = "equipment")
//     private List<Donations> donations = new ArrayList<Donations>();

	
	

//	 @JsonManagedReference
//	public List<Donations> getDonations() {
//		return donations;
//	}
//
//
//
//	public void setDonations(List<Donations> donations) {
//		this.donations = donations;
//	}


//   
//	public List<Donations> getDonations() {
//		return donations;
//	}
//
//
//
//	public void setDonations(List<Donations> donations) {
//		this.donations = donations;
//	}



	


	

}
