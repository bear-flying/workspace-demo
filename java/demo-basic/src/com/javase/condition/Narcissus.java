package com.javase.condition;

public class Narcissus {

	/**
	 *
	 * 打印出所有的“水仙花数”，所谓“水仙花”是指一个三位数，
	 * 其各位数字立方和等于该数本身。
	 *
	 * 例如：153是一个“水仙花数”，因为153=1的三次方+5
	 * 的三次方+3的三次方。
	 *
	 * 程序分析：利用for循环控制100-999个数，每个数分解
	 * 出个位，十位，百位。
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0;
		for(int i=101;i<=999;i++){
			int bw = i/100;		//求百位
			int sw = (i/10)%10; //求十位
			int gw = i%10;		//求个位
			int sum = bw*bw*bw+sw*sw*sw+gw*gw*gw;
			if(i==sum){
				System.out.printf("%d为水仙花数\n",i);
				count++;
			}
		}
		System.out.println("共"+count);
	}

}
