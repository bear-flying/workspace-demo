package com.bwie.exam;

import java.lang.reflect.Method;

public class CopyForm {

	
	public Shop copy(ShopForm sf) throws Exception
	{
		Class clazz = sf.getClass();
		
		Method getName = clazz.getMethod("getName");
		String name = (String) getName.invoke(sf);
		
		Method getPress = clazz.getMethod("getPress");
		String press = (String) getPress.invoke(sf);
		
		Method getPrice = clazz.getMethod("getPrice");
		String price = (String) getPrice.invoke(sf);
		
		
		Class shopClazz = Shop.class;
		Shop shop = (Shop) shopClazz.newInstance();
		
		Method setName = shopClazz.getMethod("setName", String.class);
		setName.invoke(shop, name);
		
		Method setPrice = shopClazz.getMethod("setPrice", String.class);
		setPrice.invoke(shop, price);
		
		Method setPress = shopClazz.getMethod("setPress", String.class);
		setPress.invoke(shop, press);
		
		return shop ;
	}
}
