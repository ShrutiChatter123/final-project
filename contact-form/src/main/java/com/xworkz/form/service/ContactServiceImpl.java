package com.xworkz.form.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.form.contactEntity.ContactEntity;
import com.xworkz.form.dto.ContactDTO;
import com.xworkz.form.repository.ContactRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo repo;

	public ContactServiceImpl() {
		log.info("running" + getClass().getSimpleName());
	}

	@Override
	public boolean ValidateAndSave(ContactDTO dto) {
		log.info("validateAndSave method in serviceimpl");
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(dto, entity);
		log.info("entity is:" + entity);

		return this.repo.save(entity);
	}

	@Override
	public List<ContactDTO> findByName(String name) {
		log.info("Running findByName");
		List<ContactEntity> entities = this.repo.findByName(name);
		List<ContactDTO> dtos = entities.stream().map(ent -> {
			ContactDTO contactDTO = new ContactDTO();
			BeanUtils.copyProperties(ent, contactDTO);
			return contactDTO;
		}).collect(Collectors.toList());

		return dtos;
	}

}
