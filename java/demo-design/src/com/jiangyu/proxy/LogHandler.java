package com.jiangyu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 关注日志处理的动态处理器
 * 能够在执行过程中动态给真实对象/目标对象/被代理对象  产生代理对象
 * 真实对象和产生的代理对象应该同属于一种接口类型
 *
 * jdk动态代理的强制要求：被代理类/真实角色类必须有接口实现
 * @author JIAO
 *
 */
public class LogHandler implements InvocationHandler {

    private Object realObj;//真实对象/目标对象/被代理对象

    public LogHandler(Object realObj){
        this.realObj = realObj;
    }

    //创建代理的方法
    public Object createProxy(){
        return Proxy.newProxyInstance(
                realObj.getClass().getClassLoader(),
                realObj.getClass().getInterfaces(),
                this);//创建返回的代理对象和当前控制器关联
        //this通过被代理的对象生成它的代理对象, 并同handler绑定在一起
    }

    /**
     * 该方法不用客户端直接调用
     * 是客户端获得代理对象，代理对象在动态执行任何一个方法时，比如a()
     * 代理对象执行方法就会被LogHandler实例动态处理，就会动态调用该方法invoke
     *
     *
     * InvocationHandler的invoke()方法会传入代理对象的方法名称与参数,
     * 实际上要执行的方法交由method.invoke()，並在其前后加上记录动作，
     * method.invoke()返回的对象是实际方法执行过后的回传結果。
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;


        System.out.println(method.getName()+"方法开始执行........");
        //调用被代理对象的方法
        result = method.invoke(realObj, args);//动态执行真实对象的method动态匹配方法
        System.out.println(method.getName()+"方法结束执行........");
        return result;
    }

}
