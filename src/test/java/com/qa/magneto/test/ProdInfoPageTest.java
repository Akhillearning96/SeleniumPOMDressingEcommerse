package com.qa.magneto.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.magneto.pages.ResultPage;
import com.qa.magneto.utils.Constants;

public class ProdInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void prodPagePreConditions() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ResultPage resultPage = accountPage.doSearch("yoga");
		resultPage.selectProduct("Selene Yoga Hoodie");
	}
	@Test(priority = 1)
	public void headerNameTest() {
		String text = productInfoPage.getHeaderName();
		AssertJUnit.assertEquals(text, Constants.PRODUCT_INFO_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void productDataTest() {
		Map<String,String> data = productInfoPage.getProductData();
		data.forEach((k,v)->System.out.println(k+":"+v));
		AssertJUnit.assertEquals(data.get("price"),"$42.00");
		AssertJUnit.assertEquals(data.get("Pattern"), "Solid");
		AssertJUnit.assertEquals(data.get("Climate"), "Indoor, Mild, Spring");
		AssertJUnit.assertEquals(data.get("Style"), "Full Zip, Hoodie");
		
	}
	
	@Test(priority = 3)
	public void selectProdSizeTest() {
		productInfoPage.selectSizeOfProd("M");
		productInfoPage.selectColor();
		productInfoPage.qtyRequiredToOrder("1");
		
	}
	@Test(priority = 4)
	public void addToCartTest() {
		String count = productInfoPage.addToCart();
		//Assert.assertEquals(count, "1");
		
	}
}
	
	
