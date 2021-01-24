package com.jiangyu.simple;

import java.util.Scanner;

public class ZuoYe5 {

	/**
	 * 接收一个字符串变量，实现获取对字符串中数字字符，最终返回值字符串。
	 */
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String ss=sc.next();
		String regex="[0-9]";
		String s ="";
		for(int i =0;i<ss.length();i++){
			Character j=ss.charAt(i);
			String k=j.toString();
			if(k.matches(regex)){
				
				s=s+k;
			}
			
		}
		System.out.println(s);

	}

}
