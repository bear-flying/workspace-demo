package com.jiangyu.factoryabstract;
/**
 * 具体工厂角色
 * 负责创建跑车族汽车产品
 * @author JIAO
 *
 */
public class SportCarFactory extends Factory {
	@Override
	public BenzCar createBenz() {
		return new BenzSportCar();
	}
	@Override
	public BMWCar createBMW() {
		return new BMWSportCar();
	}
}
