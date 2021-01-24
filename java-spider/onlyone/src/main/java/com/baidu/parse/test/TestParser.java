package com.baidu.parse.test;

import java.util.List;

import com.baidu.parse.controller.ParseController;
import com.baidu.parse.pojo.Comment;
import com.baidu.utils.SmallParse;

public class TestParser {
 
	public static void main(String[] args) {
		

		ParseController p = new ParseController();
		
		p.parseAll();
		
		
//		SmallParse parser = new SmallParse("http://mm.10086.cn/android/info/300008258715.html?from=www&fw=521#hotcom");
//		
//		
//		List<String> list2 = parser.parseDetal();
//		
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i));
//		}

	}
	
}
