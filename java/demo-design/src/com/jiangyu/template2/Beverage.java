package com.jiangyu.template2;

/**
 * 抽象模板类角色
 * @author JIAO
 *
 */
public abstract class Beverage {
    final public void make(){
        boilWater();
        brew();
        pourInCup();
        addOtherFood();
    }

    final public void boilWater(){
        System.out.println("烧开水");
    }

    //泡制饮料方法  抽象    子类具体实现
    public abstract void brew();

    //将饮料倒入杯中方法
    final public void pourInCup(){
        System.out.println("倒入杯中");
    }

    //钩子方法     添加辅料
    public void addOtherFood(){}
}

