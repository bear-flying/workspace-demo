package com.doctor.service;

import java.util.List;

import com.doctor.dao.Xldao;
import com.doctor.pojo.Xl;

public class Xlservice {

	private Xldao dao = new Xldao();
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询所有医生的学历
	 */
	public List<Xl> query() {
		// TODO Auto-generated method stub
		String sql = " select * from t_xl ";
		
		return dao.query(sql);
	}

}
