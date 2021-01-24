package com.javasky.frame.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	/**
	 * 
	 * @param str : 目标字符串
	 * @param format ： 格式化的方式
	 * 			yyyy-MM-dd 
	 * 			yyyy/MM/dd
	 * @return
	 */
	public static Date parseDate(String str,String format){
		try {
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String format(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	
	
}
