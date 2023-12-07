package com.qa.magneto.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.magnet.factory.DriverFactory;
import com.qa.magneto.pages.AccountPage;
import com.qa.magneto.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	AccountPage accountPage;
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_properties();
		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		
	
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
