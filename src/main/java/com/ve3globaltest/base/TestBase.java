package com.ve3globaltest.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utils.ApplicationUtil;



public class TestBase {
	public static RemoteWebDriver driver = null;

	@BeforeClass
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();

		// Disable Chrome password manager + breach detection
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false); // no breach warnings
		prefs.put("credentials_enable_service", false); // disable save password prompts
		prefs.put("profile.password_manager_enabled", false); // disable password manager entirely

		options.setExperimentalOption("prefs", prefs);

		switch ((ApplicationUtil.getBrowserName()).toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
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



	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	



}
