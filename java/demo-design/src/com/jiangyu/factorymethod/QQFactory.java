package com.jiangyu.factorymethod;

public class QQFactory extends Factory {

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new QQ();
	}

}
