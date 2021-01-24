package com.bee.inteceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class InteceptorOne extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("lanjieqi ++++++++++++++++++++++++=");
		Object user = ActionContext.getContext().getSession().get("user");
		
		
		if(user==null){
			System.out.println(user);
			ActionSupport action = (ActionSupport)invocation.getAction();
			action.addActionError(action.getText("空！！！"));
	    	return "input";
		}
		return invocation.invoke();
	}
	
//	public String intercept2(ActionInvocation invocation) throws Exception {
//		
//		//context为上下文对象
//		ActionContext context = invocation.getInvocationContext();
//		//取session  
//		Map<String, Object> session = context.getSession();
//		//session取用户
//		User u = (User)session.get("user");
//		if(u==null){
//			//因为这个类没有继承ActionSupport 所以想要使用LOGIN常量返回登陆页面 必须用接口.LOGIN
//			return Action.LOGIN;
//		}else{
//			return invocation.invoke();
//		}
//		
//	}
	
}
