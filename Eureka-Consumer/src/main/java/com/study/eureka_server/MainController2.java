package com.study.eureka_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController2 {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client5")
    public void client5() {
        // ribbon 完成客户端的负载均衡 过滤掉down的机器
        ServiceInstance instances = lb.choose("provider");

        // 加了了注解@LoadBalanced之后，我们的restTemplate访问域名必须是我们访问的服务名称serverid
        // String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";
        String url = "http://" + instances.getServiceId() + ":" + instances.getPort() + "/getHi";
        System.out.println("url: " + url);

        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println("resp_str:" + forObject);
    }
}
