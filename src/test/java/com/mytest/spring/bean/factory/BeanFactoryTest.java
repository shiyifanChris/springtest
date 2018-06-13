package com.mytest.spring.bean.factory;

import mytest.bean.factory.BeanDefinition;
import mytest.bean.factory.support.DefaultBeanFactory;
import mytest.bean.MytestBean;
import mytest.bean.factory.BeanFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class BeanFactoryTest {

	@Test
	public void testGetBean(){
		BeanFactory factory = new DefaultBeanFactory("application.xml");
		BeanDefinition bd = factory.getBeanDefinition("mytestBean");
		Assert.assertEquals("mytest.bean.MytestBean",bd.getBeanClassName());
		MytestBean mb = (MytestBean)factory.getBean("mytestBean");
		Assert.assertNotNull(mb);

	}
}
