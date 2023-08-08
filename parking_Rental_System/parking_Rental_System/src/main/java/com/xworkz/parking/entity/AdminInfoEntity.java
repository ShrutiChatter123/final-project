package com.xworkz.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Table(name = "adminupdatetable")
@NamedQuery(name = "findByLocation",query = "select save from AdminInfoEntity as save where save.location=:nm")
@NamedQuery(name = "findByAll",query = "select aa from AdminInfoEntity aa where aa.location=:loc and aa.vehicaltype=:vtype and aa.vehicalClassifications=:Vcls and aa.terms=:ts")
public class AdminInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;
	private String vehicaltype;
	private String vehicalClassifications;
	private String terms;
	private String price;
	private String discount;
	
	
}
