package com.xworkz.parking.service;

import com.xworkz.parking.dto.UserinfoDTO;
import com.xworkz.parking.entity.UserinfoEntity;

public interface UserOtpService {

	public boolean validateAndSave(UserinfoDTO dto);

	public String userSignIn(String email , UserinfoEntity entity);

	
	public boolean otpSendMail(String emailId , UserinfoEntity   entity);

}
