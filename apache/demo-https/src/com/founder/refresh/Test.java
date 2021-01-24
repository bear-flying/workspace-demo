package com.founder.refresh;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		List<String> urls = new ArrayList<String>();
		List<String> dirs = new ArrayList<String>();
		
		urls.add("http://zqb.cyol.com/html/2017-01/11/nbs.D110000zgqnb_01.htm");
		urls.add("http://zqb.cyol.com/html/2017-01/11/nw.D110000zgqnb_20170111_2-04.htm");
		dirs.add("http://news.cyol.com/tiyu/");
		dirs.add("http://yuqing.cyol.com/");
		
		FounderRefresh.refresh(urls, dirs);
		
	}
	
}
