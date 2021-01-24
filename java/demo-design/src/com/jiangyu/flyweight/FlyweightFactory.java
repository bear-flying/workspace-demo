package com.jiangyu.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * 负责创建和管理享元对象
 * @author JIAO
 *
 */
public class FlyweightFactory {
	/*
	 * 使用map来存储享元对象
	 * key:  String类型    表示享元对象的内蕴状态  name
	 * value: Flyweight  表示享元对象
	 */
	private Map<String,Flyweight> map =
			new HashMap<String,Flyweight>();

	/**
	 * 负责创建享元对象的方法
	 * 当参数name，即享元对象的内蕴在map中作为key存在时，就返回已经存在的享元对象
	 * 如果不存在，才会创建一个新的合适的享元对象，并存储在map中
	 * @param name
	 * @return
	 */
	public Flyweight factory(String name){
		Flyweight flyweight = map.get(name);
		if(flyweight==null){//不存在
			flyweight = new ConcreteFlyweight(name);//创建一个具体享元对象
			map.put(name, flyweight);
		}

		return flyweight;
	}
}
