package com.spr.model.kafkaSerializers;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.util.Map;

public class MimeMessageDeserializer implements Deserializer<MimeMessage> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public MimeMessage deserialize(String topic, byte[] data) {
        final JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        ByteArrayInputStream inst = new ByteArrayInputStream(data);
        return mailSenderImpl.createMimeMessage(inst);
    }

    @Override
    public void close() {

    }
}
