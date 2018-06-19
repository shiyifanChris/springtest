package org.little.spring.beans.factory.support;

import com.google.common.base.Strings;
import org.little.spring.beans.factory.BeanCreationException;
import org.little.spring.beans.factory.BeanDefinition;
import org.little.spring.beans.factory.BeanFactory;
import org.little.spring.utils.ClassUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory,BeanDefinitionRegistry {

	private ConcurrentHashMap<String,BeanDefinition> beanMap = new ConcurrentHashMap<>();
	private ClassLoader beanClassLoader;

	public static final String ID_ATTRIBUTE = "id";
	public static final String NAME_ATTRIBUTE = "class";
	public static final String SCOPE_ATTRIBUTE = "scope";

	public BeanDefinition getBeanDefinition(String beanName) {
		BeanDefinition bd = beanMap.get(beanName);
		if(bd ==null) {
			throw new BeanCreationException(beanName,"not exists");
		}else{
			return bd;
		}
	}

	@Override
	public Object getBean(String beanId) {
		if(Strings.isNullOrEmpty(beanId)) {
			return null;
		}else{
			BeanDefinition bd = this.getBeanDefinition(beanId);
			String className = bd.getBeanClassName();
			if(bd.isSingleton()){
				Object bean = getSingleton(beanId);
				if(Objects.isNull(bean)){
					bean = createBean(className);
					this.registerSingleton(beanId,bean);
				}
				return bean;
			}else{
				return createBean(className);
			}
		}
	}

	private Object createBean(String className) {
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		try {
			Class<?> bean = classLoader.loadClass(className);
			return bean.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException(className,"create Bean exception",e);
		}
	}

	@Override
	public void registryBeanDefinition(String id, BeanDefinition bd) {
		this.beanMap.put(id,bd);
	}

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}
}
