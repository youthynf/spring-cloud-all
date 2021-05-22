package com.study.user_consumer.hystrix;

import com.study.user_consumer.UserConsumerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebError implements FallbackFactory<UserConsumerService> {
    @Override
    public UserConsumerService create(Throwable throwable) {
        return new UserConsumerService() {
            @Override
            public Map<Integer, String> getMap(Integer id) {
                System.out.println("WebError:getMap");
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                System.out.println("WebError:getMap2");
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                System.out.println("WebError:getMap3");
                return null;
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                System.out.println("WebError:postMap");
                return null;
            }

            @Override
            public String isAlive() {
                System.out.println("WebError:isAlive");
                return null;
            }

            @Override
            public String register() {
                System.out.println("WebError:register");
                return null;
            }

            @Override
            public Map findById(Integer id) {
                System.out.println("WebError:findById");
                return null;
            }
        };
    }
}
