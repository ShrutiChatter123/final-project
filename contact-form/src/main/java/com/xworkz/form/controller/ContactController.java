package com.xworkz.form.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xworkz.form.constants.ContactConstants;
import com.xworkz.form.dto.ContactDTO;
import com.xworkz.form.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebMvc
@Slf4j
@RequestMapping("/")
public class ContactController implements WebMvcConfigurer {

	Set<ContactDTO> dtos=new TreeSet<>();
	
	@Autowired
	private ContactService service;
	
	
	public ContactController() {
		System.out.println("Running"+getClass().getSimpleName());
	}
	
	@PostMapping("/form")
	public String onClick(@Valid ContactDTO dto,BindingResult bindingResult,Model model, MultipartFile file ) throws IOException {
		log.info("onClick method running Sucessfully..");

		
		if(bindingResult.hasErrors()) {
			System.out.println("data is invalid");
			List<ObjectError> error=bindingResult.getAllErrors();
			error.forEach(s->System.out.println(s.getDefaultMessage()));
			model.addAttribute("errors", error);
			model.addAttribute("dtos", dto);
		
		}else {
			this.dtos.add(dto);
			model.addAttribute("msg", dto.getName()+" Contact form Sended Sucessfully");

			log.info("file.getFile"+file.getName());
			log.info("file.size"+file.getSize());
			log.info("file.contentType"+file.getContentType());
			log.info("file.bytes"+file.getBytes());
			log.info("data is valid"+dto);
					
			dto.setFileName(file.getOriginalFilename()+System.currentTimeMillis());
			dto.setContentType(file.getContentType());
			dto.setFileSize(file.getSize());
			
			service.ValidateAndSave(dto);
			
//			this portion is for image upload
			File physicalFile=new File(ContactConstants.FILE_LOCATION+dto.getFileName());
			try(OutputStream os=new FileOutputStream(physicalFile)){
				os.write(file.getBytes());
			}

		}
		
		
		return "/Form.jsp";
	}
	
//	this portion of code is for displaying image
	@GetMapping("/fileDownload")
	public void displayImage(String FileName,String contentType, HttpServletResponse response) throws IOException {
		log.info("displayImage running in controller");
		File file=new File(ContactConstants.FILE_LOCATION +FileName);
		response.setContentType(contentType);
		OutputStream outputStream=response.getOutputStream();
		FileInputStream fileInputStream=new FileInputStream(file);
		byte[] buffer=new byte[4096];
		int length;
		
		while ((length=fileInputStream.read(buffer))>0) {
			outputStream.write(buffer, 0, length);
		}
		fileInputStream.close();
		outputStream.flush();
		
	}
	
	
	
	
	@GetMapping("/search")
	public String onSearch(String name, Model model) {
		log.info("Running onSearch method in controller..");
	List<ContactDTO>list=	service.findByName(name);
	model.addAttribute("list", list);
		return "/Search.jsp";
		
		
		
	}
	@GetMapping("/list")
	public String table(Model model) {
		log.info("table method running in controller");
		model.addAttribute("dtos", this.dtos);
		return "/TableDisplay.jsp";
	
	}
	
	

	
	
	
	
	
	
	
}
