package com.javase.condition;
import java.util.Scanner;
public class IfDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入数字：");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num%2==0){
			System.out.print("偶数");
		}else{
			System.out.print("奇数");
		}
		scan.close();
	}

}
