package com.jiangyu.builder;
/**
 * 抽象建造者角色
 * 负责定制创建产品表象/部件的方法
 */
public interface Builder {
	public void buildHead();
	public void buildBody();
	public void buildFoot();
	public Person getResult();
}
