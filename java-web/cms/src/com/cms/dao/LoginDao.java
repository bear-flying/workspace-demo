package com.cms.dao;

import java.util.List;

import com.cms.pojo.User;
import com.xiaobai.utils.BaseDao;

public class LoginDao {

	private BaseDao dao = new BaseDao();
	
	public User getUserByLoginName(String login_name){
		User user = null;
		String sql = "select * from a_user where login_name='"+login_name+"'";
		List<User> all = dao.queryAll(User.class, sql);
		if(all != null && !all.isEmpty()){
			user = all.get(0);
		}
		return user;
	}
	
	
	
}
