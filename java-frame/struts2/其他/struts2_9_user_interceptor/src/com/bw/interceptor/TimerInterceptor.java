package com.bw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TimerInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
		//开始时间
		long start = System.currentTimeMillis();
		String invoke = invocation.invoke();
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("方法的执行效率为"+(end-start)+"ms");
		
		
		return invoke;
	}

}
