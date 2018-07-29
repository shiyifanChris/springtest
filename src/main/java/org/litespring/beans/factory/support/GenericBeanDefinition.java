package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.ConstructorArgument;
import org.litespring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

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

	private List<PropertyValue> propertyValues = new ArrayList<>();

	private ConstructorArgument constructorArgument = new ConstructorArgument();

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

	@Override
	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

	@Override
	public ConstructorArgument getConstructorArgument() {
		return constructorArgument;
	}

	@Override
	public boolean hasConstructorArgumentValues() {
		return !constructorArgument.isEmpty();
	}

	@Override
	public String setId(String id) {
		return this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public GenericBeanDefinition() {
	}
}
