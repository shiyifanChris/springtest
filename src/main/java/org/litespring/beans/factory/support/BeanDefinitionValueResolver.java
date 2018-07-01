package org.litespring.beans.factory.support;

import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.TypedStringValue;
import org.litespring.beans.factory.config.RuntimeBeanReference;

public class BeanDefinitionValueResolver {

    private DefaultBeanFactory beanFactory ;

    public BeanDefinitionValueResolver(DefaultBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(Object pv) {
        if(pv instanceof RuntimeBeanReference){
            RuntimeBeanReference obj = (RuntimeBeanReference) pv;
            Object bean = beanFactory.getBean(obj.getBeanName());
            return bean;
        }else if(pv instanceof TypedStringValue){
            return ((TypedStringValue) pv).getValue();
        }else{
            throw new RuntimeException("the value " + pv +" has not implemented");
        }
    }
}
