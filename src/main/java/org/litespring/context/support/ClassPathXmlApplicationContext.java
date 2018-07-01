package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.core.io.Resource;
import org.litespring.core.io.ClassPathResource;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
	private DefaultBeanFactory fb = null;

	public ClassPathXmlApplicationContext(String filePath) {
//		fb = new DefaultBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(fb);
//		Resource resource = new ClassPathResource(filePath);
//		reader.loadBeanDefinitions(resource);
		super(filePath);
	}

	@Override
	public Resource getResourceByPath(String filePath) {
		return new ClassPathResource(filePath,getBeanClassLoader());
	}
}
