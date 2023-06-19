package com.xworkz.form.service;

import java.util.Collections;
import java.util.List;

import com.xworkz.form.dto.ContactDTO;

public interface ContactService {

	boolean ValidateAndSave(ContactDTO dto);
	
	default List<ContactDTO> findByName(String name){
		
		return Collections.emptyList();
		
	}
	
}
