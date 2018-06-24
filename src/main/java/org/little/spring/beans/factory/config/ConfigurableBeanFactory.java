package org.little.spring.beans.factory.config;

import org.little.spring.beans.factory.BeanFactory;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public interface ConfigurableBeanFactory extends BeanFactory {

	public void setBeanClassLoader(ClassLoader beanClassLoader);
	public ClassLoader getBeanClassLoader() ;
}
