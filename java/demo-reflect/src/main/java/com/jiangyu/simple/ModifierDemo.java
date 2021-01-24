package com.jiangyu.simple;

import java.lang.reflect.Modifier;

/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的类修饰符。
 * 
 * 在反射技术中心使用了Modifier类来描述类修饰符对象。
 *
 */
public class ModifierDemo {
	
	public static void main(String[] args) {
		Class c = Person.class;
		int m = c.getModifiers();
		if (Modifier.isPublic(m)) {
			System.out.println("public");
		}
		if (Modifier.isAbstract(m)) {
			System.out.println("abstract");
		}
		if (Modifier.isFinal(m)) {
			System.out.println("final");
		}
		String[] names = c.getName().split("\\.");
		System.out.print(names[names.length - 1]);
		Class superClass = c.getSuperclass();
		if (superClass != null) {
			String[] names2 = superClass.getName().split("\\.");
			System.out.print(names2[names2.length - 1] + "");
		}
	}
}
