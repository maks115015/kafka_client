package com.spr.service;

import javax.mail.internet.MimeMessage;

public interface MailService {

	void send(MimeMessage email);
}
