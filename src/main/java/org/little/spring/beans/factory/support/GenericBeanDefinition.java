package org.little.spring.beans.factory.support;

import org.little.spring.beans.factory.BeanDefinition;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 * 对应xml bean标签的属性
 */
public class GenericBeanDefinition implements BeanDefinition {

	private String id;

	private String beanClassName;

	private String scope = SCOPE_DEFAULT;

	private boolean singleton = true;

	private boolean prototype = false;

	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	@Override
	public boolean isSingleton() {
		return SCOPE_SINGLETON.equals(scope);
	}

	@Override
	public boolean isPrototype() {
		return SCOPE_PROTOTYPE.equals(scope);
	}

	@Override
	public String getScope() {
		return this.scope;
	}

	@Override
	public void setScope(String scope) {
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope)?Boolean.TRUE:Boolean.FALSE;
		this.prototype = SCOPE_PROTOTYPE.equals(scope)?Boolean.TRUE:Boolean.FALSE;
	}
}
