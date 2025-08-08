package com.ve3globaltest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;
import com.ve3globaltest.base.TestBase;

public class Homepage {
	
	
	public String getHomePageUrl() {
		String url = TestBase.driver.getCurrentUrl();
		return url;
	}

	
	
	
	
	

}
