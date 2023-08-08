package com.xworkz.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.parking.dto.AdminInfoDTO;
import com.xworkz.parking.service.AdminInfoService;
import com.xworkz.parking.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableWebMvc
@RequestMapping("/")
public class UserAjaxController {

	@Autowired
	private UserInfoService service;
	
	@Autowired
	private AdminInfoService service1;

	@GetMapping(value = "/validateFields/{location}/{vehicaltype}/{vehicalClassifications}/{terms}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateFields(@PathVariable String location, @PathVariable String vehicaltype,
			@PathVariable String vehicalClassifications, @PathVariable String terms, Model model) {
		log.info("Running validateFields method in controler sucessfully ");
		AdminInfoDTO dto = this.service1.isExist(location, vehicaltype, vehicalClassifications, terms);
		System.out.println(dto);
		if (dto != null) {
			return "data already exist";
		}

		return " ";
	}

	@GetMapping(value = "/getpriceDiscount/{location}/{vehicaltype}/{vehicalClassifications}/{terms}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminInfoDTO getpriceDiscount(@PathVariable String location, @PathVariable String vehicaltype,
			@PathVariable String vehicalClassifications, @PathVariable String terms, Model model) {
		log.info("Excecuting getpriceDiscount in ajaxcontroller");
		log.info("location:"+ location);
		log.info("vehicaltype:"+ vehicaltype);
		log.info("vehicalClassifications:"+ vehicalClassifications);
		log.info("terms:"+ terms);
		log.info("Running getpriceDiscount in controller sucessfully");
		AdminInfoDTO dto = this. service1.isExist(location, vehicaltype, vehicalClassifications, terms);
		System.out.println(dto);
		if (dto != null) {
			return dto;
		}
		return null;
	}

	@GetMapping(value = "/validateEmailForOpt/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateEmailForOpt(@PathVariable String email) {
		log.info("Running validateEmailForOpt method ");
		boolean exist = service.isUserExist(email);
		if (exist) {
			return "Email already exist please login";
		}
		return " ";
	}

}
