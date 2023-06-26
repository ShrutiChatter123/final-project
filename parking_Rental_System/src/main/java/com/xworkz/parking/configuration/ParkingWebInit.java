package com.xworkz.parking.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ParkingWebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Excecuting getRootConfigClasses method in parkingRentalSystem project");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Excecuting getServletConfigClasses method in parkingRentalSystem project");
		return new Class[] {ParkingConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Excecuting getServletMappings method in parkingRentalSystem project");
		return new String[] {"/"};
	}

	
	
	
	
	
	
}
