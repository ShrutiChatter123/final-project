package com.xworkz.parking.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserinfoDTO {

	private int userId;
	
	private String name;
	
	private String email;
	
	private long mobile;
	
	private String updatedBy;

	private String createdBy;

	private String createdDate;

	private String updatedDate;
	
	private String emailOTP;
	
	private Date otpRequestedTime;
	
	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
	
	
	
	
}
