package com.study.user_provider;

import com.study.user_api.RegisterApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements RegisterApi {

    @Override
    public String isAlive() {
        // TODO Auto-generated method stub
        return "ok";
    }
}
