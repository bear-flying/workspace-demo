package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.aop.CGlibProxyFactory;
import cn.itcast.aop.JDKProxyFactory;
import cn.itcast.service.PersonService;
import cn.itcast.service.impl.PersonServiceBean;

public class AOPTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test public void proxyTest(){
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService service = (PersonService) factory.createProxyIntance(new PersonServiceBean("xxx"));
		service.save("888");
	}
	
	@Test public void proxyTest2(){
		CGlibProxyFactory factory = new CGlibProxyFactory();
		PersonServiceBean service = (PersonServiceBean) factory.createProxyIntance(new PersonServiceBean("xxx"));
		service.save("999");
	}
}
