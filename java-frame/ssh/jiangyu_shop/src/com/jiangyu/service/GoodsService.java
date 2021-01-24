package com.jiangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IBrandDao;
import com.jiangyu.dao.IGoodsDao;
import com.jiangyu.pojo.Brand;
import com.jiangyu.pojo.Goods;
@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;
	
	@Autowired
	private IBrandDao brandDao;
	
	public int getCount() {
		// TODO Auto-generated method stub
		return goodsDao.getCount(Goods.class);
	}

	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return goodsDao.findAll(" FROM Goods ");
	}

	public Goods findOne(Integer id) {
		// TODO Auto-generated method stub
		// Select new Goods(a.name,a.price,a.datea) from Goods a where a.id = ? 
		return goodsDao.findOneByHql(" FROM Goods a where a.id = ? ", String.valueOf(id));
	}

	public List<Brand> getBrand() {
		// TODO Auto-generated method stub
		return brandDao.findAll(" FROM Brand ");
	}

	public void modify(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.modify(goods);
	}

}
