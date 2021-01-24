package com.jiangyu.recursion;

import java.util.Scanner;

public class CommonDivisor {

	public static void main(String[] args) {
		//1,辗转相除法 求最大公约数
		divisor1();
		//2,递归  求最大公约数
		divisor2();
	}

	/**
	 * 求a和b的最大公约数
	 * a=24
	 * b=36
	 * 
	 * a%b--->c=24
	 * 
	 * b->a=36
	 * c->b=24
	 * 
	 * a%b--->c=12
	 * 
	 * b->a=24
	 * c->b=12
	 * 
	 * a%b--->c=0
	 *  
	 * b=12
	 */
	private static void divisor1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int a = scan.nextInt();
		System.out.println("请再输入一个整数");
		int b = scan.nextInt();
		
		while(a%b!=0){
			int c = a%b;//a%b-->c
			a=b;//b-->a
			b=c;//c-->b
		}
		System.out.println(b);
		scan.close();
	}

	private static void divisor2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int a = scan.nextInt();
		System.out.println("请再输入一个整数");
		int b = scan.nextInt();
		System.out.println(gcd(a,b));
		
	}

	private static int gcd(int a, int b) {
		if(a==0){
			return b;
		}else{
			return gcd(b,a%b);//b-->a,a%b-->b
		}
	}

}
