package org.little.spring.core.io.support;

import org.little.spring.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class ClassPathResource implements Resource{

	private String filePath;

	private ClassLoader classLoader;

	public ClassPathResource(String filePath){
		this(filePath,null);
	}

	public ClassPathResource(String filePath, ClassLoader classLoader) {
		this.filePath = filePath;
		this.classLoader = classLoader==null?ClassLoader.getSystemClassLoader():classLoader ;
	}

	@Override
	public InputStream getInputStream() throws IOException{
		InputStream is = classLoader.getResourceAsStream(filePath);
		if(is==null){
			throw  new FileNotFoundException(filePath + "not found");
		}
		return is;
	}
}
