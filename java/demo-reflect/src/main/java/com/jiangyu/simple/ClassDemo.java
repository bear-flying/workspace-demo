package com.jiangyu.simple;

public class ClassDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		//获取Class对象的方式一（推荐）：
		Class clazz1 = Class.forName("com.jiangyu.simple.Person");
		System.out.println("clazz1:" + clazz1);
		//获取Class对象的方式一：通过类名获取
		Class clazz2 = Person.class;
		System.out.println("clazz1==clazz2?" + (clazz1==clazz2));//true
		//由于.class文件只会加载到内存中一次，所以clazz1==clazz2==clazz3
		//说明使用的是同一份字节码文件
		Class clazz3 = new Person().getClass();
		System.out.println("clazz2==clazz3?" + (clazz2==clazz3));//true
		//通过类加载器获取Class对象
		ClassLoader cl = new Person().getClass().getClassLoader();
		Class clazz5 = cl.loadClass("com.jiangyu.simple.Person");
		System.out.println(clazz5.getName());
		
		Class clazz = Person.class;
		Class superClass =clazz.getSuperclass();
		if(superClass!=null){//打印父类
			System.out.println(superClass.getName());//Object
		}
		Class[] interfaces = clazz.getInterfaces();
		for (Class class1 : interfaces) {//打印所有已实现的接口
			System.out.println(class1.getName());
		}
		
		Class cls1 = "abc".getClass();
		System.out.println(cls1.isPrimitive());//false
		System.out.println(int.class.isPrimitive());//true
		System.out.println(int.class == Integer.class);//false
		System.out.println(int.class == Integer.TYPE);//true
		System.out.println(int[].class.isPrimitive());//false
		System.out.println(int[].class.isArray());//true
	}
}
