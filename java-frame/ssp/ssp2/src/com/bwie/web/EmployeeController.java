package com.bwie.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwie.entity.Dept;
import com.bwie.entity.Employee;
import com.bwie.service.DeptService;
import com.bwie.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	// * 自动转换日期类型的字段格式.导包导util的包，放在controller层就行
	 
//	@InitBinder
//	public void initBinder(ServletRequestDataBinder binder){
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new 
//				SimpleDateFormat("yyyy-MM-dd"), true));
//	}

	
	@Resource
	private DeptService deptService ;
	
	@Resource
	private EmployeeService employeeService ;
	
	
	@RequestMapping("list")
	public String list(Model model)
	{
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		
		return "list";
	}
	
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Model model){
		List<Dept> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		
		return "add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody //后台AJAX异步添加
	public void add(Employee employee){
		employeeService.save(employee);
	}
	
//	@RequestMapping(value="add",method=RequestMethod.POST)
//	public String add(Employee employee)
//	{
//		employeeService.save(employee);
//		
//		return "redirect:/employee/list.do";
//	}
	
	
	
	
	
	
	

}
