package com.javase.collention;

//创建学生类 进行合理封装
public class Student {

	//学生姓名
	private String name;
	//学生成绩
	private double score;
	//构造器
	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	//toString方法
	@Override
	public String toString() {
		return name+"  "+score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}


}
