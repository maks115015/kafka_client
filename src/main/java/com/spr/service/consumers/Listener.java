package com.spr.service.consumers;

import com.spr.service.MailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Log4j2
@Component
public class Listener {

    @Autowired
    private MailService mailService;

    @KafkaListener( topics = "memail")
    public void listen(@Payload MimeMessage message) {
        try {
            log.info("recieve message {}", message.getSender());
            mailService.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "mtesttopic")
    public void listen1(@Payload String message) {
        log.info("recieve message {}", message);
    }
}
