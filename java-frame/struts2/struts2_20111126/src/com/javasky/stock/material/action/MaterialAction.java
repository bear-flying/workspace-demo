package com.javasky.stock.material.action;

import java.util.ArrayList;
import java.util.List;

import com.javasky.stock.material.pojo.Material;
import com.javasky.stock.material.service.MaterialService;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Material> list = new ArrayList<Material>();
	
	/**
	 * 为订单选择原料信息
	 * @return
	 */
	public String queryMaterials(){
		MaterialService service = new MaterialService();
		list = service.query();
		return "selMaterials";
	}

	public List<Material> getList() {
		return list;
	}

	public void setList(List<Material> list) {
		this.list = list;
	}
	
	

}
