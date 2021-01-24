package com.maomao.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.maomao.pojo.Cat;
import com.maomao.pojo.KindOfCat;
import com.maomao.service.CatService;
import com.maomao.service.KindOfCatService;
import com.maomao.utils.BaseAction;
import com.maomao.utils.JiangYuPageUtil;
import com.opensymphony.xwork2.ModelDriven;

public class CatAction extends BaseAction implements ModelDriven<Cat> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CatService cs = new CatService();
	private KindOfCatService ks = new  KindOfCatService();
	
	private List<KindOfCat> list;
	private Cat cat = new Cat();
	private JiangYuPageUtil<Cat> jiangYu = new JiangYuPageUtil<Cat>();
	
	public String findAll(){
		System.out.println("~~~~fingAll~~~~");
		Integer page = (jiangYu.getCurrentPageNo()==null?1:jiangYu.getCurrentPageNo());
		Integer pageSize = 3;
		List<Cat> list = cs.queryAll(page,pageSize);
		int result = cs.getCount();
		System.out.println(result);
		jiangYu = JiangYuPageUtil.page("Hibernate_simple", null, "cat!findAll.action", result, page, pageSize, list);
		
		return "found";
	}
	
	public String toAdd(){
		//JSP页面在web-inf下的时候 必须经由Action才能转到
		System.out.println("~~~~toAdd~~~~");
		
		list = ks.findAll();
		//System.out.println(list);
		return "append";
	}
	
	public String add(){

		System.out.println("~~~~add~~~~");
		//System.out.println(cat);
		cs.add(cat);
		
		return "success";
	}
	
	public String findOne(){
		
		System.out.println("~~~~findOne~~~~");
		//System.out.println(cat);
		
		cat = cs.findOne(cat.getCid());
		list = ks.findAll();
		return "foundOne";
	}
	
	public String modify(){
		
		System.out.println("~~~~modify~~~~");
		//System.out.println(cat);
		
		cs.modify(cat);
		
		return "success";
	}
	
	public String remove(){
		
		System.out.println("~~~~remove~~~~");
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		cs.remove(ids);
		
		return "success";
	}

	public Cat getModel() {
		// TODO Auto-generated method stub
		return cat;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public JiangYuPageUtil<Cat> getJiangYu() {
		return jiangYu;
	}

	public void setJiangYu(JiangYuPageUtil<Cat> jiangYu) {
		this.jiangYu = jiangYu;
	}

	public List<KindOfCat> getList() {
		return list;
	}

	public void setList(List<KindOfCat> list) {
		this.list = list;
	}

	

}
