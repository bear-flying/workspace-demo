package com.jiangyu.bridge;

/**
 * 再次对抽象角色进行修正
 * @author JIAO
 *
 */
public class SmallCoffee extends Coffee {
    @Override
    public void pourCoffee() {
        System.out.print("使用小杯");
        this.coffeeImpl.pourCoffeeImpl();
    }
}
