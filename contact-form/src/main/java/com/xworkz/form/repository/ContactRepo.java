package com.xworkz.form.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.form.contactEntity.ContactEntity;

public interface ContactRepo {

	boolean save(ContactEntity entity);
	
	default List<ContactEntity> findByName(String name){
		return Collections.emptyList();
		
	}
}



