package com.jiangyu.factoryabstract;
/**
 * 具体工厂角色  
 * 负责商务车产品族产品的创建
 * @author JIAO
 *
 */
public class BussinessCarFactory extends Factory {
	@Override
	public BenzCar createBenz() {
		return new BenzBussinessCar();
	}
	@Override
	public BMWCar createBMW() {
		return new BMWBussinessCar();
	}
}
