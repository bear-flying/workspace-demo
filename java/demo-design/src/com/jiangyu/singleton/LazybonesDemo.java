package com.jiangyu.singleton;

/**
 * 
 * @author JiangYu
 * 
 * 单例设计模式：懒汉式
 *
 */
public class LazybonesDemo {
	
	private static LazybonesDemo demo = null;
	
	private LazybonesDemo(){}
	
	/**
	 * 同一时间只能有一个线程进入获取单例对象
	 */
	public synchronized static LazybonesDemo getInstance(){
		if(demo == null){
			demo = new LazybonesDemo();
		}
		return demo;
	}
	
}
