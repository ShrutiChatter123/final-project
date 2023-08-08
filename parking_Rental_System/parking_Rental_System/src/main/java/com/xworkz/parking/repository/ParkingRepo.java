package com.xworkz.parking.repository;

import com.xworkz.parking.entity.ParkingEntity;

public interface ParkingRepo {

	default boolean updateLoginTime(ParkingEntity entity) {
		return false;
	}
		
	default ParkingEntity findByEmail(String email) {
		return null;
	}
}
