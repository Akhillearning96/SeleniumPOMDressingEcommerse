package com.qa.magneto.test;

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
	@Test
	public void headerNameTest() {
		String text = productInfoPage.getHeaderName();
		Assert.assertEquals(text, Constants.PRODUCT_INFO_PAGE_TITLE);
	}
	@Test
	public void productDataTest() {
		Map<String,String> data = productInfoPage.getProductData();
		data.forEach((k,v)->System.out.println(k+":"+v));
		Assert.assertEquals(data.get("price"),"$42.00");
		Assert.assertEquals(data.get("Pattern"), "Solid");
		Assert.assertEquals(data.get("Climate"), "Indoor, Mild, Spring");
		Assert.assertEquals(data.get("Style"), "Full Zip, Hoodie");
		
	}
	
	@Test
	public void selectProdSizeTest() {
		productInfoPage.selectSizeOfProd("M");
		productInfoPage.selectColor();
		productInfoPage.qtyRequiredToOrder("1");
		
	}
	@Test
	public void addToCartTest() {
		String count = productInfoPage.addToCart();
		//Assert.assertEquals(count, "1");
		
	}
}
	
	
