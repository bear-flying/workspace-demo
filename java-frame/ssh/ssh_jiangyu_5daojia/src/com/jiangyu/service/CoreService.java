package com.jiangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IAreaDao;
import com.jiangyu.dao.ICategoryDao;
import com.jiangyu.dao.IFoodDao;
import com.jiangyu.dao.IShopDao;
import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Category;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Shop;

@Service
public class CoreService implements ICoreService {

	@Autowired
	private IShopDao shopDao;
	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private IFoodDao foodDao;
	@Autowired
	private IAreaDao areaDao;
	
	
	@Override
	public List<Shop> findAllShop() {
		// TODO Auto-generated method stub
		return shopDao.findAll(" From Shop ");
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.findAll(" From Category ");
	}

	@Override
	public void addFood(Food food) {
		// TODO Auto-generated method stub
		foodDao.addOne(food);
	}

	@Override
	public Area findAreasByCondition(String name) {
		// TODO Auto-generated method stub
		String hql = " select * from t_area a where a.name like '%"+name+"%' ";
		List<Area> list = areaDao.findAllBySql(Area.class, hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int findShopCount(Integer id) {
		// TODO Auto-generated method stub
		String sql = " select count(*) from t_shop s left join t_area a on s.aid=a.id where a.id="+id;
		
		return shopDao.getTotalCountBySql(sql);
	}

	@Override
	public List<Category> findCategorysByShopId(Integer id) {
		// TODO Auto-generated method stub
		String sql = " select distinct c.* from t_shop s,t_food f,t_category c where f.cid=c.id and f.sid = "+id;
		List<Category> list = categoryDao.findAllBySql(Category.class, sql);
		
		return list;
	}

	@Override
	public List<Food> findFoodsByCondition(Integer shopid, Integer categoryid) {
		// TODO Auto-generated method stub
		String sql=" select * from t_food where sid="+shopid+" and cid="+categoryid+" ";
		return foodDao.findAllBySql(Food.class, sql);
	}

}
