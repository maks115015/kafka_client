package com.spr.service.producers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class EMailsProducer {

    /*@Autowired
    private KafkaTemplate<StringProducer, MimeMessage> kafkaTemplate;


    public void send(MimeMessage mimeMessage) throws InterruptedException {

        ListenableFuture<SendResult<StringProducer, MimeMessage>> future = kafkaTemplate.send("memail", mimeMessage);
        future.addCallback(new ListenableFutureCallback<SendResult<StringProducer, MimeMessage>>() {
            @Override
            public void onSuccess(SendResult<StringProducer, MimeMessage> result) {
                log.info("sended");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("failed {}", ex);
            }
        });


    }*/

}
