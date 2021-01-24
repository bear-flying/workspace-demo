package com.baidu.acton;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuPageUtil;

import com.baidu.pojo.Academy;
import com.baidu.pojo.Classes;
import com.baidu.pojo.Hobby;
import com.baidu.pojo.Student;
import com.baidu.service.ICoreService;

@Controller
@RequestMapping("core")
public class CoreAction {
	
	@Autowired
	private ICoreService coreService;
	
	private JiangYuPageUtil<Student> jiangYu = new JiangYuPageUtil<Student>();
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-30上午9:12:05
	 * 功能：分页查询学生列表
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("findAll.do")
	public String findAll(Integer page,Model model){
		if(page==null){
			page=1;
		}
		Integer pageSize=3;
		List<Student> list = coreService.findAll(page,pageSize);
		int listCount = coreService.getCount();
		jiangYu = JiangYuPageUtil.page("jiangyu_exam", "core", "findAll.do", listCount, page, pageSize, list);
		model.addAttribute("jiangYu", jiangYu);
		return "list";
	}
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-30上午9:47:23
	 * 功能：转到添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toAdd.do")
	public String toAdd(Model model){
		
		List<Academy> list = coreService.findAllAcademy();
		
		model.addAttribute("acadlist", list);
		return "add";
	}
	
	@RequestMapping("findClassByAcad.do")
	@ResponseBody
	public List<Classes> findClassByAcad(Integer acadid){
		
		 List<Classes>  list = coreService.findClassByAcad(acadid);
		
		 return list;
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public String add(Student student,Integer[] cats){
		
		coreService.add(student,cats);
		return "1";
	}
	@RequestMapping("modify.do")
	@ResponseBody
	public String modify(Student student,Integer[] cats){
		
		coreService.modify(student,cats);
		return "1";
	}
	
	@RequestMapping("toModify.do")
	public String toModify(Model model,Integer id){
		
		Student s = coreService.findOne(id);
		List<Academy> list = coreService.findAllAcademy();
		model.addAttribute("s", s);
		model.addAttribute("acadlist", list);
		return "update";
	}
	@RequestMapping("findOneHobbys.do")
	@ResponseBody
	public Set<Hobby> findOneHobbys(Integer sid){
		Set<Hobby> hobbyss = coreService.findHobbys(sid);
		
		return hobbyss;
	}
	
}
