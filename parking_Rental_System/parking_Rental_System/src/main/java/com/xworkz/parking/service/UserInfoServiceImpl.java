package com.xworkz.parking.service;

import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.dto.UserinfoDTO;
import com.xworkz.parking.entity.UserParkingEntity;
import com.xworkz.parking.entity.UserinfoEntity;
import com.xworkz.parking.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository repo;

	public UserInfoServiceImpl() {
		log.info("Excecuting UserInfoServiceImpl in serviceimpl");
	}

	@Override
	public boolean validateAndSave(UserinfoDTO dto, UserParkingInfoDTO dto1) {
		log.info("Running validateAndSave method sucessfully ");
		System.err.println(dto);
		System.err.println(dto1);
		UserinfoEntity record = this.repo.findByEmail(dto.getEmail());
		System.out.println("Record "+record);
		System.out.println("Entity is not null before if condition");
		if (record == null) {
			System.out.println("Entity is not null after if condition");
			System.out.println("Record "+record);
			UserinfoEntity userentity = new UserinfoEntity();
			BeanUtils.copyProperties(dto, userentity);
			boolean save = this.repo.save(userentity);

			if (save) {
				UserParkingEntity userparkingEntity = new UserParkingEntity();
				UserinfoEntity userEntity = this.repo.findByEmail(dto.getEmail());
				dto1.setUserId(userEntity.getUserId());
//				update name part
				BeanUtils.copyProperties(dto1, userparkingEntity);
				userparkingEntity.setCreatedBy(dto.getName());
				userparkingEntity.setCreatedDate(LocalDateTime.now());
				userparkingEntity.setUpdatedDate(LocalDateTime.now());
				userparkingEntity.setUpdatedBy(dto.getName());
				log.info("Entity is :" + userentity);
				this.repo.userParkingsave(userparkingEntity);
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean isUserExist(String email) {
		log.info("Running isExist in serviceimpl ");
		UserinfoEntity entity = this.repo.findByEmail(email);
		if (entity != null) {
			return true;
		}
		return false;
	}
}
