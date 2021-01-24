package com.javase.scanner;

import java.util.Scanner;

public class HomeWork1 {
	public static void main(String[] args) {
//		3.输入字符串，将
//		字符串的每个单词首字母大写再输出新的字符串

		Scanner input = new Scanner(System.in);

		System.out.println("请输入：");

		String str = input.nextLine();//接受一行

		//we are goOD chilDreN
		//提取出每个单词
		String[] words = str.split(" ");

		StringBuffer last=new StringBuffer("");

		//循环每个单词
		for (int i = 0; i < words.length; i++) {


			String s=words[i];

			//每个单词提取首字母和其他字母
			//首字母
			String firstLetter = s.substring(0, 1).toUpperCase();
			//其他字母
			String otherLetter = s.substring(1).toLowerCase();

			//拼接
			words[i]=firstLetter+otherLetter;
			last.append(words[i]+" ");

		}
		System.out.println(last);

	}

}
