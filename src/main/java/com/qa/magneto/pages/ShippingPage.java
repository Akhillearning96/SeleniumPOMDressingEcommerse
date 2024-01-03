package com.qa.magneto.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.magneto.utils.ElementUtil;

public class ShippingPage {
	private WebDriver driver;
	ElementUtil eleUtil;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver ;
		eleUtil = new ElementUtil(driver);
	}
	
	
	private By itemAddConfirmation = By.xpath("(//strong[@role='heading'])[2]/span");
	private By pageHeader = By.xpath("//div[text()='Shipping Address']");
	private By streetAddress = By.xpath("//input[@class='input-text' and @id='C7CEDBK']");
	private By city = By.xpath("//input[@class='input-text' and @id='YIP27NB']");
	private By province = By.xpath("(//select[@class='select'])[1]");
	private By zip = By.xpath("//input[@class='input-text' and @id='EVYS0EK']");
	private By country = By.xpath("(//select[@class='select'])[2]");
	private By phoneNo = By.xpath("By.xpath(\"//input[@class='input-text' and @id='J99JGR2']");
	private By radioButton = By.xpath("(//span[@class='price']/parent::td/preceding-sibling::td)[1]");
	private By button = By.xpath("//button[@class='button action continue primary']");
	
	
	
	public String pageTitle() {
		return driver.getTitle();
		
	}
	public String pageHeaderTitle() {
		return eleUtil.WaitForTheElementToBeVisible(pageHeader, 10).getText();
	}
	public void shippingPersonDetails(String streetName,String cityName,String state,String zipCode,String countryName,String phoneNum) {
		eleUtil.WaitForTheElementToBeVisible(streetAddress, 10).sendKeys(streetName);
		eleUtil.WaitForTheElementToBeVisible(city, 10).sendKeys(cityName);
		Select st = new Select(eleUtil.WaitForTheElementToBeVisible(province, 10));
		List<WebElement> listOfState = st.getOptions();
		for(WebElement e:listOfState) {
			 String text = e.getText();
			 if(text.equals(state)) {
				 e.click();
				 break;
			 }
		}
		eleUtil.doSendKeys(zip, zipCode);
		Select sc = new Select(eleUtil.WaitForTheElementToBeVisible(country, 10));
		List<WebElement>  listOfCountries = sc.getOptions();
		for(WebElement e : listOfCountries) {
			String text = e.getText();
			if(text.equals(countryName)) {
				e.click();
				break;
			}
		}
		eleUtil.WaitForTheElementToBeVisible(phoneNo, 10).sendKeys(phoneNum);
		
		
		eleUtil.clickElementWhenReady(radioButton, 10);
		eleUtil.clickElementWhenReady(button, 10);
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