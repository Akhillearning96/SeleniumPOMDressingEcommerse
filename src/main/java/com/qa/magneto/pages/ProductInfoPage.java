package com.qa.magneto.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.magneto.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	ElementUtil eleUtil;
	HashMap<String,String> listOfData;
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By headerName = By.xpath("//h1[@class='page-title']/span");
	private By productPrice = By.xpath("//div[@class='product-info-price']//span[@id='product-price-1108']");
	private By sizeOfProd = By.cssSelector("div.swatch-attribute-options.clearfix div");
	private By qtyRequired = By.xpath("//input[@id='qty']");
	private By addToCart = By.id("product-addtocart-button");
	private By prodPictures = By.xpath("(//div[@class='fotorama__stage__shaft fotorama__grab']/div)[1]/img");
	private By productInfoLink = By.xpath("(//a[@class='data switch'])[2]");
	private By productInfoListKey = By.xpath("//table[@id='product-attribute-specs-table']/tbody/tr/th");
	private By productInfoListValue = By.xpath("//table[@id='product-attribute-specs-table']/tbody/tr/td");
	private By selectColor = By.xpath("//div[@id='option-label-color-93-item-57']");
	private By selectCart = By.xpath("//a[@class='action showcart']");
	private By productCountInAddToCart = By.xpath("//span[@class='counter-number']");
	
	public String getHeaderName() {
		return eleUtil.getElement(headerName).getText();
		
	}
	public void prodImagesCount() {
		WebElement element = eleUtil.getElement(prodPictures);
	}
	public HashMap<String,String> getProductData() {
		listOfData = new HashMap<String,String>();
		costData();
		prodListData();
		return listOfData;
	}
	private void costData() {
		String price = eleUtil.getElement(productPrice).getText();
		 listOfData.put("price", price);
	}
	private void prodListData() {
		eleUtil.doClick(productInfoLink);
		List<WebElement> listOfKey = eleUtil.getElements(productInfoListKey);
		List<WebElement> listOfValue = eleUtil.getElements(productInfoListValue);
		for(int i=0;i<listOfKey.size();i++) {
			String key = listOfKey.get(i).getText();
			String value = listOfValue.get(i).getText();
			listOfData.put(key, value);
		}
	}
	
	public void selectSizeOfProd(String size) {
		List<WebElement> prodSize = eleUtil.getElements(sizeOfProd);
		for(WebElement e : prodSize) {
			String proSize = e.getText();
			if(proSize.equals(size)) {
				System.out.println("size of product is :"+ proSize);
				e.click();
				break;	
			}
			
		}
	
		
	}
	public void qtyRequiredToOrder(String num) {
		eleUtil.getElement(qtyRequired).clear();
		eleUtil.getElement(qtyRequired).sendKeys(num);
	}
	public String addToCart() {
		eleUtil.doClick(addToCart, 5);
		return eleUtil.getElement(productCountInAddToCart).getText();
	}
	public void selectColor() {
		eleUtil.doClick(selectColor);
	}
	public void openCart() {
		eleUtil.doClick(selectCart);
	}
	
	
}
