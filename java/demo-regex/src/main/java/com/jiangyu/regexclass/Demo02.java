package com.jiangyu.regexclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author JiangYu
 * 
 * 查找替换
 * 
 * Pattern类的compile()、matcher()方法
 * Matcher类的replaceAll()方法
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("f");
		Matcher m = p.matcher("jfsdlkajflkds");
		String s = m.replaceAll("*");// 将匹配上的位置全部替换成*
		System.out.println(s);// j*sdlkaj*lkds
	}

}
