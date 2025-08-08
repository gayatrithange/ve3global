package com.ve3globaltest.tasks;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.datadriventesting.DataProviders;
import com.ve3globaltest.base.TestBase;
import com.ve3globaltest.pages.CartPage;
import com.ve3globaltest.pages.Homepage;
import com.ve3globaltest.pages.LoginPage;

public class HomePageTests extends TestBase {
	/**
	 * This Method Verifies that the homepage loads successfully after a valid login.
	 * 
	 * Objective: Ensure the homepage loads successfully after a valid login
	 * 
	 * Action:
	 * - Perform login using valid credentials.
	 * - Assert that the homepage is displayed.
	 * 
	 * Approach:Used Data-Driven Testing for Username and Password input to validate
	 * multiple credential sets.
	 */
	@Test(dataProvider = "validCredentials", dataProviderClass = DataProviders.class)
	public void verifyHomepageLoadsAfterValidLogin(String username, String password) {
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickOnLogin();
	Homepage homepage = PageFactory.initElements(driver, Homepage.class);
	String homePageUrl = homepage.getHomePageUrl();
	Assert.assertTrue(homePageUrl.contains("inventory.html"), "HomePage is not Loaded");
	}
	
	
	/**
	 * Objective: Verify that product filtering (Low to High Price) works correctly.
	 * 
	 * Action:
	 * -Apply the filter: Sort by Price – Low to High.
	 * -Extract and print the list of product names after filtering.
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
	 * Objective: Validate cart functionality.
	 * Action:
	 * - Select a product from the filtered list.
	 * - Add the selected product to the cart.
	 * - Assert that the product is successfully added to the cart.
	 */
	@Test
	public void validateCartFunctionality() {
		String item1 = "Sauce Labs Backpack";
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickOnLogin();
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.selectFilter("lohi"); // Low to High
		homepage.addItemToCart(item1);
		homepage.clickOnCart();
		CartPage cartpage =PageFactory.initElements(driver, CartPage.class);
		String cartItem = cartpage.getCartItem();
		Assert.assertTrue(cartItem.equalsIgnoreCase(item1));
	}
	

	
	
		

}
