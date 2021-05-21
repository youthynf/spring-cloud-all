package com.study.user_provider;

import com.study.user_api.RegisterApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController implements RegisterApi {

    @Override
    public String isAlive() {
        // TODO Auto-generated method stub
        return "ok";
    }

    @Override
    public String register() {
        return "register";
    }

    @Override
    public Map findById(Integer id) {
        System.out.println("收到ID：" + id);
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "kafka");
        map.put("age", "24");
        return map;
    }
}
