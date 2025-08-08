package com.ve3globaltest.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;

public class CartPage {
	@FindBy(css ="div.cart_item_label div.inventory_item_name")
	WebElement cartItem;
	
	public String getCartItem() {
		WaitFor.elementToBeVisible(cartItem);
		String item = cartItem.getText();
		return item;
	}
	
	

}
