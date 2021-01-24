package com.jiangyu.strategy;

/**
 * 具体策略角色
 * 无优惠
 * @author JIAO
 *
 */
public class NoDiscountStrategy extends DiscountStrategy {
    public NoDiscountStrategy(Product p){
        this.p = p;
    }
    @Override
    public double discount() {
        return 0;
    }

}
