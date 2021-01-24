package com.jiangyu.factorymethod;

/*
工厂方法模式：Factory Method

定义一个创建产品的工厂接口或抽象类，核心工厂类不再负责所有产品的创建，
而是将具体创建的工作交给子类去做，成为一个抽象工厂角色，仅负责给出具体工厂类必须实现的接口，
而不接触哪一个产品类应当被实例化这种细节。
优点：这种工厂方法模式可以允许系统在不修改具体工厂角色的情况下引入新的产品。
1)  抽象工厂角色：这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。
2)  具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。 
3)  抽象产品角色：它是具体产品继承的父类或者是实现的接口。
4)  具体产品角色：具体工厂角色所创建的对象就是此角色的实例。

*/
public class Client {
	public static void main(String[] args) {
		Car benz = new BenzFactory().createCar();
		benz.drive();
		Car bmw = new BMWFactory().createCar();
		bmw.drive();
		
		Car qq = new QQFactory().createCar();
		qq.drive();
	}
}
