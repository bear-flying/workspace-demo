package cn.yixiaobai.jedis;

import redis.clients.jedis.Jedis;

public class JedisDemo01 {
	/**
	 * Jedis的简单使用
	 */
	public static void main(String[] args) {
		//构建jedis对象
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		//向redis中添加数据
		jedis.set("mytest", "123");
		//从redis中读取数据
		String value = jedis.get("mytest");
		
		System.out.println(value);
		//关闭连接
		jedis.close();
	}
	
}
