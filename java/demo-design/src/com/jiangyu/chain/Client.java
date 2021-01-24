package com.jiangyu.chain;

/**
 * 责任链设计模式：
 *
 * 责任链模式里，由很多对象组成一条链，每个对象持有下个对象的引用。请求在这个
 * 链上传递，直到链上的某一个对象决定处理此请求。
 * 客户并不知道链上的哪一个对象最终处理这个请求，系统可以在不影响客户端的情况下
 * 动态的重新组织链和分配责任。
 * 处理者有两个选择：承担责任或者把责任推给下家。
 * 一个请求可以最终不被任何接收端对象所接受。
 */
public class Client {

    public static void main(String[] args) {
        //使用责任链模式，首先要建立起责任链
        ProjectManager handler1 = new ProjectManager();
        DeptManager handler2 = new DeptManager();
        GeneralManager handler3 = new GeneralManager();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);


        handler1.handleRequest("张三", 300);

        handler1.handleRequest("张三", 800);

        handler1.handleRequest("张三", 2000);

        handler1.handleRequest("张三", 10000);

        handler1.handleRequest("李四", 300);
    }

}

