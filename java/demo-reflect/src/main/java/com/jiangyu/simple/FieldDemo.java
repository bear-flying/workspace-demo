package com.jiangyu.simple;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的方法。
 * 
 * 在反射技术中心使用了Field类来描述方法对象。
 *
 */
public class FieldDemo {

	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz = Class.forName("com.jiangyu.simple.Person");
		//获取到所有的成员变量
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			//无输出结果  因为Person类中的成员变量全都是默认的修饰符
			//而getFields()方法只是获取公共的属性
			System.out.println(field);
		}
		Person p = new Person();
		Field field = clazz.getDeclaredField("id");
		//如果id属性是私有的 可以设置访问权限
		field.setAccessible(true);
		//第一个参数：设置该数据的成员变量; 第二个参数：属性值
		field.set(p, 110);
		System.out.println(p);
		
		int [] a1 = new int[]{1,2,3};
		int [] a2 = new int[4];
		int[][] a3 = new int[2][3];
		String [] a4 = new String[]{"a","b","c"};
		System.out.println(a1.getClass() == a2.getClass());//true
		//System.out.println(a1.getClass() == a4.getClass());
		//System.out.println(a1.getClass() == a3.getClass());
		System.out.println(a1.getClass().getName());
		System.out.println(a1.getClass().getSuperclass().getName());
		System.out.println(a4.getClass().getSuperclass().getName());
		
		System.out.println(a1);
		System.out.println(a4);
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.asList(a4));	
		
		printObject(a4);
		
		printObject("xyz");
	}

	private static void printObject(Object obj) {
		Class clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++){
				System.out.println(Array.get(obj, i));
			}
		}else{
			System.out.println(obj);
		}
	}

}
