package com.baidu.webservice;

import javax.jws.WebService;

@WebService
public interface NewService {

	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：其他项目若想获取本项目的用户信息 直接调用这个接口即可
	 * 时间：2016年1月22日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public String getUsers();
}
