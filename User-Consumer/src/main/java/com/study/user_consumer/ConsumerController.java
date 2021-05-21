package com.study.user_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @GetMapping("/findById")
    public Map findById(@RequestParam("id") Integer id) {
        return consumerSrv.findById(1);
    }
}
