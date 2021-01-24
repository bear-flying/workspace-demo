package com.jiangyu.bridge;

/**
 * 具体实现化角色
 * @author JIAO
 *
 */
public class MilkCoffeeImplementor implements CoffeeImplementor{

    @Override
    public void pourCoffeeImpl() {
        System.out.println("加奶咖啡");

    }

}
