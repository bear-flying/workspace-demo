package com.javase.date;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat shortFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		DateFormat longFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		DateFormat fullFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		//format方法--》把Date类型转为字符串
		System.out.println(shortFormat.format(date));//17-3-19 下午6:01
		System.out.println(mediumFormat.format(date));//2017-3-19 18:01:44
		System.out.println(longFormat.format(date));//2017年3月19日 下午06时01分44秒
		System.out.println(fullFormat.format(date));//2017年3月19日 星期日 下午06时01分44秒 CST
	}

}
