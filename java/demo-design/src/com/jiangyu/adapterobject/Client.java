package com.jiangyu.adapterobject;

/**
 *
 * 适配器设计模式：
 * 把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法一起工作的两个类能够一起工作。
 *
 *
 * 对象适配器模式：
 * 与类的适配器模式一样，对象适配器模式把被适配的类的API转换为目标。
 * 类的API，不同的是，对象适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 *
 */
public class Client {

    public static void main(String[] args) {
        //Target t = new Adapter(new Adaptee1());
        //Target t = new Adapter(new Adaptee2());
        Target t = new Adapter(new Adaptee1Sub());
        t.a();
        t.b();
    }

}
