package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Brand;
import com.jiangyu.pojo.Goods;

public interface IGoodsService {

	int getCount();

	List<Goods> findAll();

	Goods findOne(Integer id);

	List<Brand> getBrand();

	void modify(Goods goods);

}
