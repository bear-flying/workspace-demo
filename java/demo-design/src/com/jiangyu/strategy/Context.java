package com.jiangyu.strategy;

public class Context {
    private DiscountStrategy strategy;
    private Product p;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public DiscountStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }


    public void checkOut(){
        String type ="";
        switch(p.getType()){
            case NO:{
                this.strategy = new NoDiscountStrategy(p);
                type ="无优惠";
                break;
            }case FLATRATE:{
                this.strategy = new FlatRateDiscountStrategy(p, 5);
                type ="统一价优惠,每个商品统一优惠5元";
                break;
            }case PERCENT:{
                this.strategy = new PercentDiscountStrategy(p, 0.8);
                type ="折扣优惠，折扣为八折";
                break;
            }
        }

        //优惠价钱
        double discount = this.strategy.discount();
        System.out.println("商品:"+p.getName()+"\t优惠价钱:"+discount +"\t优惠类型:"+type);
    }

}

