package com.bee.service;

import java.util.List;

import com.bee.dao.BeeDao;
import com.bee.pojo.Bee;


public class BeeService {

	private BeeDao dao = new BeeDao();
	
	public List<Bee> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from Bee ";
		
		return dao.queryPage(hql, page, pageSize);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount(Bee.class);
	}

	public void add(Bee bee) {
		// TODO Auto-generated method stub
		dao.addOne(bee);
	}

	public Bee findOne(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findOneByGet(Bee.class, cid);
	}

	public void modify(Bee bee) {
		// TODO Auto-generated method stub
		dao.modify(bee);
	}

	public void remove(String ids) {
		// TODO Auto-generated method stub
		dao.removeAll(Bee.class, ids);
	}

	public List<Bee> findAll2(int page, int pageSize, String name) {
		// TODO Auto-generated method stub
		String hql = "";
		if(!name.equals("")){
			hql=" AND NAME LIKE '%"+name+"%'";
		}
		return dao.getPageList(Bee.class,page, pageSize, hql);
	}

}
