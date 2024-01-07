package com.qa.magneto.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.magneto.pages.ProductInfoPage;
import com.qa.magneto.pages.ResultPage;
import com.qa.magneto.utils.Constants;

public class AccountTest extends BaseTest {
	@BeforeClass
	public void accPagePreConditions() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@Test(priority = 1)
	public void getPageTitle() {
		
		String title = accountPage.getAccPageTitle();
		AssertJUnit.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	@Test(priority =2)
	public void headerDropDownTest() {
		List<String> actData = accountPage.headerDropDowns();
		AssertJUnit.assertEquals(actData, Constants.actHeaderDropDown());
	}
	@Test(priority =3)
	public void accountPageLinksTest() {
		List<String> accPageData = accountPage.accPageLinks();
		AssertJUnit.assertEquals(accPageData, Constants.accPageLinksCheck());
	}
	@DataProvider
	public Object[][] multiProdSearch() {
		return new Object[][] {
			{"men t-shirt"},
			{"lady t-shirt"}
		};
	}
	@Test(priority = 4, dataProvider= "multiProdSearch")
	public void multiProdSearchTest(String multiProdSearch) {
		accountPage.doSearch(multiProdSearch);
	}
	
	@DataProvider
	public Object[][] productSearch() {
		return new Object[][] {
			
				{"yoga"}
		};
	}
	
	@Test(priority =5,dataProvider = "productSearch")
	public void searchProdTest(String prodName) {
		 ResultPage resultPage = accountPage.doSearch(prodName);
		String title = resultPage.getPageTitle();
		AssertJUnit.assertEquals(title, Constants.RESULT_PAGE_TITLE);
	}
	@DataProvider
	public Object[][] productSelect() {
		return new Object[][] {
				{"yoga","Selene Yoga Hoodie"}
		};
	}
	@Test(priority =6,dataProvider="productSelect")
	public void selectProductTest(String productName,String mainProductName) {
		 ResultPage resultPage = accountPage.doSearch(productName);
		ProductInfoPage productInfoPage =  resultPage.selectProduct(mainProductName);
		
		
	}
	
	
	
	

}
