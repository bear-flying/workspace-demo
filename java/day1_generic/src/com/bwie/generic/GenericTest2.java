package com.bwie.generic;

import java.util.List;

import org.junit.Test;

/*
 *  1. 当实例化泛型类的对象时，指明泛型的类型，指明以后，对应的类中所有使用泛型的位置。都变为实例化中泛型的类型。
 *  
 *  2. 如果我们自定义了泛型类，但是在实例化时没有使用，那么默认类型是Object类型。
 */
public class GenericTest2 {

	@Test
	public void test() {
		
		Order<Boolean> order = new Order<Boolean>();
		
		order.setT(false);
		
//		System.out.println(order.getT());
		
		order.add();
		
		List<Boolean> list = order.getList();
		
		System.out.println(list);
	}
	
}
