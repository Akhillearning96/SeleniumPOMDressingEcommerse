package com.qa.magneto.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.magneto.utils.Constants;

public class AccountTest extends BaseTest {
	@BeforeClass
	public void accPagePreConditions() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@Test(priority = 1)
	public void getPageTitle() {
		
		String title = accountPage.getAccPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
//	@Test(priority =2)
//	public void confirmMessageTest() {
//		String text = accountPage.confirmLoginMessage();
//		Assert.assertEquals(text, Constants.LOGIN_CONFIRM_MESSAGE);
//	}
	@Test(priority =3)
	public void headerDropDownTest() {
		List<String> actData = accountPage.headerDropDowns();
		Assert.assertEquals(actData, Constants.actHeaderDropDown());
	}
	@Test(priority =4)
	public void accountPageLinksTest() {
		List<String> accPageData = accountPage.accPageLinks();
		Assert.assertEquals(accPageData, Constants.accPageLinksCheck());
	}
	

}
