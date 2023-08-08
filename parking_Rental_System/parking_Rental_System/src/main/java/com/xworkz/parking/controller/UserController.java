package com.xworkz.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.dto.UserinfoDTO;
import com.xworkz.parking.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserInfoService service1;

	public UserController() {
		log.info(getClass().getSimpleName());
	}
	
	
	@PostMapping("/user")
	public String onController(UserinfoDTO dto1, UserParkingInfoDTO dto2, Model model) {
		log.info("onController method running in controller***");
		System.out.println(dto1);
		System.out.println(dto2);
		boolean save=service1.validateAndSave(dto1, dto2);

		if(save) {
			
			model.addAttribute("parkinginfoSucess", "data added sucessfully");
		}else {
			
			
			model.addAttribute("parkingInfoError", "no data added");
		}
		return "UserSignUp.jsp";
		

	}

}
