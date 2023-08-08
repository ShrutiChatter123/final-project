package com.xworkz.parking.repository;

import com.xworkz.parking.entity.UserinfoEntity;

public interface UserOtpRepo {

	public boolean save(UserinfoEntity entity);
	
	public  UserinfoEntity findByUserEmail(String email);
	
	public boolean userSignInUpdate(String emailOTP, String email);

}
