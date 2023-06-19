package com.xworkz.form.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDTO implements Serializable, Comparable<ContactDTO> {


	@NotNull
	@Size(min = 4, max = 20, message = "name between 4 to 20")
	private String name;

	@Email(message = "enter your valid email")
	private String email;

	private long mobileNo;

	private String fileName;
	
	private String contentType;
	
	private long fileSize;

	@Override
	public int compareTo(ContactDTO o) {
		return this.getName().compareTo(o.getName());
	}

}
