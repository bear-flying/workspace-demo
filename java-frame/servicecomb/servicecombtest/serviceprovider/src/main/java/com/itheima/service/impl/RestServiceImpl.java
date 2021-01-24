package com.itheima.service.impl;

import com.itheima.service.RestService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@RestSchema(schemaId = "hello")
@RequestMapping("/hello")
public class RestServiceImpl implements RestService {
    @Override
    @GetMapping("/hello")
    public String sayRest(String name) {
        return "Hello World "+name;
    }
}
