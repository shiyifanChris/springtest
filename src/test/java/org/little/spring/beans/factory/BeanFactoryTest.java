package org.little.spring.beans.factory;

import org.little.spring.beans.factory.support.DefaultBeanFactory;
import org.little.spring.beans.MytestBean;
import org.little.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.little.spring.core.io.Resource;
import org.little.spring.core.io.support.ClassPathResource;
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
