package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtil {
	
	/**
	 * This method reads property value from application.properties
	 * @param filePath
	 * @param locatorKey
	 * @return laoctorVal
	 */
	public static String getProperty(String filePath , String locatorKey) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File to load properties file: "+ filePath);
		}
		
		return prop.getProperty(locatorKey);
	}

}
