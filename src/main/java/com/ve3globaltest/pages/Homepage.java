package com.ve3globaltest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;
import com.ve3globaltest.base.TestBase;

public class Homepage {
	
	@FindBy(css = "a#SeersCMPBannerBotDetectionAcceptButton")
	WebElement clickOnAllowCookies;
	
	public void clickOnAllowCookies() {
		WaitFor.elementToBeVisible(clickOnAllowCookies);
		clickOnAllowCookies.click();
	}
	
	public String getHomePageTitle() {
		String title = TestBase.driver.getTitle();
		return title;
	}
	
	@FindBy(css = "div.elementor-element-465270d div[data-id=\"e4b7bd6\"]")
	WebElement clickOnSearchBtn;
	
	public void clickOnSearchBtn() {
		WaitFor.elementToBeClickable(clickOnSearchBtn);
		clickOnSearchBtn.click();
	}
	
	@FindBy(xpath ="//input[contains(@placeholder,\"Type & Hit Enter\")]")
	WebElement clickAndSendKeyOnSearchInputbox;
	
	public void clickOnSearchInputbox() {
		WaitFor.elementToBeVisible(clickAndSendKeyOnSearchInputbox);
		clickAndSendKeyOnSearchInputbox.click();
	}
	
	public void sendDataOnSearchBar(String key) {
		clickAndSendKeyOnSearchInputbox.sendKeys(key);
	}
	
	public void clickEnterKey() {
		clickAndSendKeyOnSearchInputbox.sendKeys(Keys.ENTER);
	}
	
	
	

}
