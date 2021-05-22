package com.study.user_provider;

import com.study.user_api.RegisterApi;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProviderController implements RegisterApi {

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

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, "mmeme");
    }
    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id,String name) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }
}
