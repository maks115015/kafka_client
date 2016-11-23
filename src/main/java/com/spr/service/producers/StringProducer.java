package com.spr.service.producers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Log4j2
@Component
public class StringProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send() throws InterruptedException {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("mtesttopic", "test message");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("sended");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("failed {}", ex);
            }
        });


    }
}
