package com.jiangyu.strategy;

/**
 * 具体策略角色
 * 统一优惠价格 优惠策略
 * @author JIAO
 *
 */
public class FlatRateDiscountStrategy extends DiscountStrategy {
    private double flatRate;//优惠钱的数额
    public FlatRateDiscountStrategy(Product p,double flatRate){
        this.p = p;
        this.flatRate = flatRate;
    }
    @Override
    public double discount() {
        return flatRate*p.getCount();
    }

}
