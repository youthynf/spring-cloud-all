package com.study.eureka_server;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient client2;

    @GetMapping("/getHi")
    public String getHi() {
        return "Hi";
    }

    @GetMapping("/client")
    public String client() {
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "Hi";
    }

    @GetMapping("/client2")
    public Object client2() {
        return client.getInstances("provider");
    }

    @GetMapping("/client3")
    public void client3() {
        // 具体的服务
//        List<InstanceInfo> instances = client2.getInstancesById("localhost:provier:80");
        // 通过服务名取服务列表
        List<InstanceInfo> instances = client2.getInstancesByVipAddress("provider", false);
        for (InstanceInfo ins: instances) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }

        if(instances.size() > 0) {
            InstanceInfo instanceInfo = instances.get(0);
            if(instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";
                System.out.println("url: " + url);
                RestTemplate restTemplate = new RestTemplate();
                String forObject = restTemplate.getForObject(url, String.class);
                System.out.println("resp_str:" + forObject);
            }
        }
    }
}
