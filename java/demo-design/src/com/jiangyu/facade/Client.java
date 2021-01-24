package com.jiangyu.facade;

/***
 * 门面设计模式：
 *
 * 外部与一个子系统的通信必须通过一个统一的门面对象进行。
 * 门面模式提供一个高层次的接口，使得子系统更易于使用。
 * 每一个子系统只有一个门面类,但整个系统可以有多个门面类。
 *
 * Facade设计模式更注重从架构的层次去看整个系统，而不是单个类的层次。Facade很多时候更是一种架构设计模式。
 *
 */
public class Client {

    public static void main(String[] args) {
		/*ModuleA a = new ModuleA();
		a.doModuleA();

		ModuleB b = new ModuleB();
		b.doModuleB();

		ModuleC c = new ModuleC();
		c.doModuleC();*/

        Facade f = new Facade();
        f.doRequest();

    }

}
