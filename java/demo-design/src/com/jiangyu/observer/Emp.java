package com.jiangyu.observer;

//工人类 需要根据天气做出相应的处理
public class Emp implements Weather {

	String name;
	
	public Emp(String name) {
		this.name = name;
	}

	public void notifyWeather(String weather){
		if("晴天".equals(weather)){
			System.out.println(name + "高高兴兴的去上班！！");
		}else if("雾霾".equals(weather)){
			System.out.println(name + "带着消毒面具去上班！！");
		}else if("刮风".equals(weather)){
			System.out.println(name + "拖着大石头去上班！！");
		}else if("冰雹".equals(weather)){
			System.out.println(name + "使用铁头功去上班！！");
		}else if("下雪".equals(weather)){
			System.out.println(name + "带着被子去上班！！");
		}
	}
	
}
