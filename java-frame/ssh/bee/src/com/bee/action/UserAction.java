package com.bee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.bee.pojo.User;
import com.bee.service.UserService;
import com.bee.utils.CheckUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	UserService service = new UserService();
	
	private User user = new User();
	
	public String login() throws IOException, ServletException{
		
		System.out.println("~~~~~Login~~~~~");
		//System.out.println(user);
		String yzm = request.getParameter("yzm");
		Object code = request.getSession().getAttribute("randomCode");
		//System.out.println(code);
		if(yzm==null||yzm.trim()==""){
			request.setAttribute("error", "验证码为空！");
			return INPUT;
		}
		if(!yzm.equals(code.toString())){
			request.setAttribute("error", "验证码不正确！");
			return INPUT;
		}
		int result = service.login(user);
		//System.out.println(result);
		if(result==0){
			//System.out.println(user.getUname());
			user = service.getUser(user.getUname());
			String isSave = request.getParameter("isSave");
			if(isSave!=null&&isSave.trim().equals("y")){
				Cookie cookie1 = new Cookie("username",user.getUname());
				Cookie cookie2 = new Cookie("password",user.getPwd());
				cookie1.setMaxAge(7*24*60*60);
				cookie2.setMaxAge(7*24*60*60);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			ActionContext.getContext().getSession().put("user", user);
			System.out.println(user);
			return SUCCESS;
		}else{
			request.setAttribute("error", result==1?"无此用户！":"密码不正确！");			
			return INPUT;
		}
		//System.out.println(user);
		
	}

	public String toReg(){
		
		System.out.println("~~toReg~~");
		return "reg";
	}
	
	public void check(){
		
		System.out.println("~~check~~");
		System.out.println(user);
		String uname = user.getUname();
		CheckUtils.getAjaxResult(User.class, uname);
	}
	
	public String register(){
		
		System.out.println("~~register~~");
		service.add(user);
		return "ress";
	}
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
