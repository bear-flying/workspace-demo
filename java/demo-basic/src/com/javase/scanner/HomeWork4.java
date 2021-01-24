package com.javase.scanner;

import java.util.Scanner;

public class HomeWork4 {
	//	5.	接收一个字符串变量，实现获取对字符串中数字字符，最终返回值字符串。
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("请输入：");

		String str = input.nextLine();//接受一行

		//转换成字符数组
		char [] ch = str.toCharArray();

		String laString="";

		for (int i = 0; i < ch.length; i++) {

			if(ch[i]==' '){
				continue;

			}else if(Character.isLetter(ch[i])){
				continue;
			}
			laString=laString+ch[i];
		}
		System.out.println(laString);

	}

}
