package com.doctor.service;

import java.util.List;

import com.doctor.dao.DoctorDao;
import com.doctor.pojo.Doctor;
import com.doctor.utils.PageBean;

public class DoctorService {

	private DoctorDao dao = new DoctorDao();
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询所有医生
	 */
	public PageBean<Doctor> queryAll(int page,int pageSize) {
		// TODO Auto-generated method stub
		String sql = " select d.*,t.xname jname from t_doctor d left join t_xl t on d.xid = t.xid ";
		
		return dao.queryAll(sql,page,pageSize);
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询一个医生
	 */
	public Doctor queryOne(int id) {
		// TODO Auto-generated method stub
		String sql = " select * from t_doctor where id = ? ";
		
		return dao.queryOne(sql,id);
	}

	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：转到修改页面
	 */
	public void alter(Doctor d) {
		// TODO Auto-generated method stub
		String sql = " update t_doctor set name=?,age=?,content=?,xid=? where id = ? ";
		
		dao.alter(sql,d);
	}

	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：添加医生
	 */
	public void add(Doctor d) {
		// TODO Auto-generated method stub
		String sql = " insert into t_doctor(name,age,content,xid) values(?,?,?,?)";
		dao.add(sql,d);
	}

}
