
import redis.clients.jedis.Jedis; 

/**
 * 简单赋值
 */
public class Demo_string {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("10.20.14.125",6379);  //连接redis服务 
          
        //密码验证-如果你没有设置redis密码可不验证即可使用相关命令  
        //jedis.auth("abcdefg");  
          
        //简单的key-value 存储  
        jedis.set("redis", "myredis");  
        System.out.println(jedis.get("redis"));
	}
}
