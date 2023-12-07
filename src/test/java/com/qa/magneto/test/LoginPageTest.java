package com.qa.magneto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.magneto.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		String title = loginpage.getLPTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void headerTitleTest() {
		String headerTitle = loginpage.isHeaderTitlePresent();
		Assert.assertEquals(headerTitle, Constants.LOGIN_PAGE_HEADER_TITLE);
	}
	@Test(priority=3)
	public void createAccountBtnTest() {
		String btnText = loginpage.isCreateAccBtnPresent();
		Assert.assertEquals(btnText, Constants.LOGIN_PAGE_CREATE_ACCOUNT_BUTTON);
	}
	@Test(priority=4)
	public void doLoginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.getAccPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
		
	}
	

}
