package com.smartCity.CityManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmailWithAttachment(String email, String subject, String text, byte[] attachment, String fileName) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setText(text);
		helper.addAttachment(fileName, new ByteArrayResource(attachment));
		mailSender.send(message);
	}

}
