package com.jiangyu.flyweight;

/**
 * 具体享元角色
 * 实现抽象享元角色
 * 并提供存储内蕴状态
 * @author JIAO
 *
 */
public class ConcreteFlyweight implements Flyweight {
	//内蕴状态
	private String name;
	
	public ConcreteFlyweight(String name) {
		super();
		this.name = name;
	}

	/**
	 * outState
	 * 外蕴状态：在客户端使用时传入的    可以变化的状态
	 */
	@Override
	public void operate(String outState) {
		System.out.println("内蕴状态:"+name);
		System.out.println("外蕴状态:"+outState);

	}

}