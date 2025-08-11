package com.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
	
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public static byte[] saveScreenshotPNG(WebDriver driver) {
		
		return null;
		
	}
}
