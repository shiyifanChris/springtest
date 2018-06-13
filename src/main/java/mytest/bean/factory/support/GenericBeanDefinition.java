package mytest.bean.factory.support;

import mytest.bean.factory.BeanDefinition;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class GenericBeanDefinition implements BeanDefinition{

	private String id;

	private String name;

	public String getBeanClassName() {
		return null;
	}
}
