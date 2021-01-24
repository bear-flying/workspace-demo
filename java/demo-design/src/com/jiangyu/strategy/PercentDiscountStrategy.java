package com.jiangyu.strategy;

/**
 * 具体策略角色
 * 折扣 优惠策略
 * @author JIAO
 *
 */
public class PercentDiscountStrategy extends DiscountStrategy {
    private double percent;//优惠的折扣
    public PercentDiscountStrategy(Product p,double percent){
        this.p = p;
        this.percent = percent;
    }
    @Override
    public double discount() {
        return p.getPrice()*(1-percent)*p.getCount();
    }

}
