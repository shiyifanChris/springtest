package org.litespring.v1;

import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.Resource;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.v1.MytestBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class BeanFactoryTest {

	DefaultBeanFactory factory=null;
	XmlBeanDefinitionReader xmlReader = null;
	Resource resource = null;
	@Before
	public void setUp(){
		 factory = new DefaultBeanFactory();
		 xmlReader = new XmlBeanDefinitionReader(factory);
		 resource = new ClassPathResource("application.xml");
	}


	@Test
	public void testGetBean(){
		xmlReader.loadBeanDefinitions(resource);
		MytestBean mb = (MytestBean)factory.getBean("mytestBean");
		Assert.assertNotNull(mb);
		mb.setTestStr("123");
		System.out.println(mb.getTestStr());
	}

	@Test
	public void testGetBeanException(){
		try {
			xmlReader.loadBeanDefinitions(resource);
			Object bd = factory.getBean("aaa");
		} catch (BeanCreationException e) {
			return;
		}
		Assert.fail("failed test");

	}

	@Test
	public void testParseXml(){
		try {
			xmlReader.loadBeanDefinitions(new ClassPathResource("xxxx.xml"));
		} catch (BeanDefinitionStoreException e) {
			return;
		}
		Assert.fail("failed test");
	}
}
