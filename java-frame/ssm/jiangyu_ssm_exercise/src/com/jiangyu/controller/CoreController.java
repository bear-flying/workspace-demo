package com.jiangyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Times;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreController {

	@Autowired
	private ICoreService coreService;
	
	private JiangYuPageUtil<Order> jiangYu = new JiangYuPageUtil<Order>();
	
	@RequestMapping("findAll")
	public String findAll(Integer page,Model model){
		if(page==null){
			page=1;
		}
		Integer pageSize =3;
		List<Order> list = coreService.findAll(page,pageSize);
		int listCount = coreService.getCount();
		jiangYu = JiangYuPageUtil.page("jiangyu_ssm_exercise", "core", "findAll.do", listCount, page, pageSize, list);
		model.addAttribute("jiangYu", jiangYu);
		
		return "list";
	}
	
	@RequestMapping("toAdd")
	public String toAdd(){
		
		return "add";
	}
	
	@RequestMapping("toAdd")
	public String toModify(){
		
		return "update";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(Order order,Integer[] cats){
		
		coreService.add(order,cats);
		
		return "1";
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public String modify(Order order,Integer[] cats){
		
		coreService.modify(order,cats);
		
		return "1";
	}
	
	@RequestMapping("findTimes")
	@ResponseBody
	public List<Times> findTimes(){
		
		List<Times> list = coreService.findTimes();
		
		return list;
		
	}
	
	@RequestMapping("findAddress")
	@ResponseBody
	public List<Address> findAddress(){
		
		List<Address> list = coreService.findAddress();
		
		return list;
		
	}
	
	@RequestMapping("findFoods")
	@ResponseBody
	public List<Food> findFoods(){
		
		List<Food> list = coreService.findFoods();
		
		return list;
		
	}
	
	
}
