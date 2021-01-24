package com.jiangyu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuBaseAction;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Time;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction extends JiangYuBaseAction{

	@Autowired
	private ICoreService coreService;
	
	private JiangYuPageUtil<Order> jiangYu = new JiangYuPageUtil<Order>();
	
	@RequestMapping("toList")
	public String toList(){
		
		return "list";
	}
	
	@RequestMapping("findAll")
	@ResponseBody
	public Map<String,Object> findAll(Integer page){
		Map<String,Object> map = new HashMap<String, Object>();
//		response.setContentType("text/json;charset=utf-8");
		if(page==null){
			page=1;
		}
		int pageSize = 3;
		int listCount = coreService.getCount();
		List<Order> list = coreService.findAllOrder(page,pageSize);
		jiangYu = JiangYuPageUtil.page("ssh_jiangyu_5order", "core", "findAll.do", listCount, page, pageSize, list);
		map.put("jiangYu", jiangYu);
		
		return map;
//		JsonConfig js = new JsonConfig();
//		js.setExcludes(new String[]{"foods"});
//		JSONObject obj = JSONObject.fromObject(map, js);
//		try {
//			response.getWriter().print(obj);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model model){
		
		List<Time> timelist = coreService.findAllTime();
		List<Address> addresslist = coreService.findAllAddress();
		
		model.addAttribute("timelist", timelist);
		model.addAttribute("addresslist", addresslist);
		
		return "add";
	}
	
	@RequestMapping("add")
	public String add(Order order,String[] cats){
		
		coreService.add(order,cats);
		
		return "redirect:/core/toList.do";
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public String remove(Integer id){
		
		coreService.remove(id);
		return "1";
	}
	@RequestMapping("removeBatch")
	@ResponseBody
	public String removeBatch(Integer[] ids){
		
		coreService.removeBatch(ids);
		return "1";
	}
	
	@RequestMapping("toModify")
	public String toModify(Integer id,Model model){
		
		model.addAttribute("id", id);
		
		return "update";
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public String modify(Order order,String[] cats){
		
		coreService.modifyOrder(order,cats);
		return "1";
	}
	
	@RequestMapping("findOneOrder")
	@ResponseBody
	public Order findOneOrder(Integer id){
		
		return coreService.findOneOrder(id);
		
	}
	
	@RequestMapping("findTimes")
	@ResponseBody
	public List<Time> findTimes(){
		
		return coreService.findAllTime();
		
	}
	
	@RequestMapping("findAddress")
	@ResponseBody
	public List<Address> findAddress(){
		
		return coreService.findAllAddress();
		
	}
	
	@RequestMapping("findFoods")
	@ResponseBody
	public List<Food> findFoods(){
		
		return coreService.findFoods();
		
	}
	
	@RequestMapping("findFoodsByOrderid")
	@ResponseBody
	public Set<Food> findFoodsByOrderid(Integer id){
		
		return coreService.findFoodsByOrderid(id);
		
	}
	
	@RequestMapping("modifyOnefoodByOrderid")
	@ResponseBody
	public String modifyOnefoodByOrderid(Integer id,String[] cats){
		
		coreService.modifyOnefoodByOrderid(id,cats);
		return "1";
	}
	
	
}
