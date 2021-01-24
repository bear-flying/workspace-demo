package com.jiangyu.builder;

/*
建造设计模式

将产品的内部表象和产品的生成过程分割开来，从而使一个建造过程生成具有不同的内部表象的产品对象。
建造模式使得产品内部表象可以独立的变化，客户不必知道产品内部组成的细节。
与抽象工厂的区别：在建造者模式里，有个指导者，由指导者来管理建造者，用户是与指导者联系的，指导者联系建造者最后得到产品。即建造模式可以强制实行一种分步骤进行的建造过程。
1）抽象建造者角色：规范产品对象的各个组成部分的建造。
2）具体建造者角色：是与应用程序紧密相关的类，在指导者的调用下创建产品的实例。该角色实现抽象建造者，完成产品的组装。
3）指导者角色：调用具体建造者角色以完成创建产品。指导者不需要产品类的具体实现，产品的具体实现在具体建造者对象。
4）产品角色：产品类、组件类，包括产品的接口或抽象类和实现类。
*/
public class Client {

	public static void main(String[] args) {
		//男人
		Director director = new Director(new ManBuilder());
		Person man = director.construct();
		System.out.println(man);
		
		//女人
		Director director2 = new Director(new WomanBuilder());
		Person woman = director2.construct();
		System.out.println(woman);
	}

}
