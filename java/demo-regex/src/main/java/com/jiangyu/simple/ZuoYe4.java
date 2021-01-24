package com.jiangyu.simple;

import java.util.Scanner;

public class ZuoYe4 {

	

	/**
	 * 输入一个字符串，
	 * 分别统计字符串中字母，数字，
	 * 特殊符号的个数，并打印。
	 */
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String ss=sc.next();
		String regex1="[0-9]";
		String regex2="[a-zA-Z]";
		String regex3="[^0-9&&[^a-zA-Z]]";
		int sum=0;
		int sun=0;
		int sub=0;
		for(int i =0;i<ss.length();i++){
			
			Character j=ss.charAt(i);
			String k=j.toString();
			if(k.matches(regex1)){
				sum+=1;
			}
			if(k.matches(regex2)){
				sun+=1;
			}
			if(k.matches(regex3)){
				sub+=1;
			}
			
		}
		System.out.println("   共"+sum+"个数字.");
		System.out.println("   共"+sun+"个字母.");
		System.out.println("   共"+sub+"个特殊符号.");
	}

}
