package com.jiangyu.bridge;

/**
 * 具体实现化角色
 * @author JIAO
 *
 */
public class NOMilkCoffeeImplementor implements CoffeeImplementor{

    @Override
    public void pourCoffeeImpl() {
        System.out.println("不加奶咖啡");

    }

}