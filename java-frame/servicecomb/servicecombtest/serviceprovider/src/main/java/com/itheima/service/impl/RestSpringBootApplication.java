package com.itheima.service.impl;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/9/17.
 */
@SpringBootApplication
@EnableServiceComb //向注册中心进行注册
public class RestSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestSpringBootApplication.class,args);
    }
}
