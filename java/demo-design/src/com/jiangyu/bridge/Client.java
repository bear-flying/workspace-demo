package com.jiangyu.bridge;

/**
 * 桥梁设计模式：
 * 将抽象化与实现化脱耦，使得二者可以独立的变化，也就是说将他们之间的强关联变成弱关联，
 * 也就是指在一个软件系统的抽象化和实现化之间使用组合/聚合关系而不是继承关系，从而使两者可以独立的变化。
 *
 * 动态结合,我们现在可以喝到至少六种咖啡:
 * 1.中杯加奶2.中杯不加奶3.大杯加奶4.大杯不加奶5.小杯加奶6.小杯不加奶
 */
public class Client {

    public static void main(String[] args) {
        //大杯加奶咖啡
        Coffee coffee = new BigCoffee();
        coffee.setCoffeeImpl(new MilkCoffeeImplementor());
        coffee.pourCoffee();


        //中杯 不加奶咖啡
        Coffee coffee2 = new MiddleCoffee();
        coffee2.setCoffeeImpl(new NOMilkCoffeeImplementor());
        coffee2.pourCoffee();

        //小杯加奶
        Coffee coffee3 = new SmallCoffee();
        coffee3.setCoffeeImpl(new MilkCoffeeImplementor());
        coffee3.pourCoffee();
    }

}
