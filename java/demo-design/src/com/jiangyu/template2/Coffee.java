package com.jiangyu.template2;

/**
 * 具体类
 * @author JIAO
 *
 */
public class Coffee extends Beverage {

    @Override
    public void brew() {
        System.out.println("冲咖啡");
    }

    @Override
    public void addOtherFood() {
        System.out.println("加糖，加奶");
    }
}
