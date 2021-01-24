package com.jiangyu.factoryabstract;
/**
 * 抽象工厂角色
 * @author JIAO
 *
 */
public abstract class Factory {
	public abstract BenzCar createBenz();
	public abstract BMWCar createBMW();
}
