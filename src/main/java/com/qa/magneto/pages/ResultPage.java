package com.qa.magneto.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.magneto.utils.ElementUtil;

public class ResultPage {
	private WebDriver driver;
	ElementUtil eleUtil;
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By searchProdCount = By.cssSelector(".products.wrapper.grid.products-grid ol li");
	//private By selectProduct = By.cssSelector(".products.wrapper.grid.products-grid ol li div a.product.photo");
	private By pageTitle = By.cssSelector(".page-title span");
	private By prodSelect = By.xpath("//div[@class='search results']//div/ol/li/div/div/strong/a");
	
	public String getPageTitle() {
		return eleUtil.getElement(pageTitle).getText();
		
	}
	public int prodResultCount() {
		return eleUtil.getElements(searchProdCount).size();
	}
	public ProductInfoPage selectProduct(String productName) {
		List<WebElement> searchProd = eleUtil.WaitForTheAllElementToBeVisible(prodSelect, 5);
		for(WebElement e : searchProd) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(productName)) {
				e.click();
				break;
			}
			
		}
		return new ProductInfoPage(driver);
		
		
	}
	
	
	

}
