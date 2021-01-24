package com.javase.condition;

/**
 *
 * @author JiangYu
 *
 * 已知学生成绩以100分为满分，共分5个等级：A,B,C,D,E。
90～100为等级A，80～89为等级B，70～79为等级C，
60～69为等级D，0～59为等级E。
要求定义一个成绩变量，当成绩变化时，可直接知道该成绩对应的等级。
例如：当成绩为100时，该学生的等级时A。
 *
 */
public class IfDemo03 {

	public static void main(String[] args) {
		char ch = getLevel(35);
		System.out.println("level="+ch);
	}

	//定义一功能，通过给定分数，获取该分数对应的等级。
		/*
		1，明确该功能的结果：等级 char
		2，有没有未知内容。分数。int
		*/
	public static char getLevel(int num)
	{
		char level;
		if(num>=90 && num<=100)
			level = 'A';
		else if(num>=80 && num<=89)
			level = 'B';
		else if(num>=70 && num<=79)
			level = 'C';
		else if(num>=60 && num<=69)
			level = 'D';
		else
			level = 'E';

		return level;
	}

}
