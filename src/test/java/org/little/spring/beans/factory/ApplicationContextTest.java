package org.little.spring.beans.factory;

import org.little.spring.beans.MytestBean;
import org.junit.Assert;
import org.junit.Test;
import org.little.spring.context.ApplicationContext;
import org.little.spring.context.support.ClassPathXmlApplicationContext;
import org.little.spring.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void testGetBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		MytestBean mytestBean = (MytestBean)ctx.getBean("mytestBean");
		Assert.assertNotNull(mytestBean);
	}
    @Test 
	public void testGetBeanFromFileSystemContext(){
	    //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\code\\springtest\\src\\main\\resources\\application.xml");
	    MytestBean mytestBean = (MytestBean)ctx.getBean("mytestBean");
	    Assert.assertNotNull(mytestBean);
		
	}

}
