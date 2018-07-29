package org.litespring.core.io;

import org.litespring.util.Assert;

import java.io.*;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public class FileSystemResource implements Resource {

	private String filePath;

	private File file;


	public FileSystemResource(String filePath) {
		Assert.notNull(filePath," not be null");
		this.filePath = filePath;
		this.file = new File(filePath);
	}

	public FileSystemResource(File file) {
		Assert.notNull(file," not be null");
		this.file = file;
		this.filePath = file.getPath();
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
