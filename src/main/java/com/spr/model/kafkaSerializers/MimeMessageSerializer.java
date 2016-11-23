package com.spr.model.kafkaSerializers;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public class MimeMessageSerializer  implements Serializer<MimeMessage> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, MimeMessage data) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            if (data == null)
                return null;
            else
                data.writeTo(baos);
                return  baos.toByteArray();
        }  catch (Exception e) {
            e.printStackTrace();
            throw new SerializationException("Cant serialize mime message" + e);
        }
    }

    @Override
    public void close() {
        // nothing to do
    }
}
