package com.javase.date;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		//取当前日历
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		printOut(c);

		//取5年后的日历
		c.add(Calendar.YEAR, 5);
		printOut(c);

		//取2011年9月1日的日历
		c = Calendar.getInstance();
		c.set(2011, 9, 1);
		/*
		c.set(Calendar.YEAR, 2011);
		c.set(Calendar.MONTH, 10);
		c.set(Calendar.DAY_OF_MONTH, 1);
		*/
		printOut(c);


	}

	private static void printOut(Calendar c) {
		//获取当前日历年份
		System.out.println(c.get(Calendar.YEAR));
		//获取当前日历月份
		System.out.println(c.get(Calendar.MONTH)+1);
		//获取当前日历日期
		System.out.println(c.get(Calendar.DATE));
	}



}
