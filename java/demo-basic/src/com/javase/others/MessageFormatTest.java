package com.javase.others;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class MessageFormatTest {

	public static void main(String[] args) {

		String str ="日期: {0}";
		Locale locale = Locale.CHINA;
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		String dateStr = dateFormat.format(date);
		String result = MessageFormat.format(str, dateStr);
		System.out.println(result);//日期： 2015年8月11日
	}

}
