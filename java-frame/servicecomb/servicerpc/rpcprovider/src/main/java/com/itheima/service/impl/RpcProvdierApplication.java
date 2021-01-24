package com.itheima.service.impl;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动类
 */
@SpringBootApplication
@EnableServiceComb
public class RpcProvdierApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcProvdierApplication.class,args);
    }
}
