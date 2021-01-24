package memcached_client_for_java;

import domain.User;

public class MemcachedClient {

	public static void main(String[] args) {
//		
//		String userid = (String) MemcachedUtil.get("userid");
//		
//		System.out.println(userid);
		
//		MemcachedUtil.set("name", "admin");
//		
//		String name = (String) MemcachedUtil.get("name");
//		
//		System.out.println(name);
		
		User user = new User();
		
		user.setId(1);
		user.setUsername("xienan");
		user.setPassword("123");
		
		MemcachedUtils.add("user", user);
		
		User user1 = (User) MemcachedUtils.get("user");
		
		System.out.println(user1);
		
	}
}
