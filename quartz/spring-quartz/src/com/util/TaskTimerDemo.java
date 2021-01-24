package com.util;

import java.util.TimerTask;

public class TaskTimerDemo extends TimerTask{
	Integer flag = 1;
	@Override
	public void run() {
		System.out.println("你好！"+(flag++));
		
	}

}
