package com.ITP.IFKFbackend.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)


@Table(name = "Operator")
public class Operator extends User  {

	
	
	 
	 private String fname;
	 
	 private String lname;
}
