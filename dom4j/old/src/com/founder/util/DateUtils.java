package com.founder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils extends org.apache.commons.lang.time.DateUtils {

	private static Log log = LogFactory.getLog(DateUtils.class);
	
	private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 将时间转换为指定的时间格式
	 * 
	 * @param	date
	 *				要进行转换的时间,如果为null则取系统时间
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return 转换后的字符串
	 */
	public static final String formatDate(Date date, String format) {
		if(date==null){date = new Date();}
		if(format==null || format.trim().length()==0){format = DEFAULT_DATETIME_FORMAT;}
		return org.apache.commons.lang.time.DateFormatUtils.format(date, format);
	}
	
	/**
	 * 将时间转换为指定的时间格式
	 * 
	 * @param	date
	 *				要进行转换的时间,如果为0则取系统时间
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return 转换后的字符串
	 */
	public static final String formatDate(long date, String format) {
		if(date==0){date = System.currentTimeMillis();}
		if(format==null || format.trim().length()==0){format = DEFAULT_DATETIME_FORMAT;}
		return org.apache.commons.lang.time.DateFormatUtils.format(date, format);
	}
	
	/**
	 * 将时间转换为指定的时间格式
	 * 
	 * @param	date
	 *				要进行转换的时间,如果为0则取系统时间
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return 转换后的字符串
	 */
	public static final String formatDate(Calendar date, String format) {
		if(date==null){date = Calendar.getInstance(Locale.getDefault());}
		if(format==null || format.trim().length()==0){format = DEFAULT_DATETIME_FORMAT;}
		return org.apache.commons.lang.time.DateFormatUtils.format(date, format);
	}

	/**
	 * 将当前时间转换为指定的时间格式
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return 当前时间字符串
	 */
	public static final String getNow(String format) {
		if(format==null || format.trim().length()==0){format = DEFAULT_DATETIME_FORMAT;}
		return org.apache.commons.lang.time.DateFormatUtils.format(new Date(), format);
	}


	/**
	 * 将String转换成Date类型
	 * 
	 * @param	dateStr
	 * 				如果为空则返回当前系统时间
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return Date类型
	 */
	public static final Date convertString2Date(String dateStr, String format) {
		if(format==null || format.trim().length()==0){format = DEFAULT_DATETIME_FORMAT;}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			if(dateStr!=null && dateStr.trim().length()>0){
				date = sdf.parse(dateStr);
			}
		} catch (ParseException e) {
			date = new Date();
			log.error("字符串转换为时间错误，格式化字符串 - "+format+"，时间字符串 - "+dateStr);
		}
		return date;
	}
	
	/**
	 * 将String转换成Date类型
	 * 
	 * @param	dateStr
	 * 				如果为空则返回当前系统时间
	 * @param	format
	 * 				格式化字符串,如果参数为null或为空则取默认时间格式，即"yyyy-MM-dd HH:mm:ss"
	 * @return	Calendar类型
	 */
	public static final Calendar convertString2Calendar(String dateStr, String format) {
		return convertDate2Calendar(convertString2Date(dateStr,format));
	}
	
	
	/**
	 * 将Calendar转换成Date类型
	 * 
	 * @param calendar
	 *            如果为空则取当前系统时间
	 * @return Date类型
	 */
	public static final Date convertCalendar2Date(Calendar calendar) {
		if(calendar==null){
			calendar=Calendar.getInstance(Locale.getDefault());
			calendar.setTimeInMillis(System.currentTimeMillis());
		}
		return calendar.getTime();
	}
	
	/**
	 * 将Date转换成Calendar类型
	 * 
	 * @param date
	 *            如果为空则取当前系统时间
	 * @return Calendar类型
	 */
	public static final Calendar convertDate2Calendar(Date date) {
		if(date==null){
			date = new Date();
		}
		Calendar cal = Calendar.getInstance(Locale.getDefault());
		cal.setTime(date);
		return cal;
	}

	/**
	 * 从指定的日期中获取年份信息
	 * 
	 * @param date
	 *            日期
	 * 
	 * @return 年份
	 */
	public static final int getYear(Date date) {
		return getField(date, Calendar.YEAR);
	}

	/**
	 * 从指定的日期中获取月份信息
	 * 
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static final int getMonth(Date date) {
		return getField(date, Calendar.MONTH) + 1;
	}

	/**
	 * 从指定的日期中获取日信息
	 * 
	 * @param date
	 *            日期
	 * @return 日
	 */
	public static final int getDate(Date date) {
		return getField(date, Calendar.DATE);
	}

	/**
	 * 从指定的日期中获取相应的信息
	 * 
	 * @param date
	 *            指定日期，如果为null则取系统时间
	 * @param field
	 *            信息类型(同Calendar中的定义)
	 * @return 日期中指定类型的值
	 */
	public static final int getField(Date date, int field) {
		if(date==null){date=new Date();}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}
	
	/**
	 * 得到指定日期的前一天
	 * @param	date
	 * 				给定的当前日期，如果为null，则取系统的当前时间
	 * @return	返回指定日期的前一天
	 * */
	public static final Date getPreviousDate(Date date){
		if(date==null){
			date = new Date();
		}
		return org.apache.commons.lang.time.DateUtils.addDays(date, -1);
	}
	
	/**
	 * 得到指定日期的后一天
	 * @param	date
	 * 				给定的当前日期，如果为null，则取系统的当前时间
	 * @return	返回指定日期的后一天
	 * */
	public static final Date getNextDate(Date date){
		if(date==null){
			date = new Date();
		}
		return org.apache.commons.lang.time.DateUtils.addDays(date, 1);
	}
	
	public static void main(String[] args){
		System.out.println(System.currentTimeMillis());
		System.out.println(1306910894);
		System.out.println(DateUtils.formatDate(1369152000*1000L,null));
		System.out.println(DateUtils.convertString2Date("2013-08-01 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime());
	}
}
