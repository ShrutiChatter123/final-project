package com.xworkz.parking.repository;

import com.xworkz.parking.entity.UserParkingEntity;
import com.xworkz.parking.entity.UserinfoEntity;

public interface UserInfoRepository {

	boolean save(UserinfoEntity entity1);
	
	boolean userParkingsave(UserParkingEntity entity2);
	
	UserinfoEntity findByEmail(String email);
	
	
	
	
	
}
