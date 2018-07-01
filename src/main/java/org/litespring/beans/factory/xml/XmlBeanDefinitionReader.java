package org.litespring.beans.factory.xml;


import com.google.common.base.Strings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.config.TypedStringValue;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.utils.StringUtils;

import java.util.Iterator;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public class XmlBeanDefinitionReader {

	public static final String ID_ATTRIBUTE = "id";

	public static final String CLASS_ATTRIBUTE = "class";

	public static final String SCOPE_ATTRIBUTE = "scope";

	public static final String PROPERTY_ELEMENT = "property";

	public static final String REF_ATTRIBUTE = "ref";

	public static final String VALUE_ATTRIBUTE = "value";

	public static final String NAME_ATTRIBUTE = "name";

	private BeanDefinitionRegistry registry;

	protected final Log logger = LogFactory.getLog(XmlBeanDefinitionReader.class);

	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	/**
	 * 解析xml
	 * @param resource
	 */
	public void loadBeanDefinitions(Resource resource) {
		try{
			SAXReader reader = new SAXReader();
			Document document = reader.read(resource.getInputStream());
			Element rootElement = document.getRootElement();
			Iterator<Element> iterator = rootElement.elementIterator();
//			List elements = rootElement.elements();
			while (iterator.hasNext()){
				Element bean = iterator.next();
				String id =bean.attributeValue(ID_ATTRIBUTE);
				String name =bean.attributeValue(CLASS_ATTRIBUTE);
				String scope =bean.attributeValue(SCOPE_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id,name);
				parseProperties(bean,bd);
				if(!Strings.isNullOrEmpty(scope)){
					bd.setScope(scope);
				}
				this.registry.registryBeanDefinition(id,bd);
			}
		}catch (Exception e){
			throw new BeanDefinitionStoreException("IOException parse xml Exception",e);
		}
	}

	/**
	 * 解析property标签
	 * @param bean
	 * @param bd
	 */
	private void parseProperties(Element bean, BeanDefinition bd) {
		Iterator<Element> propertiesIterator = bean.elementIterator();
		while (propertiesIterator.hasNext()){
			Element property = propertiesIterator.next();
			//name 属性
			String name = property.attributeValue(NAME_ATTRIBUTE);
			if(!StringUtils.hasLength(name)){
				logger.fatal("Tag 'property' must have a 'name' attribute");
				return;
			}
			//获取property value或ref属性
			Object val = parsePropertyValue(property);
			PropertyValue propertyValue = new PropertyValue(name,val);
			bd.getPropertyValues().add(propertyValue);
		}
	}

	/**
	 * 获取property标签的值
	 * @param property
	 * @return
	 */
	private Object parsePropertyValue(Element property) {
		String ref = property.attributeValue(REF_ATTRIBUTE);
		String value = property.attributeValue(VALUE_ATTRIBUTE);
		//判断是ref 还是value
		if(StringUtils.hasText(ref)){
			RuntimeBeanReference refBean = new RuntimeBeanReference(ref);
			return refBean;
		}else if(StringUtils.hasText(value)){
			TypedStringValue valueHolder = new TypedStringValue(value);
			return valueHolder;
		}else {
			throw new RuntimeException();
		}
	}
}
