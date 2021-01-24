package demo;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.util.Date;


public class MyCache {
//	 public static void main(String[] args) {
//		   /*初始化SockIOPool，管理memcached的连接池*/  
//	        String[] servers = { "192.168.1.60:12111" };  
//	        SockIOPool pool = SockIOPool.getInstance();  
//	        pool.setServers(servers);  
//	        pool.setFailover(true);  
//	        pool.setInitConn(10);  
//	        pool.setMinConn(5);  
//	        pool.setMaxConn(250);  
//	        pool.setMaintSleep(30);  
//	        pool.setNagle(false);  
//	        pool.setSocketTO(3000);  
//	        pool.setAliveCheck(true);  
//	        pool.initialize();  
//	        /*建立MemcachedClient实例*/  
//	        MemCachedClient memCachedClient = new MemCachedClient();  
////	        for (int i = 0; i < 10; i++) {  
//	            /*将对象加入到memcached缓存*/  
//	            boolean success = memCachedClient.add("test", "Hello World JAVA");  
//	            /*从memcached缓存中按key值取对象*/  
//	            String result = (String) memCachedClient.get("test");  
////	            System.out.println(String.format("set( %d ): %s", i, success));  
////	            System.out.println(String.format("get( %d ): %s", i, result));
//	            System.out.println(result);
////	        }  
//	 }
	public static void main(String[] args) {
        String [] addr ={"127.0.0.1:11211"};  
        Integer [] weights = {3};  
        SockIOPool pool = SockIOPool.getInstance();  
        pool.setServers(addr);  
        pool.setWeights(weights);  
        pool.setInitConn(5);  
        pool.setMinConn(5);  
        pool.setMaxConn(200);  
        pool.setMaxIdle(1000*30*30);  
        pool.setMaintSleep(30);  
        pool.setNagle(false);  
        pool.setSocketTO(30);  
        pool.setSocketConnectTO(0);  
        pool.initialize();  
        MemCachedClient client = new MemCachedClient(); 
//      String [] s  =pool.getServers();  
        client.setCompressEnable(true);  
        client.setCompressThreshold(1000*1024);  
          
//      将数据放入缓存  
        client.set("test2","北京");  
          
//      将数据放入缓存,并设置失效时间  
        Date date=new Date(2000000);  
        client.set("test1","中国", date);  
          
//      删除缓存数据  
     // client.delete("test1");  
          
//      获取缓存数据  
        String str =(String)client.get("test1"); 
        String str2 = (String) client.get("test2");
        System.out.println(str);  
        System.out.println(str2);
    } 
}
