package com.jiangyu.dao;

import java.util.List;

import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuIhibernateDao;

import com.jiangyu.pojo.Street;

public interface IStreetDao extends JiangYuIhibernateDao<Street> {

	List<Street> findStreetsByCondify(String sql);


}
