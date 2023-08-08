package com.xworkz.parking.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parking.dto.ParkingDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestMapping("/")
public class DefaultController {

	
	public DefaultController() {	
		log.info(" running DefaultController ******");
		}
		
		@RequestMapping("/default")
		public String controller( Model model) {
			log.info("controller method running in default controller ****");
		
			return "/Parking.jsp";
		}
	
	
	
}
