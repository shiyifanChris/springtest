package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.core.io.Resource;
import org.litespring.core.io.FileSystemResource;

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
		return new FileSystemResource(filePath);
	}
}
