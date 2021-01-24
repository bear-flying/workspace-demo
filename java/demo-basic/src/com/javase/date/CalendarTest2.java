package com.javase.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest2 {

	public static void main(String[] args) {

		//求某年某月某日所在的周是这一年中的第几周
		simple1();
		//求某年的第几周的星期几是多少号
		simple2();
		//求某日前多少天或后多少天是几号
		simple3();
		//计算两个任意时间中间的间隔天数
		simple4();

	}

	//求某年某月某日所在的周是这一年中的第几周
	private static void simple1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		System.out.println("请输入月份：");
		int month = scan.nextInt();
		System.out.println("请输入日期：");
		int day = scan.nextInt();

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.printf("%d年%d月%d日所在的周是这一年中的等%d周",year,month,day,weekNo);
		scan.close();
	}

	//求某年的第几周的星期几是多少号
	private static void simple2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		System.out.println("请输入第几周：");
		int weekNo = scan.nextInt();
		System.out.println("请输入星期几：");
		int week = scan.nextInt();

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekNo);
		cal.set(Calendar.DAY_OF_WEEK, week+1);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(cal.getTime()));
		scan.close();
	}

	//求某日前多少天或后多少天是几号
	private static void simple3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		System.out.println("请输入月份：");
		int month = scan.nextInt();
		System.out.println("请输入日期：");
		int day = scan.nextInt();
		//Calendar类的add()方法，输入正数就某日后多少天，输入负数就是某日前多少天。
		System.out.println("请输入你想多少天前或多少天后的天数：");
		int days = scan.nextInt();

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);//1月从0开始
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.DATE, days);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(cal.getTime()));
		scan.close();
	}

	//计算两个任意时间中间的间隔天数
	private static void simple4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		System.out.println("请输入月份：");
		int month = scan.nextInt();
		System.out.println("请输入日期：");
		int day = scan.nextInt();

		System.out.println("请输入年份：");
		int year2 = scan.nextInt();
		System.out.println("请输入月份：");
		int month2 = scan.nextInt();
		System.out.println("请输入日期：");
		int day2 = scan.nextInt();

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);//1月从0开始
		cal.set(Calendar.DAY_OF_MONTH, day);

		Calendar cal2 = Calendar.getInstance();
		cal2.clear();
		cal2.set(Calendar.YEAR, year);
		cal2.set(Calendar.MONTH, month-1);//1月从0开始
		cal2.set(Calendar.DAY_OF_MONTH, day);


		long c1 = cal.getTimeInMillis();
		long c2 = cal.getTimeInMillis();
		//毫秒转天
		System.out.println(Math.abs(c2-c1)/(1000*60*60*24));


	}

}
