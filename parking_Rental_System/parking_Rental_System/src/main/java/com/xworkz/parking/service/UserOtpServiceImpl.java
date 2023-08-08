package com.xworkz.parking.service;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.parking.dto.UserinfoDTO;
import com.xworkz.parking.entity.UserinfoEntity;
import com.xworkz.parking.repository.UserInfoRepository;
import com.xworkz.parking.repository.UserOtpRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserOtpServiceImpl implements UserOtpService {

	@Autowired
	private UserInfoRepository repo;

	@Autowired
	private UserOtpRepo repo1;

	@Override
	public boolean validateAndSave(UserinfoDTO dto) {
		log.info("validateAndSave method running in UserOtpServiceImpl ");
		UserinfoEntity entity = new UserinfoEntity();
		BeanUtils.copyProperties(dto, entity);
		log.info("getting entity:" + entity);
		this.repo.save(entity);
		return true;
	}

	@Override
	public String userSignIn(String email, UserinfoEntity entity) {
		log.info("Running userSignIn method in UserOtpServiceImpl");
		// UserinfoEntity record=repo1.findByUserEmail(email);
		UserOtpServiceImpl service = new UserOtpServiceImpl();
		service.otpSendMail(email, entity);
		String otp = entity.getEmailOTP();
		repo1.userSignInUpdate(otp, email);

		return "saved";
	}

	@Override
	public boolean otpSendMail(String email, UserinfoEntity entity) {
		log.info("Running otpSendMail method in UserOtpServiceImpl");
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		final String fromEmail = "shrutichatter9148@outlook.com";
		final String password = "happy@123";
		String to = email;
		
		

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);

		try {
			String otp = new DecimalFormat("0000").format(new Random().nextInt(9999));
			System.out.println(otp);
			

			entity.setEmailOTP(otp);
			
			
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Here Your one Time Password Sent BY Shruti");
			message.setText(" OTP = " + entity.getEmailOTP());

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			System.out.println("message==============================++=:"+message);
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

}