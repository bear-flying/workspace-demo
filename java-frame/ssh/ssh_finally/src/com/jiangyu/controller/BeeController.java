package com.jiangyu.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.FinalUtil;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuBaseAction2;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Bee;
import com.jiangyu.pojo.BeeKind;
import com.jiangyu.service.IBeeService;

@Controller
@RequestMapping("bee")
public class BeeController extends JiangYuBaseAction2 {

	@Autowired
	private IBeeService beeService; 
	
	private JiangYuPageUtil<Bee> jiangYu = new JiangYuPageUtil<Bee>();
	
	@RequestMapping("findAll")
	public String findAll(String page,Model model,String name){
		
		if(page==null){
			page = String.valueOf(FinalUtil.CURRENT_PAGE_NO);
		}
		
		int listCount = beeService.getCount(name);
		
		List<Bee> list = beeService.findAll(new Integer(page),FinalUtil.PAGE_SIZE,name);
		
		jiangYu = JiangYuPageUtil.page("ssh_finally", "bee", "findAll.do", listCount, new Integer(page), FinalUtil.PAGE_SIZE, list);
	
		model.addAttribute("jiangYu", jiangYu);
		model.addAttribute("beename", name);
		
		return "list";
		
	}
	
	@RequestMapping("toAdd")
	public String toAdd(){
		
		return "add";
	}
	
	@RequestMapping("getKinds")
	@ResponseBody
	public List<BeeKind> getKinds(){
		
		List<BeeKind> list = beeService.getKinds();
		
		return list;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(Bee bee){
		
		bee.setDatea(new Date());
		
		beeService.add(bee);
		
		return "1";
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public String remove(Integer id){
		
		beeService.remove(id);
		
		return "1";
	}
	
	@RequestMapping("removeBatch")
	public void removeBatch(String[] ids,HttpServletResponse response){
		
		beeService.removeBatch(ids);
		
		try {
			response.getWriter().print("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("toModify")
	public String toModify(String id,Model model){
		
		model.addAttribute("id", id);
		
		return "update";
	}
	
	@RequestMapping("findOne")
	@ResponseBody
	public Bee findOne(String id){
		
		Bee b = beeService.findOne(id);
		
		return b;
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public String modify(Bee bee){
		beeService.modify(bee);
		
		return "1";
	}
	
	
}
