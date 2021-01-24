package com.jiangyu.factorysimple;
/**
 * 工厂角色
 * @author JIAO
 *
 */
public class Factory {
	public static Car create(int type){
		if(type==1){
			return new Benz();
		}else if(type==2){
			return new BMW();
		}else{
			return null;
		}
	}
}
