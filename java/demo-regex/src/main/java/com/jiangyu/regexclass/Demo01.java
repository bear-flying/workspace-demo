package com.jiangyu.regexclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author JiangYu
 * 
 * 验证字符串与正则是否匹配
 * 
 * Pattern类的compile()、matcher()方法
 * Matcher类的marches()方法
 * Pattern类的marches()方法
 */
public class Demo01 {

	public static void main(String[] args) {
		//将文字匹配规则编译为模式；即定义模版，创建对象
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");//创建匹配对象
		System.out.println(m.matches()?"匹配":"不匹配");//执行匹配
		//仅使用一次正则表达式进行匹配时，可以简单如下操作：
		System.out.println(Pattern.matches("a*b", "aaaaab")?"匹配":"不匹配");	//执行匹配
		//进一步简写
		System.out.println(Pattern.compile("a*b").matcher("aaaaab").matches()?"匹配":"不匹配");
	
		//匹配哈尔滨座机号
		System.out.println(Pattern.matches("0451-\\d{8}","0451-12345678"));//true

	}

}
