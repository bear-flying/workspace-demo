package com.cms.service;

import com.cms.dao.LoginDao;
import com.cms.pojo.User;

public class LoginService {

	private LoginDao dao = new LoginDao();
	/**
	 * 此处用枚举最好 这里暂用int
	 * @param login_name
	 * @param password
	 * @return
	 */
	public int checkLogin(String login_name,String password){
		
		int result = 0;
		
		User user = dao.getUserByLoginName(login_name);
		
		if(user==null){
			result = 1; //用户名不存在
		}else{
			if(user.getPassword().equals(password)){
				result = 0; //登陆成功
			}else{
				result = 2; //密码错误
			}
		}
		
		return result;
	}
	
	public User getUserByLoginName(String login_name){
		
		return dao.getUserByLoginName(login_name);
	}
	
}
