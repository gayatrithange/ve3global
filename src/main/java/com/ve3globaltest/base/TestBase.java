package com.ve3globaltest.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	    options.setExperimentalOption("useAutomationExtension", false);

	    // Add a random user-agent
	    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
	            + "(KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36";
	    options.addArguments("--user-agent=" + userAgent);
	    
		switch((ApplicationUtil.getBrowserName()).toLowerCase()) {
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
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}
