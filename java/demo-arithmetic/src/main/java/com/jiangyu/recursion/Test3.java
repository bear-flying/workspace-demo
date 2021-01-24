package com.jiangyu.recursion;

import java.util.Scanner;

public class Test3 {
	/**
	 * 阶乘 1*2*3*。。。*10
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		
		int num=input.nextInt();
		
		System.out.println(jiecheng(num));
		
		
	}

	/**
	 * 利用递归求阶乘
	 * @param num
	 */
	private static long jiecheng(int num) {
		
		if(num==1){
			return 1;
		}else{
			return num*jiecheng(num-1);
		}
		
		
	}

}
