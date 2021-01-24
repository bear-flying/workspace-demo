package com.jiangyu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.pojo.Cinema;
import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.Type;
import com.jiangyu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction {

	@Autowired
	private ICoreService coreService;
	
	private JiangYuPageUtil<Movie> jiangYu = new JiangYuPageUtil<Movie>();
	
	@RequestMapping("toAdd")
	public String toAdd(Model model){
		
		List<Type> list = coreService.findTypes();
		
		model.addAttribute("typelist", list);
		
		return "add";
	}
	
	@RequestMapping("findChina")
	@ResponseBody
	public List<City> findChina(){
		
		List<City> list = coreService.findChina();
		
		return list;
	}
	
	
	@RequestMapping("findPriovinces")
	@ResponseBody
	public List<City> findPriovinces(Integer id){
		
		List<City> list = coreService.findThird(id);
		
		return list;
	}
	
	@RequestMapping("findCitys")
	@ResponseBody
	public List<City> findCitys(Integer id){
		
		List<City> list = coreService.findThird(id);
		
		return list;
	}
	
	@RequestMapping("findCinemaByCity")
	@ResponseBody
	public List<Cinema> findCinemaByCity(Integer id){
		
		List<Cinema> list = coreService.findCinemaByCity(id);
		
		return list;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(Movie movie,String addre,Integer[] cats){
		
		coreService.add(movie,addre,cats);
		
		return "1";
	}
	
	@RequestMapping("findAll")
	public String findAll(Integer page,Model model){
		if(page==null){
			page=1;
		}
		Integer pageSize=3;
		List<Movie> list = coreService.findAll(page,pageSize);
		int listCount  = coreService.getCount();
		jiangYu = JiangYuPageUtil.page("jiangyu_3city", "core", "findAll.do", listCount, page, pageSize, list);
		model.addAttribute("jiangYu", jiangYu);
		
		return "list";
	}
	
	@RequestMapping("toModify")
	public String toModify(Integer id,Model model){
		
		model.addAttribute("id", id);
		return "modify";
	}
	
	@RequestMapping("findOneMovie")
	@ResponseBody
	public Movie findOneMovie(Integer id){
		
		Movie movie = coreService.findOneMovie(id);
		
		return movie;
	}
	
	@RequestMapping("findOneCityname")
	@ResponseBody
	public String findOneCityname(Integer id){
		
		City city = coreService.findOneCityname(id);
		
		return city.getCityname();
		
	}
	
	@RequestMapping("findCinemaByMovie")
	@ResponseBody
	public List<Cinema> findCinemaByMovie(Integer movieid){
		
		List<Cinema> list = coreService.findCinemaByMovie(movieid);
		
		return list;
	}
	
}
