package com.ve3globaltest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage {
	
	@FindBy(css ="input#user-name")
	WebElement enterUserName;
	
	public void enterUserName(String username) {
		enterUserName.click();
		enterUserName.sendKeys(username);
	}
	
	@FindBy(css ="input#password")
	WebElement enterPassword;
	
	public void enterPassword(String password) {
		enterPassword.click();
		enterPassword.sendKeys(password);
	}
	
	@FindBy(css = "input#login-button")
	WebElement clickOnLogin;
	
	public void clickOnLogin() {
		clickOnLogin.click();
	}

}
