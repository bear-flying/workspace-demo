package com.jiangyu.simple;

import java.lang.reflect.Method;

/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的方法。
 * 
 * 在反射技术中心使用了Method类来描述方法对象。
 *
 */
public class MethodDemo {

	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz = Class.forName("com.jiangyu.simple.Person");
		//获取到所有公用的方法 包括继承自父类的方法
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		//获取到所有的方法 但不包括继承自父类的方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		Person p = new Person(110, "蟋蟀");
		//第一个参数：要获取的方法的名字； 第二个及之后的参数：方法参数的Class对象
		Method m = clazz.getMethod("eat", int.class);
		//invoke执行一个方法。第一个参数：方法的调用对象； 第二的参数：方法所需的参数
		m.invoke(p, 3);//蟋蟀吃了3斤饭！
		
		//执行私有的方法
		Method m1 = clazz.getDeclaredMethod("sleep", int.class);
		//设置访问权限允许访问  可实现暴力调用私有的方法
		m1.setAccessible(true);
		m1.invoke(p, 6);//蟋蟀明天睡上6小时！
		
		//传参为数组的写法
		Method m2 = clazz.getMethod("sum", int[].class);
		m2.invoke(p, new int[]{12,5,9});
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke("abc", 1));//1.5传递不定参数
		System.out.println(methodCharAt.invoke("abc", new Object[]{2}));//1.4传递数组
		
		String startingClassName = "cn.itcast.day1.TestArguments";
		Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
		//null表示调用的方法是静态的  这时候invoke()方法的第一个参数可以传值对象 也可以传值null
		//解决方案1：再用一个数组套上一层，把当前的数组作为新数组的一个元素。
		//mainMethod.invoke(null, new Object[]{new String[]{"111","222","333"}});
		//解决方案2：数组也是一个Object  强转成Object 就相当于对编译器说 给你的是一个对象 不是数组
		mainMethod.invoke(null, (Object)new String[]{"111","222","333"});
		
	}

}
