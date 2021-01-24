package com.jiangyu.builder;
/**
 * 女人的具体建造者角色
 * 负责创建女人的各个部件
 */
public class WomanBuilder implements Builder {
	Person person;
	public WomanBuilder(){
		person = new Person();
	}
	@Override
	public Person getResult() {
		return person;
	}
	@Override
	public void buildHead() {
		person.setHead("女人的头部");
	}
	@Override
	public void buildBody() {
		person.setBody("女人的身体");
	}
	@Override
	public void buildFoot() {
		person.setFoot("女人的脚");
	}
}
