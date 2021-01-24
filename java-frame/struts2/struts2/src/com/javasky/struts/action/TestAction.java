package com.javasky.struts.action;

public class TestAction {

	//没指定的情况下 默认走excute方法 返回类型是String的
	public String execute(){
		
		return "success";//返回struts.xml里的name为success的result
	}
	
	
}
