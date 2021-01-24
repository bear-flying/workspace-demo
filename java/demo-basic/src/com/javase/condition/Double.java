package com.javase.condition;

/**
 * Demo: 双位数
 */
public class Double {

	public static void main(String[] args) {
		/*
		int i=10;
		while(i<100){
			System.out.println(i);
			i++;
		}
		*/
		int i=101;
		int sum=0;
		while(i<200){
			if(i%3==0&&i%7!=0){
				sum+=i;
			}
				i++;	
		}
		System.out.println(sum);
	}

}
