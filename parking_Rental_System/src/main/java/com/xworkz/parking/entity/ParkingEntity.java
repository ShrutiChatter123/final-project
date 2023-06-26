package com.xworkz.parking.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.parking.associate.Associates;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@Table(name = "parkingrentalsystem")
@NamedQuery(name = "findByEmail", query = "select form from ParkingEntity as form where form.email=:km")
public class ParkingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private String name;

	private String email;

	private String password;

	private LocalDateTime loginTime;

	private String updatedBy;

	private String createdBy;

	private String createdDate;

	private String updatedDate;


	public ParkingEntity() {
		log.info("created:" + getClass().getSimpleName());
	}

}
