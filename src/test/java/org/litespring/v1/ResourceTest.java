package org.litespring.v1;

import org.litespring.core.io.Resource;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
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
		Resource r = new FileSystemResource("F:\\code\\springtest\\src\\test\\resources\\application.xml");
		InputStream is = r.getInputStream();
		Assert.assertNotNull(is);
	}
}
