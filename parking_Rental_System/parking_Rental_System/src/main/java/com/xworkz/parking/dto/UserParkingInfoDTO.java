package com.xworkz.parking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserParkingInfoDTO {

	private int userId;
	
	private int parkingid;
	
	private String location;
	
	private String vehicaltype;
	
	private String vehicalClassifications;

	private String terms;
		
	private String price;

	private String discount;

	private int total;

	private String updatedBy;

	private String createdBy;

	private String createdDate;

	private String updatedDate;
	
	private String vehicalNumber;
	
	
	
	
}
