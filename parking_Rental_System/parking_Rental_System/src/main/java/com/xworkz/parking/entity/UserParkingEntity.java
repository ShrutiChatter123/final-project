package com.xworkz.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.parking.constants.ParkingConstants;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "userparkinginfotable")
public class UserParkingEntity extends ParkingConstants {

	@Id
	private int userId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingid;

	private String location;

	private String vehicaltype;

	private String vehicalClassifications;

	private String terms;

	private String vehicalNumber;

	private String price;

	private String discount;

	private int total;
	
}
