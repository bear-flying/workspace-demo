package com.javase.random;

public class Randomly {

	/**
	 * 随机选人
	 * @param args
	 */
	public static void main(String[] args) {

		String[] names=new String[]{"a","b","c","d"};
		java.util.Random r =new java.util.Random();
		int a = r.nextInt(names.length);//范围内随机生成数字
		System.out.println(names[a]);
	}

}
