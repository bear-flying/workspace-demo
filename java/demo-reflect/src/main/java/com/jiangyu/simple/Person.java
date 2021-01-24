package com.jiangyu.simple;

public class Person {

	int id;
	
	String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Person(){}
	
	public void eat(){
		System.out.println(name + "吃很多饭！");
	}
	
	public void eat(int num){
		System.out.println(name + "吃了" + num + "斤饭！");
	}

	private void sleep(int num){
		System.out.println(name + "明天睡上" + num + "小时！");
	}
	
	public void sum(int[] arr){
		System.out.println("长度是：" + arr.length);
	}
	
	@Override
	public String toString() {
		return "编号：" + this.id + ", 姓名：" + this.name;
	}
	
	
}
