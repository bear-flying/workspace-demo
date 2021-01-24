package com.jiangyu.decorator;

/**
 * 
 * @author JiangYu
 * 
 * 装饰者设计模式  实现
 * 
 * 需求：一家三口每个人都工作，儿子的工作就是画画。
 * 母亲的工作就是在儿子的基础上做一个增强，不只是画画，还可以上涂料。
 * 爸爸的工作就是在妈妈的基础上做一个增强，不只是画画，还可以上画框。
 * 
 */

interface Work{
	public void work();
}

class Son implements Work{
	@Override
	public void work() {
		System.out.println("画画...");
	}
}

class Mother implements Work{
	
	//需要被增强的类的引用
	Work worker;
	
	public Mother(Work worker){
		this.worker = worker;
	}
	
	@Override
	public void work() {
		worker.work();
		System.out.println("给画上颜色...");
	}
}

class Father implements Work{
	
	//需要被增强的类的引用
	Work worker;
	
	public Father(Work worker){
		this.worker = worker;
	}
	
	@Override
	public void work() {
		worker.work();
		System.out.println("给画上画框...");
	}
}


public class PaintingDemo {
	
	public static void main(String[] args) {
		Son s = new Son();
		//s.work();
		Mother m = new Mother(s);
		//m.work();
		Father f = new Father(m);
		f.work();
	}
}
