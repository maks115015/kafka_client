package com.spr.controller;

import com.spr.service.producers.StringProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController{


    @Autowired
    private StringProducer stringProducer;


    @RequestMapping(value = "/info")
    public String mainPage() {
        try {
            stringProducer.send();
        } catch (InterruptedException e) {
            log.error(e);
        }
        return "Server working";
    }

}
