package com.jiangyu.flyweight;

/**
 * 享元设计模式：
 * 如果一些小的对象，它们有很多属性相同，
 * 把一个对象中不同的属性变成方法的参数称为外蕴状态；那些相同的属性不作为方法的参数称为内蕴状态。
 *
 * 享元模式能做到共享的关键是区分内蕴状态和外蕴状态。
 * 内蕴状态：是存储在享元对象内部的，并且是不会随环境的改变而有所不同。
 * 		因此，一个享元可以具有内蕴状态并可以共享。比如自动拆装箱的时候，部分范围的Integer可以在内存中被重用。
 * 外蕴状态：是随环境的改变而改变的、不可以共享的。
 * 		享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。
 * 		外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的。
 *
 *
 *
 */
public class Client {

	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f1 = factory.factory("a");
		f1.operate("第一次调用享元工厂，获取享元对象");
		
		Flyweight f2 = factory.factory("b");
		f2.operate("第二次调用享元工厂，获取享元对象");
		
		
		Flyweight f3 = factory.factory("a");
		f3.operate("第三次调用享元工厂，获取享元对象");
		f3.operate("xxxx");
		
		System.out.println(f1==f2);
		
		System.out.println(f1==f3);
		
	}


}
