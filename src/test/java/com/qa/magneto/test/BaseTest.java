package com.qa.magneto.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.magnet.factory.DriverFactory;
import com.qa.magneto.pages.AccountPage;
import com.qa.magneto.pages.LoginPage;
import com.qa.magneto.pages.ProductInfoPage;
import com.qa.magneto.pages.ResultPage;
import com.qa.magneto.pages.ShippingPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	AccountPage accountPage;
	ResultPage resultPage;
	ProductInfoPage productInfoPage;
	ShippingPage shippingPage;
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_properties();
		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		resultPage = new ResultPage(driver);
		productInfoPage = new ProductInfoPage(driver);
		shippingPage = new ShippingPage(driver);
	
	}
	@AfterTest
	public void teardown() {
		//driver.quit();
	}

}
