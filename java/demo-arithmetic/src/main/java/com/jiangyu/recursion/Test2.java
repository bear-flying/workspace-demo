package com.jiangyu.recursion;
/**
 * 
 * 斐波那契数列：1 1 2 3 5 8 13 21 34.。。。。。。。
 * 又叫 求兔子数：有一对兔子，从出生后第三个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月
 * 的兔子总数为多少？程序分析：兔子的规律为数列1，1，2，3，5，8，
 * 13，21。。。
 *
 */
public class Test2 {
	public static void main(String[] args) {
		//打印斐波那契数列的前20个
		for (int i = 1; i <=20; i++) {
			System.out.print(getFeiBoNa(i)+",");
		}
	}
	private static int getFeiBoNa(int i) {//i为第几个数
		if(i==1 || i==2){
			return 1;
		}else{
			return getFeiBoNa(i-1)+getFeiBoNa(i-2);	
		}	
	}
}
