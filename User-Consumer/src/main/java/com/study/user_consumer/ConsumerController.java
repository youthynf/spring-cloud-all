package com.study.user_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    UserConsumerService consumerSrv;

    @GetMapping("/alive")
    public String alive() {
        return consumerSrv.isAlive();
    }

    @GetMapping("/register")
    public String register() {
        return consumerSrv.register();
    }
}
