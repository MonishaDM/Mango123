package com.IB.genericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility_Test {
	/**
	 * This method will fetch common data from property file
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
