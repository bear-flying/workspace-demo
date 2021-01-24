package com.jiangyu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Category;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Shop;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction {

	@Autowired
	private ICoreService coreService;
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：转到添加菜品的页面
	 * 时间：2015年11月25日
	 * 作者：1405javab 姜宇
	 * @param model
	 * @return
	 */
	@RequestMapping("toSaveFood")
	public String toSaveFood(Model model){
		List<Shop> shoplist = coreService.findAllShop();
		List<Category> categorylist = coreService.findAllCategory();
		model.addAttribute("shoplist", shoplist);
		model.addAttribute("categorylist", categorylist);
		return "add_food";
	}
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：添加菜品
	 * 时间：2015年11月25日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	@RequestMapping("addFood")
	public String addFood(Food food){
		
		coreService.addFood(food);
		
		return "search";
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：模糊查询地区和该地区的餐厅数
	 * 时间：2015年11月25日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	@RequestMapping("searchShops")
	@ResponseBody
	public Map<String,Object> searchShops(String name){
		Map<String,Object> map = new HashMap<String, Object>();
		//通过地址查出该地址所在的地区
		Area aa = coreService.findAreasByCondition(name);
		//通过地区查出该地区有多少家餐厅
		if(aa!=null){
			int count = coreService.findShopCount(aa.getId());
			map.put("area", aa.getName());
			map.put("shops", count);	
		}
		return map;	
	}
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：查询所有餐厅
	 * 时间：2015年11月26日
	 * 作者：1405javab 姜宇
	 * @param model
	 * @return
	 */
	@RequestMapping("findShops")
	public String findShops(Model model){
		List<Shop> shoplist = coreService.findAllShop();
		model.addAttribute("shoplist", shoplist);
		return "shop_list";
	}
	
	@RequestMapping("showOneshopFoods")
	public String showOneshopFoods(Integer id,Model model){
		//根据餐厅id查出该餐厅的所有菜品
		List<Category> list = coreService.findCategorysByShopId(id);
		Map<String,List<Food>> map = new HashMap<>();
		for (Category cat : list) {
			//获得该餐厅中 该菜品分类的所有菜品
			List<Food> flist = coreService.findFoodsByCondition(id,cat.getId());
			map.put(cat.getName(), flist);
		}
		
		model.addAttribute("categorylist", list);
		model.addAttribute("foodmap", map);
		
		return "food_list";
	}
	
	
	
	
}
