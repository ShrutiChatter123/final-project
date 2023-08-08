package com.xworkz.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.parking.dto.UserinfoDTO;
import com.xworkz.parking.entity.UserinfoEntity;
import com.xworkz.parking.service.UserOtpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class UserOtpController {

	@Autowired
	private UserOtpService service;

	@PostMapping("/send-otp")
	public String sendOtp(@RequestParam("email") String email, UserinfoEntity entity) {
		log.info("Running sendOtp method in UserOtpController");
		UserinfoDTO dto = new UserinfoDTO();
		if (dto != null) {
		//	this.service.otpSendMail(email, entity);
			this.service.userSignIn(email, entity);
			
		}
		return "UserSignIn.jsp";
		
	}
}
