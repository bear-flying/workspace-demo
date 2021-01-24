package com.javase.others;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Locale locale = Locale.CHINA;
		ResourceBundle rb = ResourceBundle.getBundle("i18n", locale);
		String rbDate = rb.getString("birthday");
		//处理中文乱码
		rbDate = new String(rbDate.getBytes("ISO-8859-1"),"UTF-8");
		String str = "{0}:{1}";
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
		String dStr = df.format(date);
		String result = MessageFormat.format(str, rbDate, dStr);
		System.out.println(result);
	}

}
