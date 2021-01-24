package com.jiangyu.facade;

/**
 * 门面角色
 * @author JIAO
 *
 */
public class Facade {
    /**
     * 处理客户端请求
     */
    public void doRequest(){
        ModuleA a = new ModuleA();
        ModuleB b = new ModuleB();
        ModuleC c = new ModuleC();

        a.doModuleA();
        b.doModuleB();
        c.doModuleC();
    }
}
