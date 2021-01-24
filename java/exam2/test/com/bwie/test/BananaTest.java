package com.bwie.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.bwie.exam.Banana;

public class BananaTest {

	@Test
	public void test1() {

		Class clazz = Banana.class;
		
		Field[] f = clazz.getDeclaredFields();
		
		for (Field field : f) {
			System.out.println(field.getName());
		}
	
	}

	
	@Test
	public void test2() {

		Class clazz = Banana.class;
		
		Field[] f = clazz.getFields();
		
		for (Field field : f) {
			System.out.println(field.getName());
		}
	
	}
	
	
	@Test
	public void test3() {

		Class clazz = Banana.class;
		
		Method[] m = clazz.getDeclaredMethods();
		
		for (Method method : m) {
			System.out.println(method.getName());
		}
	}
	
	
	@Test
	public void test4() {

		Class clazz = Banana.class;
		
		System.out.println(clazz.getName());
	
	}
}
