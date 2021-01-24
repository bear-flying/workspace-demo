package com.bee.service;

import com.bee.dao.UserDao;
import com.bee.pojo.User;

public class UserService {

	private UserDao dao = new UserDao();
	
	public int login(User user) {
		// TODO Auto-generated method stub
		String sql = " select * from t_user where uname ="+user.getUname();
		User u = dao.findAllBySql(User.class, sql).get(0);
		int result;
		if(u==null){
			result=1;
		}else{
			if(user.getPwd().equals(u.getPwd())){
				result =  0;
			}else{
				result =  2;
			}
		}
		return result;
	}

	public User getUser(String uname) {
		// TODO Auto-generated method stub
		String sql = " select * from t_user where uname = "+uname;
		
		return dao.findAllBySql(User.class, sql).get(0);
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		dao.addOne(user);
	}

	
}
