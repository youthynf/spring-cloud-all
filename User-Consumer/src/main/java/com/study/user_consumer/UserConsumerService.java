package com.study.user_consumer;

import com.study.user_api.RegisterApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-provider")
public interface UserConsumerService extends RegisterApi {

}
