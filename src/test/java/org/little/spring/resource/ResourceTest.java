package org.little.spring.resource;

import org.little.spring.core.io.Resource;
import org.little.spring.core.io.support.ClassPathResource;
import org.little.spring.core.io.support.FileSystemResource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class ResourceTest {

	@Test
	public void testClassPathResource() throws IOException{
		Resource r = new ClassPathResource("application.xml");
		InputStream is = r.getInputStream();
		Assert.assertNotNull(is);
	}

	@Test
	public void testFileSystemResource() throws IOException{
		Resource r = new FileSystemResource("F:\\code\\springtest\\src\\main\\resources\\application.xml");
		InputStream is = r.getInputStream();
		Assert.assertNotNull(is);
	}
}
