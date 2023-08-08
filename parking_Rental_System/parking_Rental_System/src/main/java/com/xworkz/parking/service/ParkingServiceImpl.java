package com.xworkz.parking.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.email.Email;
import com.xworkz.parking.entity.ParkingEntity;
import com.xworkz.parking.repository.ParkingRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	private ParkingRepo repo;

	@Override
	public ParkingDTO validate(ParkingDTO dto) {
		ParkingEntity entity = this.repo.findByEmail(dto.getEmail());
		if (entity.getEmail().equals(dto.getEmail()) && entity.getPassword().equals(dto.getPassword())) {
			log.info("comparing referance with dto sucess");
			LocalDateTime localDateTime = LocalDateTime.now();
			localDateTime = localDateTime.withSecond(0).withNano(0);
			entity.setLoginTime(localDateTime);
			this.repo.updateLoginTime(entity);
			Email.senMail(entity.getEmail(), entity.getPassword());
			BeanUtils.copyProperties(entity, dto);
			return dto;

		}
		return null;
	}

}
