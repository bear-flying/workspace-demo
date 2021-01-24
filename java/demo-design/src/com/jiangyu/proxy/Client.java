package com.jiangyu.proxy;

/***
 * 静态代理
 *
 * 给某一个对象提供一个代理对象，并由代理对象控制对源对象的引用。代理就是一个人或一个机构代表另一个人或者一个机构采取行动。某些情况下，客户不想或者不能够直接引用一个对象，代理对象可以在客户和目标对象直接起到中介的作用。
 * 在某些情况下，一个客户不想或者不能直接引用另一个对象，而代理对象可以在客户端	和目标对象之间起到中介作用。
 * 代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。
 * 代理模式分为： 静态代理 和 动态代理(利用反射实现)。
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        Forum realForum = new RealForum();
        User user = new User("zhangsan",1);
        Forum proxyForum = new ProxyForum(realForum,user);
        proxyForum.addPost();
    }

}
