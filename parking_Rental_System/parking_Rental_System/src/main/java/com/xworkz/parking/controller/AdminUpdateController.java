package com.xworkz.parking.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.parking.dto.AdminInfoDTO;
import com.xworkz.parking.service.AdminInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Component
@EnableWebMvc
@Slf4j
public class AdminUpdateController {

	Collection<AdminInfoDTO> list = new ArrayList<>();

	@Autowired
	private AdminInfoService service;

	@PostMapping("/update")
	public String okSave(AdminInfoDTO dto, Model model) {
		log.info("okSave method running in admininfoController");
		if (dto != null) {
			log.info("data is correct");
			boolean status = this.service.validateAndSave(dto);
			if (status) {
				model.addAttribute("sucess", "Information send sucessfullyy..");
				return "/AdminUpdate.jsp";

			} else {
				model.addAttribute("error", "data is already exist");
				return "/AdminUpdate.jsp";
			}

		} else {
			model.addAttribute("dtoError", "Please enter the data");
			log.info("data is null");
			return "/AdminUpdate.jsp";
		}

	}

	@GetMapping("/search")
	public String onSearch(String location, Model model) {
		log.info("onSearch method running in controller");
		List<AdminInfoDTO> list = service.findBylocation(location);
		model.addAttribute("list", list);
		return "/Search.jsp";

	}

}
