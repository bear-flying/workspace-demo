package cn.yixiaobai.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestAPI {
	public static void main(String[] args) 
	{
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		jedis.set("k1","v1");
		jedis.set("k2","v2");
		jedis.set("k3","v3");
		
		
		System.out.println(jedis.get("k3"));

		Set<String> keys = jedis.keys("*");
		System.out.println(keys.size());
		for (Iterator iterator = keys.iterator();iterator.hasNext();){
			String key = (String) iterator.next();
			System.out.println(key);
		}
		System.out.println("jedis.exists===>" + jedis.exists("k2"));
		System.out.println(jedis.ttl("k1"));

		//String
		//jedis.append("ki", "myredis");
		System.out.println(jedis.get("k1"));
		jedis.set("k4", "k4_redis");
		System.out.println("-------------------------");
		jedis.mset("str1", "v1","str2", "v2","str3", "v3");
		System.out.println(jedis.mget("str1", "str2", "str3"));
		//list
		System.out.println("-------------------------");
		//jedis.lpush("mylist" "v1", "v2", "v3", "v4", "v5");

		List<String> list = jedis.lrange("mylist", 0, -1);
		for (String element : list) {
			System.out.println(element);
		}

		//set
		jedis.sadd("orders","jd001");
		jedis.sadd("orders","jd002");
		jedis.sadd("orders","jd003");
		Set<String> set1 = jedis.smembers("orders");
		for (Iterator iterator = keys.iterator();iterator.hasNext();){
			String key = (String) iterator.next();
			System.out.println(key);
		}
		jedis.srem("orders","jd002");
		System.out.println(jedis.smembers("orders").size());

		//hash
		jedis.hset("hash1","userName","lisi");
		System.out.println(jedis.hget("hash1","userName"));
		HashMap<String, String> map = new HashMap<>();
		map.put("name","libai");
		map.put("age","13");
		map.put("email","libai@163.com");
		jedis.hmset("hash2", map);


	}
}
