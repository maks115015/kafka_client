package com.spr.service;

import com.spr.service.producers.StringProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Log4j2
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	/*@Autowired
	private EMailsProducer eMailsProducer;*/

	@Autowired
	private StringProducer stringProducer;

	/*@PostConstruct
	public void init() {
		try {
			log.info("sendeing email");
		}  catch (InterruptedException e) {
			log.warn("cant send test mail to kafka {}", e);
		}
	}*/


	@Override
	public void send(MimeMessage email) {
		log.info("getting message to send {}", email.toString());
		mailSender.send(email);
	}

	private MimeMessage makeTestEmail() throws MessagingException {
		log.info("sending test message");
		MimeMessage email = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		String text = "message server started" + LocalDateTime.now();
		helper = new MimeMessageHelper(email, true, "utf-8");
		helper.setTo("avto12@i.ua");
		helper.setSubject("new user registered");
		helper.setFrom("<avto12@i.ua>");
		helper.setText(text);
		return email;
	}
}
