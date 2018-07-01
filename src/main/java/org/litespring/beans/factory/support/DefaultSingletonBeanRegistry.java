package org.litespring.beans.factory.support;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.utils.Assert;
import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.utils.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	//保存singleton bean实例 map
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(64);

	/**
	 * 保存singleton bean实例
	 * @param beanName
	 * @param singletonObject
	 */
	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		Assert.notNull(beanName,"beanName can't be null!");
		Object oldObject = this.singletonObjects.get(beanName);
		if (Objects.nonNull(oldObject)) {
			throw new IllegalStateException("Could not register object [" + singletonObject +
					"] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
		}
		this.singletonObjects.put(beanName, singletonObject);
	}

	/**
	 * 获取bean实例
	 * @param beanName
	 * @return
	 */
	@Override
	public Object getSingleton(String beanName) {
		return this.singletonObjects.get(beanName);
	}
}
