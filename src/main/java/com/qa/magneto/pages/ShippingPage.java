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
	private By radioButton = By.xpath("(//input[@type='radio'])[1]");
	private By button = By.xpath("//button[@class='button action continue primary']");
	
	
	
	public String pageTitle() {
		return driver.getTitle();
		
	}
	public String pageHeaderTitle() {
		return eleUtil.doGetText(pageHeader);
	}
	public void shippingPersonDetails(String streetName,String cityName,String state,String zipCode,String countryName,String phoneNum) {
		eleUtil.doSendKeys(streetAddress, streetName);
		eleUtil.doSendKeys(city, cityName);
		eleUtil.doSendKeys(zip, zipCode);
		eleUtil.doSendKeys(phoneNo,phoneNum);
		Select st = new Select(eleUtil.getElement(province));
		List<WebElement> listOfState = st.getOptions();
		for(WebElement e:listOfState) {
			 String text = e.getText();
			 if(text.equals(state)) {
				 e.click();
				 break;
			 }
		}
		Select sc = new Select(eleUtil.getElement(country));
		List<WebElement>  listOfCountries = sc.getOptions();
		for(WebElement e : listOfCountries) {
			String text = e.getText();
			if(text.equals(countryName)) {
				e.click();
				break;
			}
		}
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
