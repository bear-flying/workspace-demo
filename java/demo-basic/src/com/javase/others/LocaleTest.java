package com.javase.others;

import java.util.Locale;

public class LocaleTest {
	
	public static void main(String[] args) {
		Locale locale = new Locale("zh","CN");//Locale locale = Locale.CHINA;
		System.out.println(locale.getCountry());//CN
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());//zh
		System.out.println(locale.getDisplayLanguage());
		System.out.println(locale.getDefault());//zh_CN	
	}
}
