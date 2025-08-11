package com.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ve3globaltest.base.TestBase;

import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Listener triggered for failure");
	    System.out.println("Driver instance: " + TestBase.driver);
	    saveScreenshotPNG(TestBase.driver);
	}

	
	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] saveScreenshotPNG(RemoteWebDriver driver) {
		 if (driver == null) {
	            System.out.println("Driver is null! Cannot take screenshot.");
	            return new byte[0];
	        }else {
	        	 System.out.println("screenshot captured.....");
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        }
		
	}
	
}
