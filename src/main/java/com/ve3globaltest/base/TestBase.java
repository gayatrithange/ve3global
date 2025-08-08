package com.ve3globaltest.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.ApplicationUtil;

public class TestBase {
	public static RemoteWebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		switch ((ApplicationUtil.getBrowserName()).toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
		driver.get(ApplicationUtil.getAppURL());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
