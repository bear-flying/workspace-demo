package com.jiangyu.bridge;

/**
 * 抽象化角色
 * 持有一个实现化角色的引用   来完成组合关系
 * 利用这个组合关系来代替抽象类继承实现的方式
 * @author JIAO
 *
 */
public abstract class Coffee {
    public CoffeeImplementor coffeeImpl;

    public void pourCoffee(){
        coffeeImpl.pourCoffeeImpl();
    }

    //get&set方法
    public CoffeeImplementor getCoffeeImpl() {
        return coffeeImpl;
    }
    public void setCoffeeImpl(CoffeeImplementor coffeeImpl) {
        this.coffeeImpl = coffeeImpl;
    }
}
