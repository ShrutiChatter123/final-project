package com.xworkz.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.service.ParkingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestMapping("/")
public class ParkingController {

	@Autowired
	private ParkingService parkingService;

	public ParkingController() {
		log.info("const" + getClass().getSimpleName());
	}

	@PostMapping("/admin")
	public String onClick(ParkingDTO dto, Model model, HttpServletRequest req) {
		log.info("onClick method running sucessfully");
		if(dto!=null ) {
			this.parkingService.validate(dto);
			HttpSession session=req.getSession(true);
			session.setAttribute("dto1", dto);
//			model.addAttribute("name", dto.getCreatedBy());
//			model.addAttribute("loginTime", dto.getLoginTime());
			return "/AdminInfo.jsp";
		
		}
			
		model.addAttribute("error", "invalid information please enter correct details");
		return "/Admin.jsp";
				
		
		
	}
	
	
		
	
	
	
}
