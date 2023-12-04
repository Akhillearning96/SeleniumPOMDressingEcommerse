package com.qa.magneto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By loginHeader = By.xpath("//span[text()='Customer Login']");
	private By createAccBtn = By.xpath("(//span[text()='Create an Account'])[1]");
	private By username = By.id("email");
	private By password = By.id("pass");
	private By signInBtn = By.id("send2");
	
	public String getLPTitle() {
		return driver.getTitle();
	}
	public String getLPURL() {
		return driver.getCurrentUrl();
	}
	public String isHeaderTitlePresent() {
		return driver.findElement(loginHeader).getText();
		
	}
	public String isCreateAccBtnPresent() {
		return  driver.findElement(createAccBtn).getText();
	}
	public void doLogin(String un , String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		
	}
	
	
	
}
