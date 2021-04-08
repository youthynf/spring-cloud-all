package com.study.eureka_provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi() {
        return "Hi, 我的port:" + port;
    }

    @Autowired
    HealthStatusService healthStatusSrv;

    //通过http://localhost:90/setHealth?status=false设置provider服务的监控状态
    @GetMapping("/setHealth")
    public String setHealth(@RequestParam("status") Boolean status) {
        healthStatusSrv.setStatus(status);
        return healthStatusSrv.getStatus();
    }

    //通过http://localhost:90/getHealthStatus查询provider的健康状态
    @GetMapping("getHealthStatus")
    public String getHealth() {
        return healthStatusSrv.getStatus();
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "500");
        return map;
    }
}
