package com.bw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class My2Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------My2Interceptor-------调用action之前------------");	
		
		String invoke = invocation.invoke();
		
		System.out.println("------My2Interceptor-------调用action之后------------");
		
		return invoke;
	}

}
