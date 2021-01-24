package com.jiangyu.adapterclass;

/**
 * 适配器设计模式：
 * 把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法一起工作的两个类能够一起工作。
 *
 *
 * 类的适配器模式：
 * 使用一个具体类把源（Adaptee）适配到目标（Target）。
 * 如果源（Adaptee）以及源的子类都使用此适配器类适配，就行不通了。
 * 我们使用对象的适配器模式来解决。
 * 类的适配器模式把适配的类的API转换为目标的API
 *
 */
public class Client {

    public static void main(String[] args) {
        Target t = new Adapter();
        t.a();
        t.b();
    }

}
