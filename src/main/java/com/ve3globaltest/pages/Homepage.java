package com.ve3globaltest.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.utils.WaitFor;
import com.ve3globaltest.base.TestBase;

public class Homepage {
	
	
	public String getHomePageUrl() {
		String url = TestBase.driver.getCurrentUrl();
		return url;
	}
	
	@FindBy(xpath = "//select[@class ='product_sort_container']")
	WebElement selectFilter;
	
	public void selectFilter(String value) {
		WaitFor.elementToBeClickable(selectFilter);
		Select select = new Select(selectFilter);
		select.selectByValue(value);
	}
	
	@FindBy(xpath = "(//div[@id='inventory_container'])[2]/descendant::div[@class= 'inventory_item_price']")
	List<WebElement> itemPrices;
	
	public List<Double> itemPrices() {
		List<Double> productPrices = new ArrayList();
		for(WebElement ele :itemPrices ){
			String strVal = ele.getText().replace("$", "").trim();
			double price = Double.parseDouble(strVal);
			productPrices.add(price);
		}
		return productPrices;
	}
	
	public void assertThatPriceIsSorted(List<Double> productPrices) {
		for(int i = 0; i <productPrices.size()-1; i++) {
			//System.out.println(productPrices.get(i));
			Assert.assertTrue(productPrices.get(i) <= productPrices.get(i), "Prices not sorted low to high" );
		}
	}
	
	@FindBy(xpath = "(//div[@id='inventory_container'])[2]/descendant::div[@class= 'inventory_item_name']")
	List<WebElement> itemsName;
	
	public void PrintListOfProductNames() {
		for(WebElement name : itemsName) {
			System.out.println(name.getText());
		}
	}
	
	public void addItemToCart(String item) {
		WebElement ele = TestBase.driver.findElement(By.xpath("//div[contains(text(),'"+item+"')]/ancestor::div[@class = 'inventory_item_label']/following-sibling::div/child::button"));
		WaitFor.elementToBeClickable(ele);
		ele.click();		
		
	}
	
	@FindBy(css ="a.shopping_cart_link")
	WebElement clickOnCart;
	
	public void clickOnCart() {
		clickOnCart.click();
	}

	
	
	
	
	

}
