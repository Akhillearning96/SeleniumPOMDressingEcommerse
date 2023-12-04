package com.qa.magnet.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	
	
	
	public WebDriver init_driver(String browserName) {
		
	 
	 if(browserName.equals("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	 }else if(browserName.equals("firefox")) {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
		
	 return driver;
	}

}
