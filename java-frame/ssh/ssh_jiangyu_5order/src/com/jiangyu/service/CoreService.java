package com.jiangyu.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IAddressDao;
import com.jiangyu.dao.IFoodDao;
import com.jiangyu.dao.IOrderDao;
import com.jiangyu.dao.ITimeDao;
import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Time;
@Service
public class CoreService implements ICoreService {

	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private ITimeDao timeDao;
	@Autowired
	private IAddressDao addressDao;
	@Autowired
	private IFoodDao foodDao;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orderDao.getCount(Order.class);
	}

	@Override
	public List<Order> findAllOrder(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return orderDao.queryPage(" FROM Order ", page, pageSize);
				//findAll(" FROM Order ");
	}

	@Override
	public List<Time> findAllTime() {
		// TODO Auto-generated method stub
		return timeDao.findAll(" FROM Time ");
	}

	@Override
	public List<Address> findAllAddress() {
		// TODO Auto-generated method stub
		return addressDao.findAll(" FROM Address ");
	}

	@Override
	public void add(Order order, String[] cats) {
		// TODO Auto-generated method stub
		Set<Food> set = new HashSet<Food>();
		for (String s : cats) {
			set.add(new Food(new Integer(s)));
		}
		order.setDatea(new Date());
		order.setFoods(set);
		orderDao.addOne(order);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		orderDao.removeById(id, Order.class);
	}

	@Override
	public Order findOneOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.get(Order.class, id);
	}

	@Override
	public List<Food> findFoods() {
		// TODO Auto-generated method stub
		return foodDao.findAll(" FROM Food ");
	}

	@Override
	public void modifyOrder(Order order, String[] cats) {
		// TODO Auto-generated method stub
		Set<Food> foods = order.getFoods();
		foods.clear();
		for (String s : cats) {
			foods.add(new Food(Integer.valueOf(s)));
		}
		orderDao.modify(order);
	}

	@Override
	public void removeBatch(Integer[] ids) {
		// TODO Auto-generated method stub
		for (Integer id : ids) {
			orderDao.removeById(id, Order.class);
		}
		
	}

	@Override
	public Set<Food> findFoodsByOrderid(Integer id) {
		// TODO Auto-generated method stub
		Order order = orderDao.get(Order.class, id);
		Set<Food> foods = order.getFoods();
		return foods;
	}

	@Override
	public void modifyOnefoodByOrderid(Integer id, String[] cats) {
		// TODO Auto-generated method stub
		Order order = orderDao.get(Order.class, id);
		Set<Food> foods = order.getFoods();
		foods.clear();
		for(String s : cats){
			foods.add(new Food(new Integer(s)));
		}
		orderDao.modify(order);
	}

}
