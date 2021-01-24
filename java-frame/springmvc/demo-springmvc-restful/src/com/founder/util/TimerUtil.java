package com.founder.util;

public class TimerUtil {
	
	public static String convert(long milTime){
		
		long day = milTime / (1000 * 60 * 60 * 24);
		milTime = milTime % (1000 * 60 * 60 * 24);
		long hour = milTime / (1000 * 60 * 60);
		milTime = milTime % (1000 * 60 * 60);
		long min = milTime / (1000 * 60);
		milTime = milTime % (1000 * 60);
		long sec = milTime / 1000;
		milTime = milTime % 1000;
		return day + " Days " + hour + " Hours " + min + " Minutes " + sec + " Seconds " + milTime + " millSeconds";
		
	}

}
