package org.little.spring.beans.factory.config;

/**
 * singleton bean保存信息
 */
public interface SingletonBeanRegistry {

    public void registerSingleton(String beanName, Object singletonObject);

    public Object getSingleton(String beanName);
}
