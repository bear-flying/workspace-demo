package com.itheima.service.impl;

import com.itheima.service.RpcService;
import org.apache.servicecomb.provider.pojo.RpcSchema;

/**
 * PRC方式-服务提供者
 * schemaId = "helloRpc" 代表服务编号
 */
@RpcSchema(schemaId = "helloRpc")
public class RpcProviderServiceImpl implements RpcService {
    @Override
    public String sayRpc(String name) {
        return "hello "+name;
    }
}
