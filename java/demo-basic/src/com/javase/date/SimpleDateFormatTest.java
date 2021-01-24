package com.javase.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest {

	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {

		//Date-->String
		simple1(sdf1);
		//Calendar-->String
		simple2(sdf1);
		//String-->Date-->Calendar
		simple3(sdf2);
		
	}

	//Date-->String
	private static void simple1(SimpleDateFormat sdf1) {

		Date now = new Date();
		System.out.println(sdf1.format(now));
	}

	//Calendar-->String
	private static void simple2(SimpleDateFormat sdf1) {

		Calendar c = Calendar.getInstance();
		c.set(2011, 9, 1, 12, 13, 14);
		c.set(Calendar.MILLISECOND, 1);
		Date d = c.getTime();
		System.out.println(sdf1.format(d));
	}

	//String-->Date-->Calendar
	private static void simple3(SimpleDateFormat sdf2) {
		
		try {
			String s = "2011-10-01";
			Date d1 = sdf2.parse(s);
			System.out.println(d1.getTime());
			Calendar c1 = Calendar.getInstance();
			c1.setTime(d1);
			System.out.println(c1.get(Calendar.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
