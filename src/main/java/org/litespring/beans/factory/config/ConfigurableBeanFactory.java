package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * bean工厂配置信息，将beanFactory功能拆分
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    public void setBeanClassLoader(ClassLoader beanClassLoader);

    public ClassLoader getBeanClassLoader() ;
}
