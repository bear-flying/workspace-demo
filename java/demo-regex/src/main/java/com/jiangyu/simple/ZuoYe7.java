package com.jiangyu.simple;

import java.util.Scanner;

public class ZuoYe7 {

	/**
	 * 输入一个字符串，实现获取对字符串中奇数
		索引的字符，最终返回值字符串。
	 */
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String ss=sc.next();
		String regex="[0-9]";
		String s ="";
		for(int i =0;i<ss.length();i++){
			String k=ss.substring(i, i+1);
			if(k.matches(regex)){
				int b = Integer.parseInt(k);
				if(b%2==0){
					continue;
				}
				s+=k;
			}
			
		}
		System.out.println(s);
	}

}
