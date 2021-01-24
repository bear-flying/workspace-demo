package com.jiangyu.adapterobject;
/**
 * 适配器角色
 * 适配Adaptee及所有的子类型
 * 使用对象适配器模式
 * @author JIAO
 *
 */
public class Adapter implements Target {
    //源角色的对象引用
    private Adaptee adaptee;
    public Adapter (Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void a() {
        adaptee.a();
    }

    @Override
    public void b() {
        System.out.println("Apdater  b()实现");
    }

}