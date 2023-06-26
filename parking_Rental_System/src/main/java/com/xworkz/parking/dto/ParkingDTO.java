package com.xworkz.parking.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingDTO {

	private String name;
	
	private String email;

	private String password;

	private LocalDateTime loginTime;
	
	private String createdBy;

	
	
	

}
