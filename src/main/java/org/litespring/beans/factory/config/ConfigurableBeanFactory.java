package org.litespring.beans.factory.config;

/**
 * bean工厂配置信息，将beanFactory功能拆分
 */
public interface ConfigurableBeanFactory {

    public void setBeanClassLoader(ClassLoader beanClassLoader);

    public ClassLoader getBeanClassLoader() ;
}
