package com.bw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class My1Interceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------My1Interceptor-------调用action之前------------");	
		
		String invoke = invocation.invoke();
		
		System.out.println("------My1Interceptor-------调用action之后------------");
		
		return invoke;
	}

}
