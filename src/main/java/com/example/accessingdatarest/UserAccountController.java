package com.example.accessingdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public Person displayRegistration(@RequestBody Person user)
	{
		ConfirmationToken confirmationToken = new ConfirmationToken(user);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setText("Hi"+user.getFirstName()+"To confirm your account, please click here : "
		+"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());
		emailSenderService.sendEmail(mailMessage);
		
		return user ;
	}

}
