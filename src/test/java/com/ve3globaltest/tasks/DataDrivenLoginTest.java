package com.ve3globaltest.tasks;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.datadriventesting.DataProviders;
import com.utils.ApplicationUtil;
import com.ve3globaltest.base.TestBase;
import com.ve3globaltest.pages.Homepage;
import com.ve3globaltest.pages.LoginPage;

@Listeners(com.listeners.TestAllureListener.class)
public class DataDrivenLoginTest extends TestBase{
	
	@BeforeMethod(alwaysRun = true)
    public void navigateToLoginPage() {
		driver.get(ApplicationUtil.getAppURL());
    }
	
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

}
