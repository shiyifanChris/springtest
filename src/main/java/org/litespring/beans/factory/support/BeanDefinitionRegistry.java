package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public interface BeanDefinitionRegistry {

	/**
	 * 注册beanDefinition
	 * @param id
	 * @param bd
	 */
	void registryBeanDefinition(String id, BeanDefinition bd);

	/**
	 * 获取BeanDefinition
	 * @param id
	 * @return
	 */
	BeanDefinition getBeanDefinition(String id);
}
