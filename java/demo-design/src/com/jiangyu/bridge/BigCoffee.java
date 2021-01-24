package com.jiangyu.bridge;

/**
 * 抽象化角色的修正类
 * @author JIAO
 *
 */
public class BigCoffee extends Coffee {
    @Override
    public void pourCoffee() {
        System.out.print("使用大杯");
        this.coffeeImpl.pourCoffeeImpl();
    }
}
