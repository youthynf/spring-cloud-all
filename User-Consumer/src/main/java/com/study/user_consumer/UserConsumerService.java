package com.study.user_consumer;

import com.study.security.FeignAuthConfiguration;
import com.study.user_api.RegisterApi;
import org.springframework.cloud.openfeign.FeignClient;

// configuration = FeignAuthConfiguration.class用来配置安全认证
//@FeignClient(name = "user-provider", configuration = FeignAuthConfiguration.class)
@FeignClient(name = "user-provider")
public interface UserConsumerService extends RegisterApi {

}
