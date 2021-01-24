package com.jiangyu.factorysimple;

/**
 * 
 * @author JiangYu
 * 
 * 工厂设计模式  实现
 * 
 */

public class CarFactoryDemo {
	public static CarDemo createCar(String type){
		if("奥拓".equals(type)){
			return new Auto();
		} else if ("比亚迪".equals(type)){
			return new BYD();
		}
		return null;
	}
	
	//使用工厂模式的方法 屏幕了创建对象的细节 是我们只关注获取对象
	public void testFactory(){
		CarDemo c1 = CarFactoryDemo.createCar("奥拓");
		CarDemo c2 = CarFactoryDemo.createCar("比亚迪");
		c1.run();
		c2.run();
	}
	
	//不使用工厂模式的方法
	public void testNoFactory(){
		CarDemo c1 = new Auto();
		CarDemo c2 = new BYD();
		
		c1.run();
		c2.run();
	}
	
}

class CarDemo{
	public void run(){
		System.out.println("跑跑跑...");
	}
}

class Auto extends CarDemo{}

class BYD extends CarDemo{}


