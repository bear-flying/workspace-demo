package org.jiangyu.action;

import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuBaseAction;

public class UserAction extends JiangYuBaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String master(){
		System.out.println("~~master~~");
		
		
		return "tomaster";
	}
	
	
}
