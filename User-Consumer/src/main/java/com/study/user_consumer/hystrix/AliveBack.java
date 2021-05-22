package com.study.user_consumer.hystrix;

import com.study.user_consumer.UserConsumerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AliveBack implements UserConsumerService {
    @Override
    public Map<Integer, String> getMap(Integer id) {
        System.out.println("AliveBack:getMap");
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        System.out.println("AliveBack:getMap2");
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        System.out.println("AliveBack:getMap3");
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        System.out.println("AliveBack:postMap");
        return null;
    }

    @Override
    public String isAlive() {
        System.out.println("AliveBack:isAlive");
        return null;
    }

    @Override
    public String register() {
        System.out.println("AliveBack:register");
        return null;
    }

    @Override
    public Map findById(Integer id) {
        System.out.println("AliveBack:findById");
        return null;
    }
}
