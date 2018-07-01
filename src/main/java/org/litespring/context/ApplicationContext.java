package org.litespring.context;


import org.litespring.beans.factory.config.ConfigurableBeanFactory;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public interface ApplicationContext extends ConfigurableBeanFactory {
    Object getBean(String beanId);
}
