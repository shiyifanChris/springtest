package mytest.bean.factory.support;

import mytest.bean.factory.BeanDefinition;
import mytest.bean.factory.BeanFactory;
import mytest.utils.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class DefaultBeanFactory implements BeanFactory {

	private ConcurrentHashMap<String,BeanDefinition> beanMap = new ConcurrentHashMap<>();

	public DefaultBeanFactory(String filePath) {
		loadBeanDefinitions(filePath);
	}

	private void loadBeanDefinitions(String filePath) {
		try(InputStream is = ClassUtils.getDefaultClassLoader().getResourceAsStream(filePath);){
			SAXReader reader = new SAXReader();
			Document document = reader.read(is);
			Element rootElement = document.getRootElement();
			Iterator iterator = rootElement.elementIterator();
			List elements = rootElement.elements();
			while (iterator.hasNext()){
				iterator.next();
			}
		}catch (Exception e){

		}
	}


	public BeanDefinition getBeanDefinition(String beanName) {
		BeanDefinition bd = beanMap.get(beanName);
		if(bd ==null) {
			return null;
		}else{
			return bd;
		}
	}

	@Override
	public Object getBean(String mytestBean) {
		return null;
	}
}
