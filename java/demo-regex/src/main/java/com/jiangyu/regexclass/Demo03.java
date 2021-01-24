package com.jiangyu.regexclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo03 {

	public static void main(String[] args) {
		//解析
		Pattern p1 = Pattern.compile("((18[6-9]\\d)|(19\\d{2})|(20((0\\d)|(1[01]))))-((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2\\d)|(3[01]))");
		Matcher m1 = p1.matcher("fjaspdjflk;dsajffdskl2011-12-11djsffsdjjfds2010-01-01");
		while (m1.find()){//尝试查找与该模式匹配的输入序列的下一个子序列。
			//返回由以前匹配操作所匹配的输入子序列。
			System.out.println(m1.group());
		}
	}

}
