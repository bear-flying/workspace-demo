package com.itheima.service.impl;

import com.itheima.service.RestService;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者的服务接口实现类
 */
@Service
public class RestConsumerServiceImpl implements RestService {
    //RestTemplate模板
    private final RestTemplate restTemplate = RestTemplateBuilder.create();//使用ServiceComb提供的类

    @Override
    public String sayRest(String name) {
        String provideName = "provider";
        //URL:cse://是协议    +  微服务名称   +具体某个微服务的访问路径
        //String.class表示设置返回值类型
        String rtnValue = restTemplate.getForObject("cse://"+provideName+"/hello/hello?name="+name,String.class);
        return rtnValue;
    }
}
