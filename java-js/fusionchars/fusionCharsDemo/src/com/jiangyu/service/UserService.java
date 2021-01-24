package com.jiangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IUserDao;
import com.jiangyu.pojo.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return userDao.findAll("from User");
	}
	
}
