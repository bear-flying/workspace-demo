package com.jiangyu.strategy;

/**
 *
 * 策略设计模式：
 *
 * 针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * 策略模式使得算法可以在不影响到客户端的情况下发生变化。策略模式把行为和环境分开。
 * 环境类负责维持和查询行为类，各种算法在具体的策略类中提供。
 * 由于算法和环境独立开来，算法的增减，修改都不会影响到环境和客户端。
 *
 */
public class Client {
    public static void main(String[] args) {
        Product p1 = new Product("玩具",100,1,DiscountType.NO);
        Product p2 = new Product("水杯",180,1,DiscountType.FLATRATE);
        Product p3 = new Product("上衣",110,2,DiscountType.PERCENT);

        Context context = new Context();

        context.setP(p1);
        context.checkOut();

        context.setP(p2);
        context.checkOut();

        context.setP(p3);
        context.checkOut();
    }
}
