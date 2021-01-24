package com.jiangyu.proxy;

/**
 * JDK动态代理
 */
public class Client2 {

    public static void main(String[] args) {
        Forum realForum = new RealForum();
        realForum.addPost();

        LogHandler logHandler =
                new LogHandler(realForum);

        Forum proxyForum =
                (Forum)logHandler.createProxy();
        proxyForum.addPost();


        LogHandler logHandler2 =
                new LogHandler(new AImpl());
        A aProxy = (A)logHandler2.createProxy();
        aProxy.a();
    }

}

