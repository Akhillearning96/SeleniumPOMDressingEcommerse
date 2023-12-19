package com.qa.magnet.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	Properties prop;
	OptionManager optionManager;
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		optionManager = new OptionManager(prop);
		
	 
	 if(browserName.equals("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(optionManager.getChromeOptions());
		
	 }else if(browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.get(prop.getProperty("url"));
		
	 return driver;
	}
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/Configration/Config.Properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}

}
