package com.baidu.user.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.user.dao.IUserDao;
import com.baidu.user.pojo.User;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void register(User user) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 29);
		user.setId(uuid);
		userDao.register(user);
	}

	@Override
	public void login(User user) throws Exception {
		// TODO Auto-generated method stub
		User u = userDao.checkLoginname(user.getLoginName());
		if(u==null){
			throw new Exception("无此用户！");
		}
		if(!(user.getPassword().equals(u.getPassword()))){
			throw new Exception("密码错误！");
		}
	}

	@Override
	public Boolean checkIsfirst(String social_uid) {
		// TODO Auto-generated method stub
		User u = userDao.checkIsfirst(social_uid);
		if(u==null){
			return true;
		}
		return false;
	}

	@Override
	public void finishOtherMsg(User user) {
		// TODO Auto-generated method stub
//		Integer a = (int)(Math.random()*(99999-10000+1))+10000;
//		user.setId(a.toString());
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 29);
		user.setId(uuid);
		userDao.finishOtherMsg(user);
	}

}
