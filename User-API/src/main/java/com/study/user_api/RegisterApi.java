package com.study.user_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 用户操作相关接口
 * @author 一明哥
 *
 */
@RequestMapping("/User")
public interface RegisterApi {

    @GetMapping("/isAlive")
    public String isAlive();

    @GetMapping("/register")
    public String register();

    @GetMapping("/findById")
    public Map findById(@RequestParam("id") Integer id);
}