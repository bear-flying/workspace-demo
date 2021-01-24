package com.jiangyu.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 
 * @author JiangYu
 * 
 * 通过Class对象获取到对应的泛型。
 * 
 * 在反射技术中心使用了Method类来描述泛型对象。
 *
 */
public class TypeDemo {

	public static void main(String[] args) {
		Class clazz = Person.class;
		//获取带泛型的父类
		Type type = clazz.getGenericSuperclass();
		System.out.println(type);
		//获取父类的泛型
		ParameterizedType param = (ParameterizedType)type;
		Type[] typeArgs = param.getActualTypeArguments();
		System.out.println(((Class)typeArgs[0]).getName());
	}

}
