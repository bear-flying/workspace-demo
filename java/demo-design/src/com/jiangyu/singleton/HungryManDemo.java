package com.jiangyu.singleton;

/**
 * 
 * @author JiangYu
 * 
 * 单例设计模式：饿汉式
 *
 */
public class HungryManDemo {

	private static HungryManDemo demo = new HungryManDemo();

	private HungryManDemo(){}
	
	public static HungryManDemo getInstance(){
		return demo;
	}
	
}