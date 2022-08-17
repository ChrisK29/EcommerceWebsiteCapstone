package com.chris.ecommerce.Controller;

import javax.validation.ValidationException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.ecommerce.Email.Email;
import com.chris.ecommerce.Email.EmailConfig;

@RestController
@RequestMapping("/email")
public class EmailController {

	private EmailConfig emailConfig;

	public EmailController(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}

	@PostMapping
	public void sendEmail(@RequestBody Email email, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Email is not valid");
		}

		// Email sender
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
		
		// Email instance
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(email.getEmail());
		mailMessage.setTo("email@email.com");
		mailMessage.setSubject("New Email from " + email.getName());
		mailMessage.setText(email.getFeedback());
		
		// Send email
		
		mailSender.send(mailMessage);
	}

}
