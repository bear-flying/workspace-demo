package com.itheima.controller;

import com.itheima.service.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *对外发布的控制类
 */
@RestController
public class RpcConsumerController {
    @Autowired
    private RpcService rpcService;

    @RequestMapping("/rpc")
    public void rpcInvoke(){
        System.out.println(rpcService.sayRpc(" servicecomb rpc "));
    }

}
