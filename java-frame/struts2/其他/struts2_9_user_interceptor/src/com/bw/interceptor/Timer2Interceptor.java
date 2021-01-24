package com.bw.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Timer2Interceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//开始时间
		long start = System.currentTimeMillis();
		//System.out.println("start="+start);
		String invoke = invocation.invoke();
		//结束时间
		long end = System.currentTimeMillis();
		//System.out.println("end="+end);
		System.out.println("方法的执行效率为"+(end-start)+"ms");
		
		
		return invoke;
	}

}
