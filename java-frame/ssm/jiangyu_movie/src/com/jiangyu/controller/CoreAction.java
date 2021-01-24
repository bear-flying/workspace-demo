package com.jiangyu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.Type;
import com.jiangyu.pojo.Year;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction {

	@Autowired
	private ICoreService coreService;
	
	JiangYuPageUtil<Movie> jiangYu = new JiangYuPageUtil<Movie>();
	
	@RequestMapping("tofindAll")
	public String tofindAll(Model model){
		
		
		return "list";
	}
	
	
	@RequestMapping("findAll")
	@ResponseBody
	public Map<String,Object> findAll(Integer page,String searchname,String searchtype){
		Map<String,Object> map = new HashMap<>();
		if(page==null){
			page =1;
		}
		int pageSize=3;
		int listCount = coreService.getCount(searchname,searchtype);
		List<Movie> list = coreService.findAll(page,pageSize,searchname,searchtype);
		jiangYu = JiangYuPageUtil.page("jiangyu_movie", "core", "findAll.do", listCount, page, pageSize, list);
		map.put("searchname", searchname);
		map.put("jiangYu", jiangYu);
		map.put("searchtype", searchtype);

		return map;
	}
	
	
	@RequestMapping("findTypes")
	@ResponseBody
	public List<Type> findTypes(){
		
		List<Type> list = coreService.findAllType();
		
		return list;
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model model){
		List<Area> alist = coreService.findAllArea();
		List<Type> tlist = coreService.findAllType();
		List<Year> ylist = coreService.findAllYear();
		model.addAttribute("alist", alist);
		model.addAttribute("tlist", tlist);
		model.addAttribute("ylist", ylist);
		
		return "add";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(Movie movie){
		
		coreService.add(movie);
		
		return "1";
	}
	
}
