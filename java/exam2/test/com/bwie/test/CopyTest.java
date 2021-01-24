package com.bwie.test;

import org.junit.Test;

import com.bwie.exam.CopyForm;
import com.bwie.exam.Shop;
import com.bwie.exam.ShopForm;

public class CopyTest {

	@Test
	public void test() throws Exception {
		
		ShopForm sf = new ShopForm();
		sf.setName("大苹果");
		sf.setPress("不知道怎么填");
		sf.setPrice("二毛九");
		
		CopyForm cf = new CopyForm();
		
		Shop shop = cf.copy(sf);
		
		System.out.println(shop);
		
	}

}
