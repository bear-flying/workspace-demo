package com.javase.condition;

public class Count {

	/**
	 * 求1/1+1/2+1/3+……+1/100的值
	 * 要求双精度  保留两位小数
	 */

	//main方法  主方法入口
	public static void main(String[] args) {
		//定义一个浮点型的变量sum
		double sum=0 ;
		//定义一个浮点型的变量count
		double count;
		//利用for循环  循环100次
		for(count=1.00;count<=100;count++){
			//把每次的结果叠加给count
			sum+=1/count;
		}
		//打印输出最后的结果
		System.out.printf("最后的结果为%5.2f",sum);
	}

}
