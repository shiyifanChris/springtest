package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.utils.ClassUtils;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.utils.ClassUtils;

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
