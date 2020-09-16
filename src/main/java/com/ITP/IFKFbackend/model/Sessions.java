
package com.ITP.IFKFbackend.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="sessions")
public class Sessions {
		
	
		@Id
		private Long id;
		
		
//		 @OneToMany (mappedBy="sessions") 
//		 private List<Donations> donations = new ArrayList<Donations>();
		 
		 
	
		
		
}
