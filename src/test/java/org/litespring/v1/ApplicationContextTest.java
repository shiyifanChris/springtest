package org.litespring.v1;

import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.MytestBean;
import org.litespring.service.v1.MytestBean;
import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;

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
		ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\code\\springtest\\src\\test\\resources\\application.xml");
	    MytestBean mytestBean = (MytestBean)ctx.getBean("mytestBean");
	    Assert.assertNotNull(mytestBean);
		
	}

}
