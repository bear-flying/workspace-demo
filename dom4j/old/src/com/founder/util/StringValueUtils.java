package com.founder.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringValueUtils {
	
	//日志工具类
	private static Log log = LogFactory.getLog(StringValueUtils.class);
	
	/**
	 * 安全的将String类型转换为int类型变量
	 * 
	 * @param strValue	要转换的字符串
	 * 
	 * @return int类型变量，默认返回0
	 */
	public static int getInt(String strValue){
		return getInt(strValue,0);
	}
	
	/**
	 * 安全的将String类型转换为int类型变量
	 * 
	 * @param	strValue	要转换的字符串
	 * @param	defaultValue
	 * 
	 * @return int类型变量，默认返回defaultValue
	 */
	public static int getInt(String strValue, int defaultValue){
		int iRet = defaultValue;
		if(strValue!=null && strValue.trim().length()>0){
			try{
				iRet = Integer.parseInt(strValue);
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
		return iRet;
	}
	
	/**
	 * 安全的将String类型转换为long类型变量
	 * 
	 * @param strValue	要转换的字符串
	 * 
	 * @return long类型变量，默认返回0
	 */
	public static long getLong(String strValue){
		return getLong(strValue,0);
	}
	
	/**
	 * 安全的将String类型转换为long类型变量
	 * 
	 * @param	strValue	要转换的字符串
	 * @param	defaultValue
	 * 
	 * @return long类型变量，默认返回defaultValue
	 */
	public static long getLong(String strValue, long defaultValue){
		long iRet = defaultValue;
		if(strValue!=null && strValue.trim().length()>0){
			try{
				iRet = Long.parseLong(strValue);
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
		return iRet;
	}
	
	/**
	 * 安全的将String类型转换为long类型变量
	 * 
	 * @param	strValue	要转换的字符串
	 * @param	defaultValue
	 * 
	 * @return long类型变量，默认返回defaultValue
	 */
	
}
