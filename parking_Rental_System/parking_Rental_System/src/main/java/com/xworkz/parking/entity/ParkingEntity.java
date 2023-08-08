package com.xworkz.parking.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.parking.associate.Associates;
import com.xworkz.parking.constants.ParkingConstants;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@Table(name = "parkingrentalsystem")
@NamedQuery(name = "findByEmail", query = "select form from ParkingEntity as form where form.email=:km")
public class ParkingEntity extends ParkingConstants{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private String name;

	private String email;

	private String password;

	private LocalDateTime loginTime;

	
	public ParkingEntity() {
		log.info("created:" + getClass().getSimpleName());
	}

}
