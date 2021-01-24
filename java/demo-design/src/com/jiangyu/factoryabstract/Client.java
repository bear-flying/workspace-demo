package com.jiangyu.factoryabstract;

/**
 * 抽象工厂模式
 * 
 * @author JiangYu
 	抽象工厂模式和工厂方法模式的区别就在于需要创建对象的复杂程度上。
	而且抽象工厂模式是三个里面最为抽象、最具一般性的。
	抽象工厂模式的用意为：给客户端提供一个接口或抽象类，可以创建多个产品族中的产品对象
	而且使用抽象工厂模式还要满足以下条件：
	1)  系统中有多个产品族
	2)  系统一次只可能消费其中一族产品及其使用
	产品族：位于不同产品等级结构中，功能相关联的产品组成的家族。
 */
public class Client {
	public static void main(String[] args) {
		//使用跑车系列产品
		Factory f = new SportCarFactory();
		BenzCar benz = f.createBenz();
		BMWCar bmw = f.createBMW();
		benz.drive();
		bmw.drive();
		//使用商务车系列产品
		Factory f2 = new BussinessCarFactory();
		BenzCar benz2 = f2.createBenz();
		BMWCar bmw2 = f2.createBMW();
		benz2.drive();
		bmw2.drive();
	}
}
