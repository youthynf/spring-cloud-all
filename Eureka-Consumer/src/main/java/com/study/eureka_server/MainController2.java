package com.study.eureka_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MainController2 {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    private static final AtomicInteger atomicInteger;
    static {
        atomicInteger = new AtomicInteger();
    }

    @GetMapping("/client5")
    public Object client5() {
        // ribbon 完成客户端的负载均衡 过滤掉down的机器
        ServiceInstance instances = lb.choose("provider");

        // 加了了注解@LoadBalanced之后，我们的restTemplate访问域名必须是我们访问的服务名称serverid
        // String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";
        String url = "http://" + instances.getServiceId() + ":" + instances.getPort() + "/getHi";
        System.out.println("url: " + url);

        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println("resp_str:" + forObject);
        return forObject;
    }

    /**
     * 手动负载均衡
     */
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/client6")
    public Object client6() {
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        // 轮询：实际上实现不了，因为返回的instances每次的顺序都不一样
        int i = atomicInteger.getAndIncrement();
        int nextInt = i % instances.size();
        System.out.println(i + "-" + nextInt);
        // 随机
        // int nextInt = new Random().nextInt(instances.size());
        //权重（待补充）
        ServiceInstance instance = instances.get(nextInt);
        String url = "http://" + instance.getServiceId() + ":" + instance.getPort() + "/getHi";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/getMap")
    public ResponseEntity<Map> getMap() {
        ServiceInstance provider = lb.choose("provider");
        String url = "http://" + provider.getServiceId() + ":" + provider.getPort() + "/getMap";
        System.out.println(url);

        ResponseEntity<Map> entity = restTemplate.getForEntity(url, Map.class);
        System.out.println("respStr: "  + entity.getBody());
        return entity;
    }

    @GetMapping("/postParam")
    public ResponseEntity<Person> postParam(String name) {
        ServiceInstance provider = lb.choose("provider");
        String url = "http://" + provider.getServiceId() + ":" + provider.getPort() + "/postParam";
        Map<String, String> map = Collections.singletonMap("name", name);
        ResponseEntity<Person> entity = restTemplate.postForEntity(url, map, Person.class);
        System.out.println(entity);
        return entity;
    }

    @GetMapping("/postForLocation")
    public URI postForLocation() {
        ServiceInstance provider = lb.choose("provider");
        String url = "http://" + provider.getServiceId() + ":" + provider.getPort() + "/postForLocation";
        Map<String, String> map = Collections.singletonMap("name", "memeda");
        URI location = restTemplate.postForLocation(url, map, Person.class);
        System.out.println(location);
        return location;
    }
}
