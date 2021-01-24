package com.jiangyu.observer;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author JiangYu
 * 
 * 观察者模式 实现
 * 
 * 需求：编写一个气象站类，当气象站更新天气的时候，通知到订阅天气的群体
 * 做出相应的处理。
 *
 */

//气象站
public class WeatherStation{

	String[] weathers = {"晴天","雾霾","刮风","冰雹","下雪"};
	
	//当前天气
	String weather;
	
	ArrayList<Weather> list = new ArrayList<Weather>();
	
	public void addListener(Weather e){
		list.add(e);
	}
	
	//开始工作
	public void startWork() throws Exception{
		final Random random = new Random();
		
		new Thread(){//匿名内部类
			@Override
			public void run() {
				while(true){
					updateWeather(); //每1~1.5秒更新一次天气
					for (Weather e : list) {
						e.notifyWeather(weather);
					}
					int s = random.nextInt(501)+1000;//1000~1500
					try {
						Thread.sleep(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}
	
	
	//更新天气的方法
	public void updateWeather(){
		Random random = new Random();
		int index = random.nextInt(weathers.length);
		weather = weathers[index];
		System.out.println("当前的天气是：" + weather);
	}
}
