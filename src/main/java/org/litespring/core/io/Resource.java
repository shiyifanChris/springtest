package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
public interface Resource {
	InputStream getInputStream() throws IOException;
}
