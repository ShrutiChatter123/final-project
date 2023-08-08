package com.xworkz.parking.service;

import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.dto.UserinfoDTO;

public interface UserInfoService {

	boolean validateAndSave(UserinfoDTO dto, UserParkingInfoDTO dt1);

	boolean isUserExist(String email);
	

}
