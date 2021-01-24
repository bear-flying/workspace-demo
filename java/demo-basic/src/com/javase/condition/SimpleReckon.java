package com.javase.condition;

import java.util.Scanner;

public class SimpleReckon {

	public static void main(String[] args) {

		//求2的6次方
		simple1();
		//求2的n次方
		simple2();
		//求1-100之间的偶数和
		simple3();
		//求剩水和吞吐量
		simple4();

	}

	/**
	 * 求2的6次方
	 */
	private static void simple1() {

		int result = 1;
		for(int i=1;i<=6;i++){
			result*=2;
		}
		System.out.println(result);
	}

	/**
	 * 求2的n次方
	 */
	private static void simple2() {

		Scanner s = new Scanner(System.in);
		System.out.println("请输入指数，然后按回车.");
		int b = s.nextInt();
		int result = 1;
		for(int i =1;i<=b;i++){
			result*=2;
		}
		System.out.println(result);
		s.close();
	}

	/**
	 * 求1-100之间的偶数和
	 */
	private static void simple3() {

		int sum = 0;
		for(int i= 2;i<=100;i+=2){
			sum=sum+i;//sum+=i
		}
		System.out.println(sum);

	}

	/**
	 * 求剩水和吞吐量
	 */
	private static void simple4() {
		int shengShui = 500;
		int tunTuLiang = 50;
		int count = 0;//次数
		do{
			count++;
			shengShui-=tunTuLiang;
			tunTuLiang-=5;
			System.out.println("第"+count+"次后，剩水："+(shengShui>0?shengShui:0)+",吞量"+tunTuLiang);
		}while(shengShui>=0);

	}

}
