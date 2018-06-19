package org.little.spring.beans.factory.xml;


import com.google.common.base.Strings;
import org.little.spring.beans.factory.BeanDefinition;
import org.little.spring.beans.factory.BeanDefinitionStoreException;
import org.little.spring.beans.factory.support.BeanDefinitionRegistry;
import org.little.spring.beans.factory.support.GenericBeanDefinition;
import org.little.spring.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

import static org.little.spring.beans.factory.support.DefaultBeanFactory.*;

/**
 * Created by shiyifan on 2018/6/18.
 *
 * @author shiyifan
 * @date 2018/06/18
 */
public class XmlBeanDefinitionReader {

	private BeanDefinitionRegistry registry;


	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

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
				String name =bean.attributeValue(NAME_ATTRIBUTE);
				String scope =bean.attributeValue(SCOPE_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id,name);
				if(!Strings.isNullOrEmpty(scope)){
					bd.setScope(scope);
				}
				this.registry.registryBeanDefinition(id,bd);
			}
		}catch (Exception e){
			throw new BeanDefinitionStoreException("IOException parse xml Exception",e);
		}
	}
}
