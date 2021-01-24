package com.jiangyu.observer;

//订阅天气预报的接口
public interface Weather {
	public void notifyWeather(String weather);
}
