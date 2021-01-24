package com.jiangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IBeeDao;
import com.jiangyu.dao.IBeeKindDao;
import com.jiangyu.pojo.Bee;
import com.jiangyu.pojo.BeeKind;
@Service
public class BeeService implements IBeeService {

	@Autowired
	private IBeeDao beeDao;
	
	@Autowired
	private IBeeKindDao beeKindDao;
	
	@Override
	public int getCount(String name) {
		// TODO Auto-generated method stub
		if(name==null||name.trim()==""){
			return beeDao.getCount(Bee.class);
		}else{
			return beeDao.getMohuCount("select count(*) from Bee b where b.name like '%"+name+"%' ");
		}
		
	}

	@Override
	public List<Bee> findAll(Integer page, Integer pageSize,String name) {
		// TODO Auto-generated method stub
		if(name==null||name.trim()==""){
			return beeDao.queryPage(" FROM Bee ",page,pageSize);
		}else{
			return beeDao.getMohuList(Bee.class, page, pageSize, " and name like '%"+name+"%'");
		}
		
	}

	@Override
	public List<BeeKind> getKinds() {
		// TODO Auto-generated method stub
		return beeKindDao.findAll(" FROM BeeKind ");
	}

	@Override
	public void add(Bee bee) {
		// TODO Auto-generated method stub
		beeDao.addOne(bee);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		beeDao.removeById(id, Bee.class);
	}

	@Override
	public void removeBatch(String[] ids) {
		// TODO Auto-generated method stub
		for (String s : ids) {
			beeDao.removeOne(beeDao.get(Bee.class, Integer.valueOf(s)));
		}
		
	}

	@Override
	public Bee findOne(String id) {
		// TODO Auto-generated method stub
		return beeDao.findOneByHql(" FROM Bee b WHERE b.id = ?  ", id);
	}

	@Override
	public void modify(Bee bee) {
		// TODO Auto-generated method stub
		beeDao.modify(bee);
	}

}
