package com.jiangyu.factorysimple;
/**
 * 工厂角色
 * @author JIAO
 *
 */
public class Factory2 {
	public static Car create(String className){
		try {
			Car car = (Car)Class.forName(className).newInstance();
			return car;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
