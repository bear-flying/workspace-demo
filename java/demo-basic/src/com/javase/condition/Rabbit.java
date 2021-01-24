package com.javase.condition;
import java.util.Scanner;
public class Rabbit {

	/**
	 * @param args
	 */
	public static int resultHabbit(int month){
		int small=0;
		int medium=1;
		int big=0;


		if(month<=2){
			System.out.println("1对兔子。");
			return 1;
		}else{
			big+=medium;
			medium=small;
			small=big;


			return (big+medium+small);

		}
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("请输入月份:");
		Scanner scan = new Scanner(System.in);
		int month =scan.nextInt();

		resultHabbit(month);


	}
}

		
		