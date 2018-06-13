package mytest.bean.factory;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public interface BeanFactory {
	BeanDefinition getBeanDefinition(String mytestBean);

	Object getBean(String mytestBean);
}
