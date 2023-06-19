package com.xworkz.form.contactEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="contact_project_table")
@NamedQuery(name = "findByName", query="select save from ContactEntity as save where save.name like :nm")
public class ContactEntity implements Serializable, Comparable<ContactEntity> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long mobileNo;
	private String fileName;
	private String contentType;
	private long fileSize;
	
	@Override
	public int compareTo(ContactEntity o) {
		return this.getName().compareTo(o.getName());
	}

}
