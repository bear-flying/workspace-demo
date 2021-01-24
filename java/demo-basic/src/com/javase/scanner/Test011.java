package com.javase.scanner;

import java.util.Scanner;

//6：一球从100米高度自由落下，
//每次落地后反跳回原高度的一半；再落下，
//求它在第10次落地时，共经过多少米？第10次反弹多高？（****）

public class Test011 {

	public static void main(String[] args) {

		System.out.println("输入次数：");
		Scanner sc =new Scanner(System.in);

		int count =sc.nextInt();
		int zong=100;
		for(int i=1;i<=count;i++){
			zong=zong/2;
		}
		System.out.println(zong);
	}
}
