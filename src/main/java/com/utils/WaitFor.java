package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ve3globaltest.base.TestBase;

public class WaitFor {
	
	static WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(20));
	
	public static void elementToBeVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void elementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}

}
