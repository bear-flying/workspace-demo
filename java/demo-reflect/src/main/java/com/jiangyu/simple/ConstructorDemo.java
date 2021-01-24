package com.jiangyu.simple;

import java.lang.reflect.Constructor;

/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的方法。
 * 
 * 在反射技术中心使用了Constructor类来描述构造器对象。
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) throws Exception {
		//获取到对应的Class对象
		Class clazz = Class.forName("com.jiangyu.simple.Person");
		//获取Person类的所有公共的构造方法
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		//获取Person类的所有构造方法  包括私有的在内
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		//获取Person类中指定的构造方法
		//调用有参的构造方法
		Constructor constructor = clazz.getConstructor(int.class, String.class);
		//调用无参的构造方法
		constructor = clazz.getConstructor(null);
		//如果是私有的构造函数 需要暴力反射 否则抛出非法访问异常
		constructor.setAccessible(true);
		Person person = (Person)constructor.newInstance("999", "蜜蜂");
		System.out.println(person);
		
		Constructor constructor1 = String.class.getConstructor(StringBuffer.class);
		String str1 = (String)constructor1.newInstance(new StringBuffer("abc"));
		System.out.println(str1.charAt(2));
		//constructor1是使用String类的字节码搞出来的构造方法对象
		//这个构造方法对象到底对应着哪个类中的哪一个构造方法   在编译的时候是不知道的 
		//运行的时候才知道。
		//所以newInstance的时候必须要强制转换，告诉编译器这个方法返回的是String
		//脑子里一定要有一个牢固的思想，程序开发分为编译时和运行时。
		//例如：下面这一行编译时是没问题的 但运行时就会报错（构造方法传值类型错误）
		String str2 = (String)constructor1.newInstance("abc");
		
		
	}
}
