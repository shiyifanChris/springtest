package org.little.spring.core.io.support;

import org.little.spring.core.io.Resource;
import org.little.spring.utils.Assert;

import java.io.*;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class FileSystemResource implements Resource{

	private String filePath;

	private File file;

	public FileSystemResource(String filePath) {
		this(filePath,null);
	}

	public FileSystemResource(String filePath, ClassLoader classLoader) {
		Assert.notNull(filePath," not be null");
		this.filePath = filePath;
		this.file = classLoader==null? new File(filePath):this.file;
	}

	@Override
	public InputStream getInputStream() throws IOException{
		if(!file.exists()){
			throw new FileNotFoundException(filePath + "not exists");
		}
		FileInputStream fis= null;
		try {
			fis = new FileInputStream(file);
		}catch (IOException e){
			throw new FileNotFoundException(filePath + "not exists");
		}
		return fis;
	}
}
