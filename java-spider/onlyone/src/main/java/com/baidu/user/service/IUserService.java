package com.baidu.user.service;

import com.baidu.user.pojo.User;

public interface IUserService {

	void register(User user);

	void login(User user) throws Exception;

	Boolean checkIsfirst(String social_uid);

	void finishOtherMsg(User user);

}
