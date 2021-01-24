package com.doctor.dao;

import java.util.List;

import com.doctor.pojo.Xl;
import com.doctor.utils.BaseDao;

public class Xldao {

	private BaseDao dao = new BaseDao();
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询所有医生的学历
	 */
	public List<Xl> query(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(Xl.class, sql);
	}

}
