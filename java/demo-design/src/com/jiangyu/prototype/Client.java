package com.jiangyu.prototype;

/**
 * 原型设计模式：
 *
 * 原始原型模式使用clone能够动态的抽取当前对象运行时的状态并且克隆到新的对象中，
 * 新对象就可以在此基础上进行操作而不损坏原有对象；
 * 而new只能得到一个刚初始化的对象，而在实际应用中，这往往是不够的。
 *
 * 由于clone方法在java实现中有着一定的弊端和风险，所以clone方法是不建议使用的。
 * 因此很少能在java应用中看到原始原型模式的使用。
 */
public class Client {

    public static void main(String[] args) {
		/*Resume r1 = new Resume("张三",20,"男","13000000000");
		r1.setWorkExperience("2008-2012  在某技术公司    做开发工作");
		Resume r2 = new Resume("张三",20,"男","13000000000");
		r2.setWorkExperience("2012-2014 在某电商工作    做销售工作");

		System.out.println(r1);
		System.out.println(r2);*/

        Resume prototype = new Resume("张三",20,"男","13000000000");

        Resume r1 = (Resume)prototype.clone();
        Resume r2 = (Resume)prototype.clone();

        r1.setWorkExperience("2008-2012  在某技术公司    做开发工作");
        r2.setWorkExperience("2012-2014 在某电商工作    做销售工作");

        System.out.println(r1);
        System.out.println(r2);

    }

}
