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
	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Donation_seq")                                                                   
//    @GenericGenerator(
//		        name = "Donation_seq", 
//		        strategy = "com.ITP.IFKFbackend.UniqueIDgenerator.StringPrefixedSequenceIdGenerator", 
//		        parameters = {
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "D"),
//		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	@Id
	@GeneratedValue
	private Long donateID;
	private Date donateDate;
	private String quantity;
	
	@ManyToOne 
	private Equipment equipment;


	public String getDonateID1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDonateID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@ManyToOne 
	private Session sessions;


	
	
}



	
	


