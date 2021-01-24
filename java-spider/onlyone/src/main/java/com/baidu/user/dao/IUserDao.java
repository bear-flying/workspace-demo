package com.baidu.user.dao;

import java.util.List;

import com.baidu.user.pojo.User;

public interface IUserDao {

	void register(User user);

	User checkLoginname(String loginName);

	User checkIsfirst(String social_uid);

	void finishOtherMsg(User user);
	
	List<User> getList();

}
