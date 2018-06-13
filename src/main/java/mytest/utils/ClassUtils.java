package mytest.utils;

/**
 * Created by shiyifan on 2018/6/13.
 *
 * @author shiyifan
 * @date 2018/06/13
 */
public class ClassUtils {

	public static ClassLoader getDefaultClassLoader(){
		ClassLoader classLoader =null;
		try {
			classLoader = Thread.currentThread().getContextClassLoader();
		} catch (Exception e) {
		}
		if(classLoader ==null) {
			classLoader = ClassUtils.class.getClassLoader();
			if (classLoader == null) {
				classLoader = ClassLoader.getSystemClassLoader();
			}
		}
		return classLoader;
	}
}
