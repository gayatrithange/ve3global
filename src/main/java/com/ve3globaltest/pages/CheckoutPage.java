package com.ve3globaltest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;

public class CheckoutPage {
	
	@FindBy(css = "a.checkout_button")
	WebElement checkoutBtn;
	
	public void clickOnCheckoutBtn() {
		WaitFor.elementToBeVisible(checkoutBtn);
		checkoutBtn.click();
	}
	
	@FindBy(xpath = "//input[@id ='first-name']")
	WebElement firstName;
	
	public void enterFirstName(String firstname) {
		firstName.click();
		firstName.sendKeys(firstname);
	}
	
	@FindBy(xpath = "//input[@id = 'last-name']")
	WebElement lastName;
	
	public void enterLastName(String lastname) {
		lastName.click();
		lastName.sendKeys(lastname);
	}
	
	@FindBy(xpath = "//input[@id = 'postal-code']")
	WebElement postalCode;
	
	public void enterPostalCode(String pincode) {
		postalCode.click();
		postalCode.sendKeys(pincode);
	}
	
	@FindBy(css = "input.cart_button")
	WebElement continueBtn;
	
	public void clickOnContinue() {
		continueBtn.click();
	}
	
	@FindBy(css = "a.cart_button")
	WebElement finishBtn;
	
	public void clickOnFinish() {
		WaitFor.elementToBeClickable(finishBtn);
		finishBtn.click();
	}
	
	@FindBy(css = "h2.complete-header")
	WebElement completedMsg;
	
	public String getCompletedMsg() {
		WaitFor.elementToBeVisible(completedMsg);
		String msg = completedMsg.getText();
		return msg;
	}

}
