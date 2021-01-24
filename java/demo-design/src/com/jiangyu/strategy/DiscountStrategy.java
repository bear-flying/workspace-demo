package com.jiangyu.strategy;

/**
 * 抽象策略角色
 * @author JIAO
 *
 */
public abstract class DiscountStrategy {

    protected Product p;


    public Product getP() {
        return p;
    }


    public void setP(Product p) {
        this.p = p;
    }


    //计算优惠的方法
    public abstract double discount();
}
