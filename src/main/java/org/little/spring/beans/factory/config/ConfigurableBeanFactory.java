package org.little.spring.beans.factory.config;

public interface ConfigurableBeanFactory {

    public void setBeanClassLoader(ClassLoader beanClassLoader);

    public ClassLoader getBeanClassLoader() ;
}
