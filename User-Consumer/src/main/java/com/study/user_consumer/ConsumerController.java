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

    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return consumerSrv.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name) {
        System.out.println(id);
        return consumerSrv.getMap2(id,name);
    }

    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return consumerSrv.getMap3(map);
    }

    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return consumerSrv.postMap(map);
    }
}
