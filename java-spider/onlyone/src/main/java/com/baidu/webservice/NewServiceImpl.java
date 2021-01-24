package com.baidu.webservice;

import javax.jws.WebService;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.user.dao.IUserDao;

@WebService
public class NewServiceImpl implements NewService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public String getUsers() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(userDao.getList()).toString();
	}

	
}
