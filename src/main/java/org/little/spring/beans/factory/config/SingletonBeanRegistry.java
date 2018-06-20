package org.little.spring.beans.factory.config;

public interface SingletonBeanRegistry {

    public void registerSingleton(String beanName, Object singletonObject);

    public Object getSingleton(String beanName);
}
