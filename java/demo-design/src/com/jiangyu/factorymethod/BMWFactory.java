package com.jiangyu.factorymethod;

/**
 * 具体工厂角色
 * @author JIAO
 *
 */
public class BMWFactory extends Factory {
	@Override
	public Car createCar() {
		return new BMW();
	}
}
