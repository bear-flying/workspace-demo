package com.doctor.dao;

import java.util.List;

import com.doctor.pojo.Doctor;
import com.doctor.utils.BaseDao;
import com.doctor.utils.PageBean;

public class DoctorDao {

	private BaseDao dao = new BaseDao();
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询所有医生
	 */
	public PageBean<Doctor> queryAll(String sql,int page,int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryPage(Doctor.class, sql, page, pageSize);
	}

	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询一个医生
	 */
	public Doctor queryOne(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(Doctor.class, sql, id);
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：转到修改页面
	 */
	public void alter(String sql, Doctor d) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, d.getName(),d.getAge(),d.getContent(),d.getXid(),d.getId());
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：添加医生
	 */
	public void add(String sql, Doctor d) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, d.getName(),d.getAge(),d.getContent(),d.getXid());
	}

}
