package com.jiangyu.builder;
/**
 * 指导者角色
 * 负责调用具体的建造者，建造产品
 * 客户端直接调用
 */
public class Director {
	private Builder builder;
	public Director(Builder builder){
		this.builder = builder;
	}
	//造产品方法
	public Person construct(){
		builder.buildBody();
		builder.buildHead();
		builder.buildFoot();
		return builder.getResult();
	}
}
