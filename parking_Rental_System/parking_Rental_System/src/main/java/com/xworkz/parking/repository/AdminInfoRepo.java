package com.xworkz.parking.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.parking.entity.AdminInfoEntity;

public interface AdminInfoRepo {

	boolean save(AdminInfoEntity entity);
	
	default List<AdminInfoEntity>findBylocation(String location){
		return Collections.emptyList();
			
	}
	
	AdminInfoEntity findByLocationVtypeVclassificationTerms(String location,String vehicaltype,String vehicalClassifications,String terms);
	
	
}
