package com.bwie.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericTest3 {

	@Test
	public void test() {
		
		//多态, 父类引用指向子类对象
		Object obj = null ;
		String str = "赵海龙" ;
		obj = str;
		
		Object[] obj2 = null ;
		String[] str2 = new String[]{"赵海龙","赵河龙"};
		obj2 = str2 ;
		
		//若类A是类B的子类，那么List<A> 并不是 List<B>的子接口
		List<Object> objList = null ;
		List<String> strList = new ArrayList<String>();
//		objList = strList ;（×）
	}

	/*
	 *  ? 通配符
	 */
	@Test
	public void test2(){
		
		List<?> list = null ;
		
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		list = list1 ;
		list = list2 ;
		
	}
	
	/*
	 *  ？ extends A : 可以存放A及其子类
	 *  ? super A : 可以存放A及其父类
	 */
	@Test
	public void test3()
	{
		List<? extends Number> list = null ;
		List<Object> objList = null ;
		List<Integer> inList = null ;
		
		list = inList ;
//		list = objList ;
		
		List<? super Number> list2 = null ;
		
//		list2 = inList ;
		list2 = objList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
