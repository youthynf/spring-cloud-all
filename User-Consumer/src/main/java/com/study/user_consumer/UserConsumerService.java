package com.study.user_consumer;

import com.study.security.FeignAuthConfiguration;
import com.study.user_api.RegisterApi;
import com.study.user_consumer.hystrix.AliveBack;
import com.study.user_consumer.hystrix.WebError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

// configuration = FeignAuthConfiguration.class用来配置安全认证
//@FeignClient(name = "user-provider", configuration = FeignAuthConfiguration.class)
//@FeignClient(name = "user-provider", fallback = AliveBack.class)
@FeignClient(name = "user-provider", fallbackFactory = WebError.class)
public interface UserConsumerService extends RegisterApi {
    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);

    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);
}
