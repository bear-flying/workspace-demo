package com.jiangyu.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiangyu.pojo.User;
import com.jiangyu.service.IUserService;

@Controller
@RequestMapping(value="user")
public class UserAction {

	@Autowired
	private IUserService userService;
	
	private List<User> userList;
	
	@RequestMapping(value="findUserList")
	public ModelAndView findUserList(){
		ModelAndView model = new ModelAndView();
		userList = userService.findUserList();
		String json = JSONArray.fromObject(userList).toString();
		model.addObject("userList", userList);
		model.addObject("json", json);
		model.setViewName("list");
		return model;
	}
	
	
	
}
