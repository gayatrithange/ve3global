package com.utils;



public class ApplicationUtil {
	static String baseDir = System.getProperty("user.dir");
	static String filePath = baseDir + "/src/main/resources/application.properties";
	
	/**
	 * This methods retrieves browser name
	 * @return browser_name
	 */
	public static String getBrowserName() {
		String browserName = FileUtil.getProperty(filePath, "browser_name");
		//System.out.println("browserName.."+browserName);
		return browserName;
	}
	
	/**
	 * This method retrieves app URL
	 * @return 
	 */
	public static String getAppURL() {
		String appURL = FileUtil.getProperty(filePath, "base_url");
		//System.out.println("appURL.."+appURL);
		return appURL;
	}

}
