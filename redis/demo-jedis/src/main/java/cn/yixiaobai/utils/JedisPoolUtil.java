package cn.yixiaobai.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 有连接池的操作 效率会更高 更加节约资源
 */
public class JedisPoolUtil 
{
	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil(){}
	
	public static JedisPool getJedisPoolInstance()
	{
		if(null == jedisPool)
		{
			synchronized (JedisPoolUtil.class)
			{
				if(null == jedisPool)
				{
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					/**
					 * 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取，
					 * 如果赋值为-1，则表示不限制,如果pool已经分配了maxActive个jedis实例，
					 * 则此时pool的状态为exhausted
					 */
					//poolConfig.setMaxActive(1000);
					/**
					 * 控制一个pool最多有多少个状态为Idle（空闲）的jedis实例
					 */
					poolConfig.setMaxIdle(32);
					/**
					 * 表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，
					 * 则抛出JedisConnectionException
					 */
					//poolConfig.setMaxWait(100*1000);
					/**
					 * 获得一个jedis实例的时候是否检查连接可用性（ping()）;如果为true，
					 * 则得到的jedis实例均是可用的
					 */
					poolConfig.setTestOnBorrow(true);

					jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);

					/**
					 *
					 * whenExhaustedAction：
					 * 表示当pool中的jedis实例都按allocated完时，pool要采取的操作：默认有三种，
					 *  WHEN_EXHAUSTED_FAIL 表示无jedis实例时，直接抛出NoSuchElementException；
					 *  WHEN_EXHAUSTED_BLOCK 表示阻塞住，或者达到maxWait时抛出则抛出JedisConnectionException；
					 *  WHEN_EXHAUSTED_GROW 表示新建一个jedis实例，也就是说设置的maxActive无用；
					 *
					 * testOnReturn:
					 * return一个jedis实例给pool时，是否检查连接可用性（ping()）;
					 */
				}
			}
		}
		return jedisPool;
	}


	/**
	 * 从连接池中获取链接
	 */
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}

	public static void release(JedisPool jedisPool,Jedis jedis)
	{
		if(null != jedis)
		{
			jedisPool.returnResourceObject(jedis);
		}
	}
	
}
