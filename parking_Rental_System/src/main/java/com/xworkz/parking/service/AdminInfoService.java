package com.xworkz.parking.service;

import java.util.Collections;
import java.util.List;

import com.xworkz.parking.dto.AdminInfoDTO;

public interface AdminInfoService {

	boolean validateAndSave(AdminInfoDTO dto);
	
	default List<AdminInfoDTO> findBylocation(String location){
		return Collections.emptyList();
		
	}

	
}
