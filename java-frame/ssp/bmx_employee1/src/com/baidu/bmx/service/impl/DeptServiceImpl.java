package com.baidu.bmx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.bmx.dao.DeptDao;
import com.baidu.bmx.entity.Dept;
import com.baidu.bmx.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao dDao;

	@Override
	public List<Dept> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dDao.findAll();
	}
	
}
