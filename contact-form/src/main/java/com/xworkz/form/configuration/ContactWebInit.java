package com.xworkz.form.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.form.constants.ContactConstants;

public class ContactWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Excecuting getRootConfigClasses method in webinit ");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Excecuting getServletConfigClasses method in webinit ");
		return new Class[] {ContactConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Excecuting getServletMappings method in webinit ");
		return new String [] {"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		int maxSize=ContactConstants.MAXSIZE;
		MultipartConfigElement multipartConfigElement=new MultipartConfigElement(ContactConstants.TEMP_FILE_LOCATION,maxSize,maxSize*2,maxSize/2);
		registration.setMultipartConfig(multipartConfigElement);
	}
	

	
	
	
	
	
	
	
}
