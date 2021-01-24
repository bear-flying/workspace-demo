package com.jiangyu.observer2;

/**
 * 观察者设计模式：
 *
 * 观察者模式完美的将观察者和被观察者的对象分离开。
 * 此模式中，一个目标物件管理所有相依于它的观察者物件，并且在它本身的状态改变时主动发出通知。
 * 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态上发生变化时，会通知所有观察者对象，使他们能够自动更新自己。
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        //1 创建一个具体主题
        ConcreteTheme  theme = new ConcreteTheme("红色主题状态");


        //2.创建网站的网页    观察者
        PageObserver p1 = new PageObserver("一级页面");
        PageObserver p2 = new PageObserver("二级页面");
        PageObserver p3 = new PageObserver("三级页面");

        theme.attach(p1);
        theme.attach(p2);
        theme.attach(p3);


        theme.change("绿色状态");


        System.out.println(p1.getPageLevel()+"的状态为:"+p1.getPageState());
        System.out.println(p2.getPageLevel()+"的状态为:"+p2.getPageState());
        System.out.println(p3.getPageLevel()+"的状态为:"+p3.getPageState());

    }

}

