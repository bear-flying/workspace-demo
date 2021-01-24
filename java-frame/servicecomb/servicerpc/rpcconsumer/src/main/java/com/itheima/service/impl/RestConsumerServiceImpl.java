package com.itheima.service.impl;

import com.itheima.service.RpcService;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.stereotype.Component;

/**
 * RPC-服务消费者
 */
@Component
public class RestConsumerServiceImpl implements RpcService {

    //从注册中心找，找哪个应用程序下面的哪个微服务
    //microserviceName ：代表了哪个应用程序编号:下面的哪个应用名
    //schemaId="",它的值来自于服务提供者中用@RpcSchema(schemaId = "helloRpc")
    @RpcReference(microserviceName = "start.servicecomb.io:serviceprovider-rpc",
            schemaId = "helloRpc")
    private RpcService rpcService;//从注册中心推送过来
    @Override
    public String sayRpc(String name) {
        return rpcService.sayRpc(name);
    }
}
