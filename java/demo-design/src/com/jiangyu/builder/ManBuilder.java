package com.jiangyu.builder;
/**
 * 男人的具体建造者角色
 * 负责创建男人的各个部件
 */
public class ManBuilder implements Builder {
	Person person;
	public ManBuilder(){
		person = new Person();
	}
	@Override
	public Person getResult() {
		return person;
	}
	@Override
	public void buildHead() {
		person.setHead("男人的头部");
	}
	@Override
	public void buildBody() {
		person.setBody("男人的身体");
	}
	@Override
	public void buildFoot() {
		person.setFoot("男人的脚");
	}
}
