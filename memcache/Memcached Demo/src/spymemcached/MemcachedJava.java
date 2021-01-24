package spymemcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import junit.framework.TestCase;
import net.spy.memcached.MemcachedClient;

/**
 * Memcached的测试类，包含了几个常用的方法
 * @author admin
 *
 */
public class MemcachedJava  extends TestCase{

	private final String ip="127.0.0.1";
	//连接实例
	
	public void  testConnection(){
		try{
	        // 本地连接 Memcached 服务
	        MemcachedClient mcc = new MemcachedClient(new InetSocketAddress(ip, 11211));//ip,端口号
	        System.out.println("Connection to server sucessful.");
	        
	        // 关闭连接
	        mcc.shutdown();
	        
	     }catch(Exception ex){
	        System.out.println( ex.getMessage() );
	     }
		
	}
	
	
	//set 操作实例
	public void  testSet(){
		try{
	         // 连接本地的 Memcached 服务
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress(ip, 11211));
	         System.out.println("Connection to server sucessful.");
	      
	         // 存储数据
	         Future fo = mcc.set("runoob", 900, "Free Education");//key,以秒为单位，0 表示永远，
	         
	         // 查看存储状态
	         System.out.println("set status:" + fo.get());
	         
	         // 输出值
	         System.out.println("runoob value in cache - " + mcc.get("runoob"));

	         // 关闭连接
	         mcc.shutdown();
	         
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }
	}
	
	
	
}
