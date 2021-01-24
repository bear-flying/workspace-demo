package com.javase.date;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date d1 = new Date(2010,5,10);
		Date d2 = new Date(2011,5,13);
		System.out.println(d1.compareTo(d2));//-1
		System.out.println(d1.getYear());
		System.out.println(d1.getMonth());
		System.out.println(d1.getDate());
		System.out.println(d1.getDay());//星期
		//返回自1970年1月1日00:00:00 CMT以来，此Date对象表示的毫秒数
		System.out.println(d1.getTime());
		long milliseconds = d1.getTime();
		Date d3 = new Date(milliseconds);//毫秒数的构造器
		System.out.println(d1.before(d3));//false

		Date d4 = new Date();
		Date d5 = new Date();
		System.out.println(d4.after(d5));//false
	}

}
