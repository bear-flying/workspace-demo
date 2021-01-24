package com.bwie.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/*
 *   1. 为什么使用泛型 
 *     *解决了元素储存的安全性问题
 *     *解决获取元素时，需要类型转换的问题
 *     *将运行时错误提前到编译时，提升了开发效率
 *     
 *   2. 对常用的泛型使用方式的学习
 */
public class GenericTest {

	@Test
	public void test() {
		
		List list = new ArrayList();
		
		list.add(65);
		list.add(60);
		list.add(55);
		
		//没有使用泛型，任何Object及其子类型的对象都可以添加进来
		list.add("tom");
		
		for(int i = 0 ; i < list.size(); i++)
		{
			//强转为Integer类型时，可能会发生ClasCastException的异常
			int score = (Integer) list.get(i);
			System.out.println(score);
		}
		
	}

	@Test
	public void test2()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(65);
		list.add(60);
		list.add(55);
		
//		list.add("tom");
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
	}
	
	@Test
	public void test3()
	{
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("金腊梅", 44);
		map.put("刘涛", 4);
		map.put("赵海龙", 28);
		
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		
		for(Map.Entry<String, Integer> o : set)
		{
			System.out.println(o.getKey() + " : "+ o.getValue());
		}
		
	}
	
}
