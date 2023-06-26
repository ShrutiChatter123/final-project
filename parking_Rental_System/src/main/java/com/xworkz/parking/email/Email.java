package com.xworkz.parking.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class Email {

	public static  boolean senMail(String mail, String name) {

		String host = "smtp.office365.com";
		final String user = "shruchatter79136@outlook.com";
		final String password = "happy123";
		String to = mail;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.debug", "true");
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getDefaultInstance(prop, null);

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Registraion confirmation email");
			message.setText("Hi.:" + name + "");

			//Transport.send(message, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	

	
	}	
	
}
