package com.xworkz.parking.constants;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class ParkingConstants {

	private String updatedBy;

	private String createdBy;

	private LocalDateTime createdDate = LocalDateTime.now();

	private LocalDateTime updatedDate = LocalDateTime.now();

}
