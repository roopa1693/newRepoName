package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Roopa
 *
 */
	
public class FileUtility {

	/**
	 * 
	 * its used to get common data from property file based on key which you have specified as a argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.fPath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
}
