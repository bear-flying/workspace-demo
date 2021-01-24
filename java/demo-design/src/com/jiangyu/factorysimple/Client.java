package com.jiangyu.factorysimple;

/**
 * 简单工厂模式 Simple Factory
 * @author JiangYu
 *
	简单工厂模式是工厂方法模式的一个特例，给单独抽取了出来。
	优点：客户类和工厂类分开。工厂类关注于产品的生产，客户端”消费者”任何时候需要某种产品，
		只需向工厂请求即可，可以无需知道每次实例化哪个类，消费者无须修改就可以接纳新产品。
	缺点：当产品修改或有新产品加入时，工厂类也要做相应的修改。
 *
 */
public class Client {

	public static void main(String[] args) {
		Car car1 = Factory.create(1);
		car1.drive();

		Car car2 = Factory.create(2);
		car2.drive();
		
		System.out.println("---------------");
		
		Car c1 = Factory2.create("com.jiangyu.factorysimple.Benz");
		Car c2 = Factory2.create("com.jiangyu.factorysimple.QQ");

		c1.drive();
		c2.drive();
	}

}
