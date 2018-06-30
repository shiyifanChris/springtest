package org.little.spring.beans.factory;

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
}
