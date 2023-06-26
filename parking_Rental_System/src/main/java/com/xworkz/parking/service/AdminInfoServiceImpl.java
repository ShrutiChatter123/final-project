package com.xworkz.parking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.parking.dto.AdminInfoDTO;
import com.xworkz.parking.entity.AdminInfoEntity;
import com.xworkz.parking.repository.AdminInfoRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminInfoServiceImpl implements AdminInfoService {

	@Autowired
	private AdminInfoRepo repo;

	public AdminInfoServiceImpl() {
		log.info("constrct" + getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(AdminInfoDTO dto) {
		log.info("Excecuting validateAndSave method");
		AdminInfoEntity entity = new AdminInfoEntity();
		BeanUtils.copyProperties(dto, entity);
		log.info("getting entity is" + entity);
		return this.repo.save(entity);
	}

	@Override
	public List<AdminInfoDTO> findBylocation(String location) {
		log.info("findBylocation  method running in serviceImpl ");
		List<AdminInfoEntity> entities = this.repo.findBylocation(location);
		List<AdminInfoDTO> dtos = entities.stream().map(ent -> {
			AdminInfoDTO adminInfoDTO = new AdminInfoDTO();
			BeanUtils.copyProperties(ent, adminInfoDTO);
			return adminInfoDTO;
		}).collect(Collectors.toList());
		return dtos;
	}

}
