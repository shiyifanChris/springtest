package org.litespring.beans.factory.support;

import com.google.common.base.Strings;
import org.apache.commons.beanutils.BeanUtils;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.SimpleTypeConverter;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.utils.ClassUtils;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory,BeanDefinitionRegistry {
	//存放BeanDefinition
	private ConcurrentHashMap<String,BeanDefinition> beanMap = new ConcurrentHashMap<>();
	private ClassLoader beanClassLoader;
	/**
	 * 获取beanDefinition
	 * @param beanName name
	 * @return
	 */
	public BeanDefinition getBeanDefinition(String beanName) {
		BeanDefinition bd = beanMap.get(beanName);
		if(bd ==null) {
			throw new BeanCreationException(beanName,"not exists");
		}else{
			return bd;
		}
	}

	/**
	 * 创建或 获取bean实例
	 * @param beanId
	 * @return
	 */
	@Override
	public Object getBean(String beanId) {
		if(Strings.isNullOrEmpty(beanId)) {
			return null;
		}else{
			BeanDefinition bd = this.getBeanDefinition(beanId);
			//判断是否是singleton
			if(bd.isSingleton()){
				Object bean = getSingleton(beanId);
				if(Objects.isNull(bean)){
					bean = createBean(bd);
					this.registerSingleton(beanId,bean);
				}
				return bean;
			}else{
				return createBean(bd);
			}
		}
	}

	/**
	 * 创建bean
	 * @param bd bean全路径
	 * @return
	 */
	private Object createBean(BeanDefinition bd) {
		Object bean = initBean(bd);
		populateBeanProperte(bean,bd);
		return bean;
	}

	private void populateBeanProperte(Object bean, BeanDefinition bd) {
		List<PropertyValue> propertyValues = bd.getPropertyValues();
		if(propertyValues==null||propertyValues.size()==0){
			return;
		}
		BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
		try {
			//拿到这个bean的信息
//			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			//获得属性描述
//			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
//			SimpleTypeConverter typeConverter = new SimpleTypeConverter();
			for (PropertyValue propertyValue : propertyValues) {
				String name = propertyValue.getName();
				Object pv = propertyValue.getValue();
				Object resolvedValue = valueResolver.resolveValueIfNecessary(pv);
				BeanUtils.setProperty(bean,name,resolvedValue);
//				for (PropertyDescriptor pd : pds) {
//					if(name.equals(pd.getName())){
//						Method writeMethod = pd.getWriteMethod();
//						Object convertValue = typeConverter.convertIfNecessary(resolvedValue, pd.getPropertyType());
//						//根据参数和相关属性调用方法
//						writeMethod.invoke(bean,convertValue);
//						continue;
//					}
//				}
			}
		} catch (Exception e) {
			throw new BeanCreationException("Failed to obtain BeanInfo for class [" + bd.getBeanClassName() + "]", e);
		}
	}

	private Object initBean(BeanDefinition bd) {
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		try {
			Class<?> bean = classLoader.loadClass(bd.getBeanClassName());
			return bean.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException(bd.getBeanClassName(),"create Bean exception",e);
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
