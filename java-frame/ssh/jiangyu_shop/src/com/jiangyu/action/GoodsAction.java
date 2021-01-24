package com.jiangyu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuBaseAction2;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Brand;
import com.jiangyu.pojo.Goods;
import com.jiangyu.service.IGoodsService;
@RequestMapping("/core")
@Controller
public class GoodsAction extends JiangYuBaseAction2 {

	@Autowired
	private IGoodsService goodService;
	
	private JiangYuPageUtil<Goods> jiangYu= new JiangYuPageUtil<Goods>();
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-16上午8:32:20
	 * 功能：分页查询
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAll.do")
	public String findAll(Integer page,Model model){
		System.out.println("~~findAll~~~");
		if(page==null){
			page=1;
		}
		int pageSize = 3;
		int result = goodService.getCount();
		List<Goods> list = goodService.findAll();
		jiangYu = JiangYuPageUtil.page("jiangyu_shop", "core", "findAll.do", result, page, pageSize, list);
		model.addAttribute("jiangYu", jiangYu);
		return "list";
	}
	
	@RequestMapping("toModify")
	public String toModify(Goods goods,Model model){
		
		model.addAttribute("id", goods.getId());
		return "update";
		
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public Goods modify(String id){
		Goods g = goodService.findOne(Integer.valueOf(id));
		System.out.println(g);
		return g;
	}
	
	@RequestMapping("modify2")
	@ResponseBody
	public String modify2(Goods goods){
		goodService.modify(goods);
		return "1";
	}
	
	@RequestMapping("getBrand")
	@ResponseBody
	public List<Brand> getBrand(){
		List<Brand> list = goodService.getBrand();
		
		return list;
	}
	
	
}
