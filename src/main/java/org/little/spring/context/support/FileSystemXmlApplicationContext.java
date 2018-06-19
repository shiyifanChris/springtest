package org.little.spring.context.support;

import org.little.spring.beans.factory.support.DefaultBeanFactory;
import org.little.spring.core.io.Resource;
import org.little.spring.core.io.support.FileSystemResource;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	private DefaultBeanFactory fb = null;

	public FileSystemXmlApplicationContext(String filePath) {
		super(filePath);
	}

	@Override
	public Resource getResourceByPath(String filePath) {
		return new FileSystemResource(filePath,getBeanClassLoader());
	}
}
