package com.ve3globaltest.tasks;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.listeners.TestAllureListener;
import com.ve3globaltest.base.TestBase;
import com.ve3globaltest.pages.CartPage;
import com.ve3globaltest.pages.CheckoutPage;
import com.ve3globaltest.pages.Homepage;
import com.ve3globaltest.pages.LoginPage;

@Listeners(TestAllureListener.class)
public class ProductCheckOutFlow extends TestBase {

	/**
	 * Objective: Verify that product filtering (Low to High Price) works correctly.
	 * 
	 * Action: -Apply the filter: Sort by Price – Low to High. -Extract and print
	 * the list of product names after filtering.
	 */
	@Test
	public void verifyProductFilterPriceLowToHigh() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickOnLogin();
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.selectFilter("lohi"); // Low to High
		List<Double> sortedPrices = homepage.itemPrices();
		homepage.PrintListOfProductNames();
		homepage.assertThatPriceIsSorted(sortedPrices);

	}

	/**
	 * Objective: Validate cart functionality. Action: - Select a product from the
	 * filtered list. - Add the selected product to the cart. - Assert that the
	 * product is successfully added to the cart.
	 */
	@Test(dependsOnMethods = "verifyProductFilterPriceLowToHigh")
	public void validateCartFunctionality() {
		String item1 = "Sauce Labs Onesie";
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		/*
		 * LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		 * loginpage.enterUserName("standard_user");
		 * loginpage.enterPassword("secret_sauce"); loginpage.clickOnLogin(); Homepage
		 * homepage = PageFactory.initElements(driver, Homepage.class);
		 * homepage.selectFilter("lohi");
		 */ // Low to High
		homepage.addItemToCart(item1);
		homepage.clickOnCart();
		CartPage cartpage = PageFactory.initElements(driver, CartPage.class);
		String cartItem = cartpage.getCartItem();
		AssertJUnit.assertTrue(cartItem.equalsIgnoreCase(item1));
	}

	/**
	 * Objective: Ensure a user can successfully complete a purchase. Action: -
	 * Proceed to checkout. - Fill in required details (if any). - Complete the
	 * purchase process. - Assert the order confirmation or success message.
	 */
	@Test(dependsOnMethods = "validateCartFunctionality")
	public void validateCheckoutFunctionality() {
		/*
		 * String item1 = "Sauce Labs Backpack"; LoginPage loginpage =
		 * PageFactory.initElements(driver, LoginPage.class);
		 * loginpage.enterUserName("standard_user");
		 * loginpage.enterPassword("secret_sauce"); loginpage.clickOnLogin(); Homepage
		 * homepage = PageFactory.initElements(driver, Homepage.class);
		 * homepage.selectFilter("lohi"); // Low to High homepage.addItemToCart(item1);
		 * homepage.clickOnCart();
		 */
		CheckoutPage checkout = PageFactory.initElements(driver, CheckoutPage.class);
		checkout.clickOnCheckoutBtn();
		checkout.enterFirstName("dev");
		checkout.enterLastName("shah");
		checkout.enterPostalCode("1234");
		checkout.clickOnContinue();
		checkout.clickOnFinish();
		String msg = checkout.getCompletedMsg();
		Assert.assertTrue(msg.contains("THANK YOU"));
	}
	

}
