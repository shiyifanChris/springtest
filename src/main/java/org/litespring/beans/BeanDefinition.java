package org.litespring.beans;

import java.util.List;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 *
 */
public interface BeanDefinition {

	public static final String SCOPE_SINGLETON = "singleton";
	public static final String SCOPE_PROTOTYPE = "prototype";
	public static final String SCOPE_DEFAULT = "";

	public boolean isSingleton();

	public boolean isPrototype();

	String getScope();

	void setScope(String scope);

	public String getBeanClassName();

    List<PropertyValue> getPropertyValues();

	public ConstructorArgument getConstructorArgument();

	public boolean hasConstructorArgumentValues();

	public String getId();

	public String setId(String id);
}
