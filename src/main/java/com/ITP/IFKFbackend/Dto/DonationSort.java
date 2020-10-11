package com.ITP.IFKFbackend.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonationSort {
	
	
	private Long sessionId;
	private Long quantity;
	private Long id;
	private String type;
}
