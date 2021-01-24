package com.jiangyu.simple;
/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的包。
 * 
 * 在反射技术中心使用了Package类来描述类的包。
 *
 */
public class PackageDemo {
	public static void main(String[] args) {
		Class clazz = Person.class;
		Package pack = clazz.getPackage();		
		System.out.println(pack.getName());
	}
}
