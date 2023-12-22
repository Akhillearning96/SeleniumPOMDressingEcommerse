package com.qa.magneto.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.magneto.utils.ElementUtil;

public class ShippingPage {
	private WebDriver driver;
	ElementUtil eleUtil;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver ;
		eleUtil = new ElementUtil(driver);
	}
	
	
	private By itemAddConfirmation = By.xpath("(//strong[@role='heading'])[2]/span");
	
	public String pageTitle() {
		return driver.getTitle();
		
	}
	public List<String> itemCOnfirmTest() {
		List<WebElement> list = eleUtil.getElements(itemAddConfirmation);
		List<String> linkList = new ArrayList<String>();
		for(WebElement e : list) {
			String text = e.getText();
			linkList.add(text);
		}
		return linkList;
	}

}
