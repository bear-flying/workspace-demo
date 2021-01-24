package com.javase.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampTest {

	static Timestamp ts = new Timestamp(System.currentTimeMillis());

	public static void main(String[] args) {

		//String ->Timestamp
		simple1(ts);

		//Timestamp -> String
		simple2(ts);

		//Timestamp -> Date
		simple3(ts);

		//Date -> Timestamp
		simple4(ts);

	}

	//String ->Timestamp
	private static void simple1(Timestamp ts) {

		String tsStr = "2011-05-09 11:49:45";
		try {
			ts = Timestamp.valueOf(tsStr);
			System.out.println(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	//Timestamp -> String
	private static void simple2(Timestamp ts) {

		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			//方法一
			tsStr = sdf.format(ts);
			System.out.println(tsStr);
			//方法二
			tsStr = ts.toString();
			System.out.println(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Timestamp -> Date
	private static void simple3(Timestamp ts) {

		Date date = new Date();
		try {
			date = ts;
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Date -> Timestamp
	private static void simple4(Timestamp ts) {

		ts = new Timestamp(new Date().getTime());
	}

}
;