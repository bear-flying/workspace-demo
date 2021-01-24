package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Category;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Shop;

public interface ICoreService {

	List<Shop> findAllShop();

	List<Category> findAllCategory();

	void addFood(Food food);

//	List<Shop> findShopByCondition(String name);

	Area findAreasByCondition(String name);

	int findShopCount(Integer id);

	List<Category> findCategorysByShopId(Integer id);

	List<Food> findFoodsByCondition(Integer id, Integer id2);

}
