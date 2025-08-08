package com.ve3globaltest.tasks;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ve3globaltest.base.TestBase;
import com.ve3globaltest.pages.Homepage;

public class HomePageTests extends TestBase {
	/**
	 * This method Verifies that the Ve3.global homepage loads successfully.
	 */
	@Test
	public void verifyHomepageLoadsSucessfully() {
	Homepage homepage = PageFactory.initElements(driver, Homepage.class);
	String title = homepage.getHomePageTitle();
	homepage.clickOnAllowCookies();
	Assert.assertTrue(title.contains("VE3 - Value") , "Homepage did not load Sucessfully");
	
	}
	
	
	/**
	 * Perform a search using the search bar and verify that search results are displayed
	 */
	@Test
	public void verifySearchFunctionalityDisplaysResults() {
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.clickOnAllowCookies();
		homepage.clickOnSearchBtn();
		homepage.clickOnSearchInputbox();
		homepage.sendDataOnSearchBar("SAP");
		homepage.clickEnterKey();
	}
	
	
		

}
