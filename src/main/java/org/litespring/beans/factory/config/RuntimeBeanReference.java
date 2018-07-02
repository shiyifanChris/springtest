package org.litespring.beans.factory.config;

/**
 * property  ref 的bean
 */
public class RuntimeBeanReference {

    private String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
