package com.qa.magneto.pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.magneto.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	ElementUtil eleUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	private By welcomeMessage = By.xpath("(//ul[@class='header links']/li[@class='greet welcome']/span)[1]");
	private By HeaderDropDowns = By.xpath("//nav[@class='navigation']/ul[@id='ui-id-2']/li/a");
	private By accountPageLinks = By.xpath("//ul[@class='nav items']/li/a");
	private By signOut = By.linkText(" Sign Out ");
	private By id = By.id("search");
	
	public String getAccPageTitle() {
		return driver.getTitle();
	}
	public String confirmLoginMessage() {
		return eleUtil.doGetText(welcomeMessage);
	}
	public List<String> headerDropDowns() {
		List<WebElement>  headerList = eleUtil.getElements(HeaderDropDowns);
		List<String> list = new ArrayList<String>();
		for(WebElement e : headerList) {
			String text = e.getText();
			list.add(text);
		}
		return list;
	}
	public List<String> accPageLinks() {
		List<WebElement> accLinksList = eleUtil.getElements(accountPageLinks);
		List<String> linksList = new ArrayList<String>();
		for(WebElement e : accLinksList) {
			String text = e.getText();
			linksList.add(text);
		}
		return linksList;	
	}
	public boolean signOutLinkExist() {
		eleUtil.clickElementWhenReady(HeaderDropDowns, 5);
		return eleUtil.getElement(signOut).isDisplayed();
	}
	public void doSearch(String productName) {
		eleUtil.doSendKeys(id, productName);
		eleUtil.doClick(id);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(id).clear();
	}
	
}
