package org.little.spring.context.support;

import org.little.spring.beans.factory.support.DefaultBeanFactory;
import org.little.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.little.spring.context.ApplicationContext;
import org.little.spring.core.io.Resource;
import org.little.spring.utils.ClassUtils;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

	protected DefaultBeanFactory fb = null;
	private ClassLoader beanClassLoader;

	public AbstractApplicationContext(String configFile){
		fb = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(fb);
		Resource resource = this.getResourceByPath(configFile);
		reader.loadBeanDefinitions(resource);
		fb.setBeanClassLoader(this.getBeanClassLoader());
	}

	@Override
	public Object getBean(String id) {
		return fb.getBean(id);
	}

	public abstract Resource getResourceByPath(String filePath);

//	protected void loadResource(String filePath){
//		fb = new DefaultBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(fb);
//		Resource resource = getResourceByPath(filePath);
//		reader.loadBeanDefinitions(resource);
//	}

	@Override
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}
}
