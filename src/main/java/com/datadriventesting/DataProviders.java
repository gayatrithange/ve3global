package com.datadriventesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.utils.ExcelUtil;

public class DataProviders {
	private static String baseDir = System.getProperty("user.dir");
	
	@DataProvider(name = "validCredentials")
	public static Object[][] validCredentials(){
		String filePath = baseDir+"/src/test/resources/Excel_files/Credentials.xlsx";
		String sheetName = "Credentials";
		Object data[][] = ExcelUtil.validUsernameAndPassword(filePath, sheetName);
		System.out.println(data[1][0]);
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		validCredentials();

	}

}
