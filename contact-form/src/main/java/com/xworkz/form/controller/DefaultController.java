package com.xworkz.form.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.form.dto.ContactDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestMapping("/")
public class DefaultController {

	public DefaultController() {	
	log.info(" running DefaultController");
	}
	
	@RequestMapping("/default")
	public String controller(Model model) {
		log.info("controller method running in default controller");
		model.addAttribute("dto", new ContactDTO());
		return "Form.jsp";
	}
	
	
	
	
	
	
}
