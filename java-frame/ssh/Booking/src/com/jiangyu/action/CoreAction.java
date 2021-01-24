package com.jiangyu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Street;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction {

	@Autowired
	private ICoreService coreService;
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-21上午9:39:26
	 * 功能：查询所有城市信息
	 * @return
	 */
	@RequestMapping("findCitys")
	@ResponseBody
	public List<City> findCitys(){
		
		List<City> list = coreService.findCitys();
		
		return list;
	}
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-21上午11:55:18
	 * 功能：按条件模糊查询当前城市的街道
	 * @param mess
	 * @param cityid
	 * @return
	 */
	@RequestMapping("findStreetsByCondition")
	@ResponseBody
	public List<Street> findStreetsByCondition(String mess,String cityid){
		
		List<Street> list = coreService.findStreetsByCondition(mess,cityid);
		
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-21上午11:56:03
	 * 功能：保存信息 添加到t_address表
	 * @param city
	 * @param street
	 * @param meg
	 * @return
	 */
	@RequestMapping("addAddress")
	@ResponseBody
	public String addAddress(String city,String street,String meg){
		
		
		coreService.addAddress(city,street,meg);
		
		return "1";
	}
	
}
