package org.little.spring.beans.factory.support;

import org.little.spring.beans.factory.BeanDefinition;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public interface BeanDefinitionRegistry {

	void registryBeanDefinition(String id, BeanDefinition bd);

	BeanDefinition getBeanDefinition(String id);
}
