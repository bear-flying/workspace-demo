package com.jiangyu.adapterclass;

/**
 * 适配器角色
 * 将需要适配的adaptee适配为Target目标类型
 * @author JIAO
 *
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void b() {
        System.out.println("adapter : b()实现");
    }

}
