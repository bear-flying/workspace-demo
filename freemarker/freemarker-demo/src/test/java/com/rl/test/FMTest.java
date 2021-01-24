package com.rl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.itcast.freemarker.model.User;
import cn.itcast.util.FMutil;

public class FMTest {
	Map<String, Object> map;
	FMutil fm;

	@Before
	public void setUp() throws Exception {
		map = new HashMap<String, Object>();
		fm = new FMutil();
	}

	@Test
	public void test1() throws Exception {
		map.put("username", "zhangsan");
		fm.ouputFile("fm1.ftl", "fm1.html", map);
	}
	
	@Test
	public void test2() throws Exception {
		map.put("username", "张三");
		fm.ouputFile("fm2.ftl", "fm2.html", map);
	}
	@Test
	public void test3() throws Exception {
		User user = new User();
		user.setId(1);
		user.setName("李逵");
		user.setAge(15);
		map.put("user", user);
		fm.ouputFile("fm3.ftl", "fm3.html", map);
	}
	@Test
	public void test6() throws Exception {
		User user = new User();
		user.setId(1);
		user.setName("李逵");
		user.setAge(15);
		map.put("user", user);
		fm.ouputFile("fm6.ftl", "fm6.html", map);
	}
	@Test
	public void test4() throws Exception {
		List<User> userList = new ArrayList<User>();
		
		for(int i = 1 ; i < 10; i++){
			User user = new User();
			user.setId(i);
			user.setName("李逵"+i);
			user.setAge(15+i);
			userList.add(user);
		}
		
		map.put("userList", userList);
		fm.ouputFile("fm4.ftl", "fm4.html", map);
	}
	@Test
	public void test5() throws Exception {
		List<User> userList = new ArrayList<User>();
		
		for(int i = 1 ; i < 10; i++){
			User user = new User();
			user.setId(i);
			user.setName("李逵"+i);
			user.setAge(15+i);
			userList.add(user);
		}
		
		map.put("userList", userList);
		map.put("username", "张三");
		fm.ouputFile("fm5.ftl", "fm5.html", map);
	}
	
	@Test
	public void test7() throws Exception {
		map.put("now", new Date());
		fm.ouputFile("fm7.ftl", "fm7.html", map);
	}

}
