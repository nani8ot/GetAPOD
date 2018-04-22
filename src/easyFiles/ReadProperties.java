package easyFiles;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public String getProperties(String path, String property) throws IOException {
		Properties properties = new Properties();
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
		properties.load(in);
		in.close();
		String propertyVal = properties.getProperty(property);
		
		return propertyVal;
		
	}
}
