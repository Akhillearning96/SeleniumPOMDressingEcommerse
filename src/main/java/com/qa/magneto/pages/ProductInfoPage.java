package com.qa.magneto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {
	private WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	private By headerName = By.xpath("//h1[@class='page-title']/span");
	
	
	
	
}
